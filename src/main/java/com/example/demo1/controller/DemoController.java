package com.example.demo1.controller;

import com.example.demo1.dto.UserDto;
import com.example.demo1.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;


@Controller
@Slf4j
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;
    @GetMapping(value = "/findName")
    public ModelAndView findName(ModelAndView mv, String id){
        log.info("?????????????????????123");

        String name = demoService.idToName(id);

        log.info("name:::{}", name);

        mv.addObject("id", id);
        mv.addObject("name", name);
        mv.setViewName("test.html");
        return mv;
    }

    @GetMapping(value = "/")
    public ModelAndView find(ModelAndView mv){
        log.info("?????????????????????123");
        demoService.connectionTest();
        mv.addObject("name", "name");
        mv.setViewName("test.html");
        return mv;
    }

    @RequestMapping(value = "/demo" , method = RequestMethod.GET)
    public ModelAndView demo(ModelAndView mv, String id){

        // 네임 찾기
        String name = demoService.idToName(id);

        // 네임이 소속된 스터디 그룹 찾기
        String sc = demoService.findService(name);

        mv.addObject("sc", sc);
        mv.setViewName("test2.html");
        return mv;
    }

    @RequestMapping(value = "/PostDemo" , method = RequestMethod.POST)
    public ModelAndView postDemo(ModelAndView mv, String id){

        // 네임 찾기
//        String name = demoService.idToName(id);
//
//        // 네임이 소속된 스터디 그룹 찾기
//        String sc = demoService.findService(name);
        demoService.connectionTest();

        mv.addObject("msg", "post 전송 성공");
        mv.setViewName("test3.html");
        return mv;
    }

    @GetMapping(value = "/findUser")
    public ModelAndView findUser(ModelAndView mv, Long seq){

        UserDto userDto = demoService.findUser(seq);

        log.info("seq : {} , email : {}, passwd: {}, create_at {} ",
                userDto.getSeq(), userDto.getEmail(), userDto.getPasswd(), userDto.getCreate_at());

        mv.addObject("email", userDto.getEmail());
        mv.addObject("passwd", userDto.getPasswd());
        mv.setViewName("test4.html");
        return mv;
    }

}
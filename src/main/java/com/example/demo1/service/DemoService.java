package com.example.demo1.service;

import com.example.demo1.dto.UserDto;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
@Slf4j
@RequiredArgsConstructor
public class DemoService {

    private final SqlSessionFactory sqlSessionFactory;
    private final UserMapper userMapper;

    public String idToName(String id){

        String name = "";
        if(id.equals("liu")){
            name = "김연우";
        }else if(id.equals("2")){
            name = "뽀삐";
        }else{
            name = "밍키";
        }

        return name;
    }

    public String findService(String name){
        String service = "";
        if(name.equals("김연우")){
            service = "11";
        }else if(name.equals("뽀삐")){
            service = "22";
        }else{
            service = "33";
        }

        return service;
    }

    public void connectionTest(){
        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            log.info("커넥션 성공");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public UserDto findUser(Long seq) {

        return userMapper.findById(seq);
    }

}

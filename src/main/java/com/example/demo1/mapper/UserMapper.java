package com.example.demo1.mapper;

import com.example.demo1.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS")
    List<UserDto> findAll();

    @Select("SELECT * FROM USERS where seq = #{seq}")
    UserDto findById(Long seq);

}

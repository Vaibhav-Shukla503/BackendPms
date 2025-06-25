package com.practice2.fightmaro.Service;

import com.practice2.fightmaro.Payloads.UserDto;

import java.util.List;

public interface UserService {

       UserDto createUser(UserDto user);
       UserDto updateUser(UserDto user,Integer id);
       UserDto getUserById(Integer id);
       List<UserDto> getAllUsers();
       void deleteUser(Integer id);
}

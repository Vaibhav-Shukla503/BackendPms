package com.practice2.fightmaro.Service.serviceImpl;

import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Payloads.UserDto;
import com.practice2.fightmaro.Repositories.UserRepo;
import com.practice2.fightmaro.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


@Autowired
    private UserRepo userRepo;
@Autowired
    private ModelMapper modelMapper;



    @Override
   public  UserDto createUser(UserDto userDto)
    {
         User user=this.dtoToUser(userDto);
         user.setRole(userDto.getRole());
                 User savedUser=this.userRepo.save(user);
         return this.userToUserdto(savedUser);
    }

    @Override
  public   UserDto updateUser(UserDto userdto,Integer id){

        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userdto.getName());
        user.setPassword(userdto.getPassword());
        user.setEmail(userdto.getEmail());
        user.setMobno(userdto.getMobno());
        user.setAddress(userdto.getAddress());

        User Updated=userRepo.save(user);
        return this.userToUserdto(Updated);
    }

    @Override
    public UserDto getUserById(Integer id)
    {
        User user =this.userRepo.findById(id).orElseThrow();
        return this.userToUserdto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users=this.userRepo.findAll();
        List<UserDto> userDtos=users.stream().map(user-> this.userToUserdto(user)).collect(Collectors.toList());
     return userDtos;
    }

    @Override
    public void deleteUser(Integer id) {

        User user=this.userRepo.findById(id).orElseThrow();
        this.userRepo.delete(user);

    }



    public User dtoToUser(UserDto userDto)
    {
        User user = this.modelMapper.map(userDto,User.class);
        return user;
    }
    public UserDto userToUserdto(User user)
    {
        UserDto userDto = this.modelMapper.map(user,UserDto.class);
        return userDto;

    }


}

package com.practice2.fightmaro.Controllers;

import com.practice2.fightmaro.Payloads.UserDto;
import com.practice2.fightmaro.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //post-create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUsers(@Valid @RequestBody UserDto userDto) {

      UserDto userDto1=  this.userService.createUser(userDto);
       return  new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }
    // update
     @PutMapping("/{userid}")
    public ResponseEntity<UserDto> updateUsers( @RequestBody UserDto userDto, @PathVariable int userid) {
    userService.updateUser(userDto,userid);
        return  new ResponseEntity<>(userDto,HttpStatus.OK);
     }
    //delete
     @DeleteMapping("/{userid}")
    public ResponseEntity<UserDto> deleteUsers(@PathVariable int userid) {
        userService.deleteUser(userid);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
     @GetMapping("/{userid}")
    public ResponseEntity<UserDto> getUsers(@PathVariable int userid) {
        userService.getUserById(userid);
        return  new ResponseEntity<>(userService.getUserById(userid),HttpStatus.OK);

     }
     @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
     }






}

package lk.acpt.demo_api.controller;

import lk.acpt.demo_api.dto.LoginDto;
import lk.acpt.demo_api.dto.UserDto;
import lk.acpt.demo_api.dto.UserDtoReturn;
import lk.acpt.demo_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.ok;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 5/14/2025
 **/
@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private static UserService userService;

    @Autowired
    public UserController(UserService userService) {
        UserController.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDtoReturn> register(@RequestBody UserDto userDto) {
        UserDtoReturn register = userService.register(userDto);
        return new ResponseEntity<>(register, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody UserDto userDto) {
        LoginDto login = userService.login(userDto);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
}

package lk.acpt.demo_api.service;

import lk.acpt.demo_api.dto.LoginDto;
import lk.acpt.demo_api.dto.UserDto;
import lk.acpt.demo_api.dto.UserDtoReturn;

/**
  *Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
  *Author: Yehanmenura Jayalath
  *Date Modified: 5/14/2025
**/public interface UserService {
    LoginDto login(UserDto userDto);
    UserDtoReturn register(UserDto userDto);
}

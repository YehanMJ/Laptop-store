package lk.acpt.demo_api.service.impl;

import lk.acpt.demo_api.dto.LoginDto;
import lk.acpt.demo_api.dto.UserDto;
import lk.acpt.demo_api.dto.UserDtoReturn;
import lk.acpt.demo_api.entity.User;
import lk.acpt.demo_api.repo.UserRepo;
import lk.acpt.demo_api.service.UserService;
import lk.acpt.demo_api.util.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

/**
 * Project: Assignment 1 (COMP2003-Object Oriented Software Engineering)
 * Author: Yehanmenura Jayalath
 * Date Modified: 5/14/2025
 **/
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private JWTTokenGenerator jwtTokenGenerator;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, JWTTokenGenerator jwtTokenGenerator) {
        this.userRepo = userRepo;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }
    @Override
    public LoginDto login(UserDto userDto) {
        Optional<User> userByEmail = userRepo.getUserByEmail(userDto.getEmail());
        if (userByEmail.isPresent()) {
            byte[] decodedBytes = Base64.getDecoder().decode(userByEmail.get().getPassword());
            String decodedPassword = new String(decodedBytes);

            if (decodedPassword.equals(userDto.getPassword())) {
                String token = jwtTokenGenerator.generateToken(userByEmail.get());
                return new LoginDto(userByEmail.get().getEmail(), token);
            }
        }
        return new LoginDto("Email not found", null);
    }

    @Override
    public UserDtoReturn register(UserDto userDto) {
        String encodedPassword = Base64.getEncoder().encodeToString(userDto.getPassword().getBytes());
        User save = userRepo.save(new User(null, userDto.getEmail(), encodedPassword, userDto.getAddress()));
        if(save != null) {
            return new UserDtoReturn(save.getEmail(), "registration successful");
        }
        return new UserDtoReturn(save.getEmail(), "registration failed");
    }
}

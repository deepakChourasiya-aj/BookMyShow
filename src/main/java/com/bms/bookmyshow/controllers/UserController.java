package com.bms.bookmyshow.controllers;

import com.bms.bookmyshow.dto.*;
import com.bms.bookmyshow.models.User;
import com.bms.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDto signUp(SignupRequestDto signupRequestDto){
          User user = userService.signup(signupRequestDto.getName(),signupRequestDto.getEmail(),signupRequestDto.getPassword());
          SignupResponseDto responseDto = new SignupResponseDto();
          responseDto.setResponsStatus(ResponsStatus.SUCCESS);
          responseDto.setUserId(user.getId());
          return responseDto;
    }

//    Login..
    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        LoginResponseDto responseDto = new LoginResponseDto();

        try{
            User user = userService.login(loginRequestDto.getEmail(),loginRequestDto.getPassword());
            responseDto.setResponsStatus(ResponsStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponsStatus(ResponsStatus.FAILURE);
        }
        return responseDto;
    }
}

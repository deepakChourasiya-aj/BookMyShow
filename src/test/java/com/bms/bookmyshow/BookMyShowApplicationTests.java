package com.bms.bookmyshow;

import com.bms.bookmyshow.controllers.UserController;
import com.bms.bookmyshow.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyShowApplicationTests {
    @Autowired
	private UserController userController;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSignUpFunctionality(){
		SignupRequestDto requestDto = new SignupRequestDto();
		requestDto.setEmail("test@gmail.com");
		requestDto.setPassword("1234");
		requestDto.setName("Deepak");

		SignupResponseDto responseDto = userController.signUp(requestDto);

		System.out.println(responseDto.getUserId());
	}

	@Test
	public void testLoginFunctionality(){
		LoginRequestDto requestDto = new LoginRequestDto();
		requestDto.setEmail("test@gmail.com");
		requestDto.setPassword("1234");

		LoginResponseDto responseDto = userController.login(requestDto);
		if (responseDto.getResponsStatus().equals(ResponsStatus.SUCCESS)) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login Unsuccessful");
		}
	}

}

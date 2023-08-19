package com.hjs.readit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjs.readit.domain.entity.User;
import com.hjs.readit.dto.UserDto;
import com.hjs.readit.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/sign")
	public int createUser(@RequestBody UserDto userDto) {
		String userId = userDto.getUserId();
		String userPw = userDto.getUserPw();
		String userNM = userDto.getUserNcnm();
		
		System.out.println("아이디: "+userId);
		System.out.println("비밀번호: "+userPw);
		System.out.println("닉네임: "+userNM);

		try {
			User answer = userService.create(userDto);
			System.out.println("[/sign] 결과값: " + answer);
			if(answer != null) {
				return 1;
			}else {
				return 0;
			}
			
		} catch(Exception e) {
			System.out.println("에러: "+e);
			return -1;
		}
	}
	
}

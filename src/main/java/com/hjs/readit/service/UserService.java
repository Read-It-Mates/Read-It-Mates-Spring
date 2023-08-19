package com.hjs.readit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjs.readit.domain.entity.User;
import com.hjs.readit.dto.UserDto;
import com.hjs.readit.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository ;
	
	public User create(UserDto userDto) {
		System.out.println("확인합니다.1");
		User user = new User();
		System.out.println("확인합니다.2");

		this.userRepository.save(user);
		return user;
	}

	
}
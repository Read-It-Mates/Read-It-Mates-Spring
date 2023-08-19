package com.hjs.readit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjs.readit.domain.entity.Room;
import com.hjs.readit.dto.RoomDto;
import com.hjs.readit.service.RoomService;

@RestController
@RequestMapping("/reading")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping("/room")
	public int createRoom(@RequestBody RoomDto roomDto) {
		System.out.println("[/room] 들어온 데이터 : " + roomDto);
		
		try {
			Room answer = roomService.create(roomDto);
			System.out.println("[/room] 결과값: " + answer);
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

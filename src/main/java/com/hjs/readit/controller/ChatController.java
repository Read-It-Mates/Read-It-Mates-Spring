package com.hjs.readit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjs.readit.domain.entity.Chat;
import com.hjs.readit.dto.ChatDto;
import com.hjs.readit.service.ChatService;

@RestController
@RequestMapping("/socket")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	
	@PostMapping("/chat")
	public int saveChat(@RequestBody ChatDto chatDto) {
		System.out.println("[/chat] save Chat 시도");
		
		try {
			Chat answer = chatService.create(chatDto);
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
	
	@PostMapping("/loadChat")
	public List<Chat> loadChat(@RequestBody ChatDto chatDto) {
		System.out.println("[/loadChat]: RoomNm "+chatDto.getRoomNm());
		List<Chat> err = new ArrayList<Chat>() ;
		try {
			List<Chat> answer = chatService.find(chatDto.getRoomNm());

			if(answer != null) {
				return answer;
			}else {
				return answer;
			}
			
		} catch(Exception e) {
			System.out.println("에러: "+e);
			return err;
		}
		
	}
	
	

}

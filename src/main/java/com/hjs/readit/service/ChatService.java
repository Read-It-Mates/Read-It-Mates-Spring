package com.hjs.readit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjs.readit.domain.entity.Chat;
import com.hjs.readit.dto.ChatDto;
import com.hjs.readit.repository.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	public Chat create(ChatDto chatDto) {
		System.out.println("챗 서비스 왔다.");
		Chat chat = new Chat(chatDto.getRoomNm(), chatDto.getUserId(), 
				chatDto.getUserChat(), chatDto.getUserNick());
		chat = this.chatRepository.save(chat);
		
		return chat;
	}
	
	
	  public List<Chat> find(String chatDto) {
		  List<Chat> chat = chatRepository.findByRoomNm(chatDto);
		  System.out.println("받은 채팅 닉네임"+chat.get(0).getUserNick());
		  System.out.println("받은 채팅 내용"+chat.get(0).getUserChat());
		  
		    return chat;
		  }
	


}

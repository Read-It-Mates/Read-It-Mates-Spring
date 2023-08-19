package com.hjs.readit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjs.readit.domain.entity.Room;
import com.hjs.readit.dto.RoomDto;
import com.hjs.readit.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public Room create(RoomDto roomDto) {
		System.out.println("룸 서비스 왔다.");
		Room room = new Room(roomDto.getRoomTitle(), roomDto.getBookImg(), roomDto.getBookTitle(),
				roomDto.getBookWriter(), roomDto.getHostId(), roomDto.getCategory());
		System.out.println("룸 서비스 왔다.2");
		room = this.roomRepository.save(room);
		System.out.println("과연? -> "+room);
		return room;
	}

}

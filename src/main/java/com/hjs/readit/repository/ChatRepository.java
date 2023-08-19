package com.hjs.readit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hjs.readit.domain.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{
	
	List<Chat> findByRoomNm(String roomNm);
}

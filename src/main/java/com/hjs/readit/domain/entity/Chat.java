package com.hjs.readit.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CHAT")
public class Chat {
	@Id
	int CHAT_NM;
	@Column(name="ROOM_NM")
	String roomNm;
	@Column(name="USER_ID")
	String userId;
	@Column(name="USER_CHAT")
	String userChat;
	@Column(name="CHAT_TIME")
	String userTime;
	@Column(name="USER_NICK")
	String userNick;
	
	public Chat() {}
	
	public Chat(String roomNm, String userId, String userChat, String userNick) {
		super();
		this.roomNm = roomNm;
		this.userId = userId;
		this.userChat = userChat;
		this.userNick = userNick;
	}
	
	public Chat(String roomNm) {
		super();
		this.roomNm = roomNm;
	}

	public int getCHAT_NM() {
		return CHAT_NM;
	}
	public void setCHAT_NM(int cHAT_NM) {
		CHAT_NM = cHAT_NM;
	}
	public String getRoomNm() {
		return roomNm;
	}
	public void setRoomNm(String roomNm) {
		this.roomNm = roomNm;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserChat() {
		return userChat;
	}
	public void setUserChat(String userChat) {
		this.userChat = userChat;
	}
	public String getUserTime() {
		return userTime;
	}
	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	
	
}

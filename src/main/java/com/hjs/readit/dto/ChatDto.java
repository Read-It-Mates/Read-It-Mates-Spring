package com.hjs.readit.dto;



public class ChatDto {
	int CHAT_NM;
	String roomNm;
	String userId;
	String userChat;
	String userTime;
	String userNick;
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

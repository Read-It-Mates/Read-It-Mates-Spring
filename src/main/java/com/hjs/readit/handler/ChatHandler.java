package com.hjs.readit.handler;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatHandler extends TextWebSocketHandler {


    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
    
    // session 추가
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
       System.out.println("session 추가: " + session.toString());
        sessions.add(session);
    }
    
    
    // 클라이언트로부터 텍스트 메시지를 받았을 때, sessions 컬렉션에 저장된 모든 클라이언트에게 전달.
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        String payload = message.getPayload();
        System.out.println("socket.send 에서 받은 데이터: "+payload);
        try {
        	JSONObject jsonObject = new JSONObject(payload);
        	
//        	System.out.println("길이: "+jsonObject.length());
        	String onCheckKey = jsonObject.keys().next();    // 키 집합에서 첫 번째 키 이름을 가져옴
        	System.out.println("키 값: " + onCheckKey);
        	
        	if(onCheckKey.equals("kickNick")) {
        		// 강퇴 시(방에 있는 모든 사람에게)
        		String kickNick = jsonObject.getString("kickNick");
        		System.out.println("강퇴 된 닉네임 : " + kickNick);
        	}else if(onCheckKey.equals("onCheck")) {
        		// 방 입장 시(방에 들어온 사람이 모두에게)
        		String onCheck = jsonObject.getString("onCheck");
        		System.out.println("입장한 유저 닉네임: " + onCheck);        		
        	}
//        	else if(onCheckKey.equals("reCheck")) {
//        		// 방에 새로 들어온 사람 있을 시(원래 있던 사람용)
//        		String reCheck = jsonObject.getString("reCheck");
//        		System.out.println("새로 들어온 유저 닉네임: "+reCheck);
//        	}
        	else if(onCheckKey.equals("enterUser")) {
        		// 방금 방에 들어온 닉네임
        		String enterUser = jsonObject.getString("enterUser");
        		System.out.println("방금 방에 들어온 닉네임: " + enterUser);
        		
        	}else if(onCheckKey.equals("leaveUser")) {
        		String leaveUser = jsonObject.getString("leaveUser");
        		System.out.println("방을 완전히 나간 닉네임: " + leaveUser);
        		
        	}else if(onCheckKey.equals("leaderNick")) {
        		// 방장 위임
        		String leaderNick = jsonObject.getString("leaderNick");
        		System.out.println("방장 위임된 닉네임: " + leaderNick);
        		
        	}else if(onCheckKey.equals("offUser")) {
        		// 방을 벗어날 시
        		String offUser = jsonObject.getString("offUser");
        		System.out.println("방을 벗어난 닉네임: " + offUser);
        	}else if(onCheckKey.equals("deletedRoom")) {
        		// 방장이 방을 삭제했을 시
        		String deletedRoom = jsonObject.getString("deletedRoom");
        		System.out.println("삭제된 방 ID: " + deletedRoom);
        	}else{
        		// 메시지 보낼 시
        		String userNick = jsonObject.getString("userNick");
        		String userChat = jsonObject.getString("userChat");
        		
        		System.out.println("유저 닉네임: "+userNick);
        		System.out.println("유저 챗: "+userChat);
        	}
        	
            for (WebSocketSession s : sessions) {
                s.sendMessage(new TextMessage(payload));
            }
        } catch (JSONException e) {
            System.err.println("Payload parsing error: " + e.getMessage());
        }
    }

    
    // 웹 소켓 연결이 종료된 후, 연결 종료한 클라이언트정보를 sessions 컬렉션에서 제거. 
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
       System.out.println("session 삭제: " + session.toString());
        sessions.remove(session);
    }
}
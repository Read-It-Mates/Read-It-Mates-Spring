package com.hjs.readit.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="ROOM")
public class Room {
	@Id
	int ROOM_NM;
	@Column(name="ROOM_TT")
	String roomTitle;
	@Column(name="BOOK_IMG")
	String bookImg;
	@Column(name="BOOK_TT")
	String bookTitle;
	@Column(name="BOOK_WR")
	String bookWriter;
	@Column(name="HOST_ID")
	String hostId;
	@Column(name="BOOK_CT")
	String category;

		
	public Room(){}

	public Room(String roomTitle, String bookImg, String bookTitle, 
			String bookWriter, String hostId, String category) {
		super();
		this.roomTitle = roomTitle;
		this.bookImg = bookImg;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.hostId = hostId;
		this.category = category;
	}
}

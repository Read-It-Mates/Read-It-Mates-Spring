package com.hjs.readit.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="USER")
public class User {
	@Id //프라이머리 키
	@Column(name = "USER_ID")
	String userId;
	@Column(name = "USER_PW")
	String userPw;
	@Column(name = "USER_NCNM")
	String userNcnm;
	


}

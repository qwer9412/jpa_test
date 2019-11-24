package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //db에 매핑할 클래스
@Table(name = "member") //db table이름과 class 이름이 다를 때
class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//pk에 값을 자동으로 주기 위한 정책을 명시
	private int id;
	
	private String name;
	
	private String message;
	
	//하이버네이트는 기본생성자가 꼭 필요
	public Member() {
	}

	public Member(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", message=" + message + "]";
	}
}

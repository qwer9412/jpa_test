package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Member;
import com.example.demo.MemberRepository;

public class MemberTest {

	@Autowired
	private MemberRepository memberDao;

	@Test
	public void test() {
		System.out.println("member 삽입 테스트 시작");

		Member member = new Member("leejunsu", "hello world");
		
		memberDao.save(member);

	}

}

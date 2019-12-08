package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberTest.class);
	
	@Autowired
	private MemberRepository memberDao;

	/*
	 * Todo
	 * db에 데이터가 실제로 있을 때 가정해서 수정하기
	 */
	
	@Test
	public void addTest() {
		LOGGER.info("add test@@@@@@@@@@@@@@@@@@@");

		Member member = new Member("leejunsu", "hello world");		
		memberDao.save(member);

		List<Member> memberList = memberDao.findAll();
		System.out.println(memberList);
	}
	
	@Test
	public void getTest() {
		LOGGER.info("get test@@@@@@@@@@@@@@@@@@@");
		
		Member newMember = new Member("leejunsu", "hello world");
		memberDao.save(newMember);
		
		Member savedMember = memberDao.findById(1).get();
		
		System.out.println(savedMember);
	}
	
	@Test
	public void getAllTest() {
		LOGGER.info("getAll test@@@@@@@@@@@@@@@@@@@");
		
		List<Member> newMemberList = new ArrayList<>();
		newMemberList.add(new Member("leejunsu", "hello world"));
		newMemberList.add(new Member("leejunsu2", "hello world2"));
		memberDao.saveAll(newMemberList);
		
		List<Member> memberList = memberDao.findAll();
		
		System.out.println(memberList);
	}

	@Test
	public void deleteTest() {
		LOGGER.info("delete test@@@@@@@@@@@@@@@@@@@");
		
		Member newMember = new Member("a","b");
		memberDao.save(newMember);
		
		List<Member> memberList = memberDao.findAll();
		System.out.println(memberList);
		
		memberDao.deleteById(memberList.get(0).getId());
		
		memberList = memberDao.findAll();
		System.out.println(memberList);
	}
}

package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberTest {

	@Autowired
	private MemberRepository memberDao;

	/*
	 * Todo
	 * db에 데이터가 실제로 있을 때 가정해서 수정하기
	 * 여러개 add하는 법 찾기
	 * 로그로 결과 확인
	 * 자동완성 설정
	 */
	
	@Test
	public void addTest() {
		System.out.println("add test");

		Member member = new Member("leejunsu", "hello world");
		
		memberDao.save(member);

	}
	
	@Test
	public void getTest() {
		System.out.println("get test");
		
		Member newMember = new Member("leejunsu", "hello world");
		memberDao.save(newMember);
		
		Member savedMember = memberDao.findById(1).get();
		
		System.out.println(savedMember);
	}
	
	@Test
	public void getAllTest() {
		System.out.println("getAll test");
		
		Member member1 = new Member("leejunsu", "hello world");
		memberDao.save(member1);
		Member member2 = new Member("leejunsu2", "hello world2");
		memberDao.save(member2);
		
		List<Member> memberList = memberDao.findAll();
		
		System.out.println(memberList);
	}

	@Test
	public void deleteTest() {
		System.out.println("delete test");
		
		Member newMember = new Member("a","b");
		memberDao.save(newMember);
		
		List<Member> memberList = memberDao.findAll();
		System.out.println(memberList);
		
		memberDao.deleteById(memberList.get(0).getId());
		
		memberList = memberDao.findAll();
		System.out.println(memberList);
	}
}

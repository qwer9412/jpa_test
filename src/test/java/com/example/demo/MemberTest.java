package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberTest.class);

	@Autowired
	private MemberRepository memberDao;

	/*
	 * Todo db에 데이터가 실제로 있을 때 가정해서 수정하기
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

		Member newMember = new Member("a", "b");
		memberDao.save(newMember);

		List<Member> memberList = memberDao.findAll();
		System.out.println(memberList);

		memberDao.deleteById(memberList.get(0).getId());

		memberList = memberDao.findAll();
		System.out.println(memberList);
	}

	@Test
	public void pagingTest() {
		LOGGER.info("paging test@@@@@@@@@@@@@@@@@@@@@");

		List<Member> memberList = new ArrayList<Member>();
		for (int i = 1; i <= 20; i++) {
			memberList.add(new Member("name" + i, "message" + i));
		}

		memberDao.saveAll(memberList);

		for (int i = 0; i < 4; i++) {
			PageRequest pageConfig = PageRequest.of(i, 5);
			
			List<Member> curPageMemberList = memberDao.findAll(pageConfig).getContent();
			
			LOGGER.debug("page" + i + ": ");
			for(int idx = 0; idx < 5 ; idx++) {
				assertEquals(memberList.get(i*5 + idx), curPageMemberList.get(idx));
			}
		}
	}
	
	@Test
	public void deleteAllTest() {
		LOGGER.info("deleteAll test@@@@@@@@@@@@@@@");
		
		List<Member> memberList = new ArrayList<Member>();
		for (int i = 1; i <= 20; i++) {
			memberList.add(new Member("name" + i, "message" + i));
		}
		
		memberDao.deleteAll();

		List<Member> updateMemberList = memberDao.findAll();
		
		assertEquals(0, updateMemberList.size());
	}
	
	@Test
	public void countTest() {
		LOGGER.info("count test@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		List<Member> memberList = new ArrayList<Member>();
		for (int i = 1; i <= 20; i++) {
			memberList.add(new Member("name" + i, "message" + i));
		}
		memberDao.saveAll(memberList);
		
		long memberDbCount = memberDao.count();
		
		assertEquals(memberList.size(), memberDbCount);
	}
	
	@Test
	public void findNameTest() {
		LOGGER.info("find name test@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		Member newMember = new Member("name","message");
		memberDao.save(newMember);
		
		PageRequest pageRequest = PageRequest.of(0, 1);
		Member firstMember = memberDao.findAll(pageRequest).getContent().get(0);
		
		String findName = memberDao.findNameById(firstMember.getId());
		
		assertEquals(firstMember.getName(), findName);
	}
	
	@Test
	public void findNameOrMessageTest() {
		LOGGER.info("find name or message test@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		List<Member> newMemberList = new ArrayList<>();
		for(int i = 1 ; i <= 3; i++) {
			newMemberList.add(new Member("name" + i, "message" +i ));
		}
		memberDao.saveAll(newMemberList);
		
		List<Member> name1Message2Member = memberDao.findByNameOrMessage("name1","message2");
		
		for(Member member : name1Message2Member) {
			if(!(member.getName().equals("name1") || member.getMessage().equals("message2"))) {
				fail("name1 or message2 가 아닌 값이 있음");
			}
		}
	}
}
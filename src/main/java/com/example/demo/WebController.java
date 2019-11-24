package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
	
	@Autowired
	private MemberRepository memberDao;
	
	@RequestMapping("/")
	@ResponseBody
	public Member add() {
		Member memberData = memberDao.save(new Member("a","b"));
		return memberData;
	}
	
}

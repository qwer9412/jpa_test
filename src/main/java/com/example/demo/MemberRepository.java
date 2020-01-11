package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,Integer>{
	@Query("select m.name from Member m where m.id = :id")
	String findNameById(@Param("id") Integer id);
	
	//name or message 중 값이 같은 member
	List<Member> findByNameOrMessage(String name, String message);
}

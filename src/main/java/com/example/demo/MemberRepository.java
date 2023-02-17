package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
	boolean existsByMemberId(String id);
}

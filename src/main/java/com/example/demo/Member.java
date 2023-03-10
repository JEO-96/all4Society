package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@Column(name="member_id", nullable = false)
	private String memberId;
	
	@Column(name="member_pw")
	private String memberPw;
	
	@Column(name="member_phone")
	private String memberPhone;
	
	@Column(name="member_birth")
	private String memberBirth;
	
	@Column(name="member_intro")
	private String memberIntro;
	
	public static Member createMember(MemberDto memberDto) {
		Member member = new Member();
		member.setMemberId(memberDto.getMemberId());
		member.setMemberPw(memberDto.getMemberPw());
		member.setMemberPhone(memberDto.getMemberPhone());
		member.setMemberBirth(memberDto.getMemberBirth());
		member.setMemberIntro(memberDto.getMemberIntro());
		return member;
	}
}

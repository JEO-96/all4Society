package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
	
	private String memberId;
	
	private String memberPw;
	
	private String memberPhone;
	
	private String memberBirth;
	
	private String memberIntro;

}

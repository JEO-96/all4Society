package com.example.demo.service;

import com.example.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
//public class RegisterMemberService {
//    private final PasswordEncoder passwordEncoder;
//    private final MemberRepository repository;
//
//    @Autowired
//    public RegisterMemberService(PasswordEncoder passwordEncoder, MemberRepository repository) {
//        this.passwordEncoder = passwordEncoder;
//        this.repository = repository;
//    }
//
//    public Long join(String userid, String pw) {
//        Member member = Member.createUser(userid, pw, passwordEncoder);
//        validateDuplicateMember(member);
//        repository.save(member);
//        return member.getId();
//    }
//}

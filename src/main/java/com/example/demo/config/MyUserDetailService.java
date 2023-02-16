package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.lang.reflect.Member;
import java.util.Optional;

//@Configuration
//public class MyUserDetailService implements UserDetailsService {
//    private final MemberService memberService;
//
//    public MyUserDetailService(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
//        Optional<Member> findOne = memberService.findOne(insertedUserId);
//        Member member = findOne.orElseThrow(()-> new UsernameNotFoundException("없는 회원입니다."));
//
//        return User.builder()
//                .username(member.getUserid())
//                .password(member.getPw())
//                .roles(member.getRoles())
//                .build();
//    }
//}

package com.example.springgradleinflearn.service;

import com.example.springgradleinflearn.domain.Member;
import com.example.springgradleinflearn.repository.MemberRepository;
import com.example.springgradleinflearn.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

package com.spring_tutorial;

import com.spring_tutorial.repository.MemberRepository;
import com.spring_tutorial.repository.MemoryMemberRepository;
import com.spring_tutorial.service.MemberService;
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
        return  new MemoryMemberRepository();
    }
}

package com.spring_tutorial.service;

import com.spring_tutorial.domain.Member;
import com.spring_tutorial.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemberService memberService ;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService =new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입(){
        //given
        Member member = Member.builder().build();
        member.setName("hello");

        //when
        Long saveId =memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();

        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = Member.builder().build();
        member1.setName("spring");

        Member member2 = Member.builder().build();
        member2.setName("spring");
        //when
        memberService.join(member1);
        //then
        IllegalStateException error = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(error.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers(){

    }

    @Test
    void findOne(){

    }
}

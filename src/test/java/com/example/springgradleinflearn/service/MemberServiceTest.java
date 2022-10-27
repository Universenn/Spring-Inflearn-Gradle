package com.example.springgradleinflearn.service;

import com.example.springgradleinflearn.domain.Member;
import com.example.springgradleinflearn.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        memberService = new MemberService(new MemoryMemberRepository());
        repository = new MemoryMemberRepository();
    }

    // story 를 다 지운다.
    // test 가 시작 될때마다 계속 해서 story 를 지워준다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // -> memberService.join(member2)); 이 로직을 실행할 거 인데
        // IllegalStateException 이 예외가 발생해야 한다.
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
package com.spring_tutorial.repository;

import com.spring_tutorial.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);
    List<Member> findAll();
}

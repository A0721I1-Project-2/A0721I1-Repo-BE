package project2.service;

import project2.model.Member;

import java.util.List;

public interface IMemberService {
    Member save(Member member);

    Iterable<Member> saveAll(Iterable<Member> members);

    Member findById(String id);

    List<Member> findAll();

    void deleteById(Long id);

    void delele(Member member);
}

package project2.service;

import project2.model.Account;
import project2.model.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberService {
    Member save(Member member);

    Iterable<Member> saveAll(Iterable<Member> members);

    Optional<Member> findByIdMember(Long id);

    List<Member> findAll();

    void deleteById(Long id);

    void delele(Member member);
}

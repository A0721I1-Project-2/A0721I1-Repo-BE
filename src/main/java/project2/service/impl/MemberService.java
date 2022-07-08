package project2.service.impl;

import org.springframework.stereotype.Service;
import project2.model.Member;
import project2.service.IMemberService;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Iterable<Member> saveAll(Iterable<Member> members) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delele(Member member) {

    }
}

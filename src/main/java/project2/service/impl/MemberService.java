package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Member;
import project2.repository.IMemberRepository;
import project2.service.IMemberService;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService implements IMemberService {
    @Autowired
    private IMemberRepository iMemberRepository;

    private IMemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Iterable<Member> saveAll(Iterable<Member> members) {
        return null;
    }

    @Override
    public Member findById(String id) {
        return iMemberRepository.findById(Long.parseLong(id)).orElse(null);
    }
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
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

    @Override
    public void getTransactionMember() {
        memberRepository.getTransactionByMember();
    }
}

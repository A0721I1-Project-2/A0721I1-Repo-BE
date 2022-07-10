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

    /* Get member by account id */
    @Override
    public Optional<Member> getMemberByAccountId(Long accountId) {
        Optional<Member> member = this.memberRepository.getMemberByAccountId(accountId);
        if (member.isPresent()) {
            return this.memberRepository.getMemberByAccountId(accountId);
        }
        return null;
    }
}

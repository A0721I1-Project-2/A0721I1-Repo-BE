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
    public IMemberRepository memberRepository;
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Iterable<Member> saveAll(Iterable<Member> members) {
        return null;
    }

        @Override
        public Optional<Member> findByIdMember(Long id) {
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
}

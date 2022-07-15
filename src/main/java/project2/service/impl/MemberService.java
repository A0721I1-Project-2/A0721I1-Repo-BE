package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @Override
    public Member save(Member member) {
        return iMemberRepository.save(member);
    }

    @Override
    public Iterable<Member> saveAll(Iterable<Member> members) {
        return null;
    }

    @Override
    public Member findById(Long id) {
        return iMemberRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Member> findAll(Pageable pageable) {
        return iMemberRepository.findAll(pageable);
    }

    @Override
    public List<Member> findAllList() {
        return iMemberRepository.findAll();
    }

    @Override
    public Page<Member> searchMember(String name, String email, String address, String phoneNumber, String nameRank, Pageable pageable) {
        return iMemberRepository.searchAllMember(name, email, address, phoneNumber, nameRank, pageable);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delele(Member member) {

    }

    //SonLT View-Member
    @Override
    public Member findMemberByIdAccount(Long id) {
            return iMemberRepository.findMemberByAccount_IdAccount(id);
    }

    //SonLT Edit-Member
    @Override
    public void editMember(Member member) {
        iMemberRepository.save(member);
    }


}
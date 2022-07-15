package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.Account;
import project2.model.Member;
import project2.model.Rank;
import project2.service.IAccountService;
import project2.service.IMemberService;
import project2.service.IRankService;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@CrossOrigin("*")
public class MemberController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IMemberService memberService;

    @Autowired
    private IRankService rankService;


    @GetMapping("/allMember")
    public ResponseEntity<Page<Member>> showListMember(@PageableDefault(size = 10) Pageable pageable){
        Page<Member> memberPage = memberService.findAll(pageable);
        return new ResponseEntity<>(memberPage, HttpStatus.OK);
    }

    @GetMapping("/getAccount")
    public ResponseEntity<List<Account>> showListAccount(){
        List<Account> accountList = accountService.findAll();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping("/allRankMember")
    public ResponseEntity<List<Rank>> showListRankMember(){
        List<Rank> rankMembers = rankService.findAllRank();
        return new ResponseEntity<>(rankMembers, HttpStatus.OK);
    }

    @GetMapping("/search/{name}/{email}/{phoneNumber}/{nameRank}/{address}")
    public ResponseEntity<Page<Member>> searchMember(@PathVariable String email, @PathVariable String name, @PathVariable String phoneNumber,
                                                     @PathVariable String address, @PathVariable String nameRank,
                                                     @PageableDefault(size = 10) Pageable pageable) {
        if (email.equals("null")) {
            email = null;
        }
        if (name.equals("null")) {
            name = null;
        }
        if (phoneNumber.equals("null")) {
            phoneNumber = null;
        }
        if (address.equals("null")) {
            address = null;
        }
        if (nameRank.equals("null")) {
            nameRank = null;
        }
        Page<Member> memberPageSearch = memberService.searchMember(name, email, address, phoneNumber, nameRank, pageable);
        return new ResponseEntity<>(memberPageSearch, HttpStatus.OK);
    }

    @PostMapping("/member/Block/")
    public ResponseEntity<Member> blockMember(@RequestBody Long[] blockArray) {
        for (Long id : blockArray) {
            Member member = memberService.findById(id);
            member.getAccount().setBlock(true);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/member/unBlock/")
    public ResponseEntity<Member> unBlockMember(@RequestBody Long[] unBlockArray) {
        for (Long id : unBlockArray) {
            Member member = memberService.findById(id);
            member.getAccount().setBlock(false);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
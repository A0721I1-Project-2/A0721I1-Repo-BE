package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project2.model.Account;
import project2.model.Member;
import project2.service.impl.AccountService;
import project2.service.impl.MemberService;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(value = "/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /* Get member by account id */
    @RequestMapping(value = "/account={accountId}" , method = RequestMethod.GET)
    public ResponseEntity<Member> getMemberByAccountId(@PathVariable("accountId") Long accountId) {
        Optional<Member> member = this.memberService.getMemberByAccountId(accountId);
        if(member.isPresent()) {
            return new ResponseEntity<>(member.get() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

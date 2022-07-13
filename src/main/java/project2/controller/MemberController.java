package project2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project2.model.Member;
import project2.service.impl.MemberService;

import java.util.List;

@RestController
@RequestMapping("/manager/member")
@CrossOrigin("*")
public class MemberController {

    //Detail Account SonLT
    MemberService memberService;

    public ResponseEntity<List<Member>> findAll(){
        List<Member> memberList = memberService.findAll();
        if (memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(memberList, HttpStatus.OK);
        }
    }
}

package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project2.model.Member;
import project2.service.IMemberService;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
public class MemberController {
    @Autowired
    IMemberService iMemberService;

    // HuyNN get member by id method
    @GetMapping("/getMemberById/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return new ResponseEntity<Member>(iMemberService.findById(id).get(), HttpStatus.OK);
    }
}

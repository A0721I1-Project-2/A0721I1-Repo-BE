package project2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.Member;
import project2.service.IMemberService;

@RestController
@RequestMapping("/manager/api/member")
@CrossOrigin(origins = "http://localhost:4200/")
public class AccountController {

    @Autowired
    private IMemberService memberService;
    //HauNT
    @GetMapping("/detail/{idMember}")
    public ResponseEntity<Member> findMemberByIdAccount(@PathVariable("idMember") Long idMember) {
        Member member = memberService.findMemberByIdAccount(idMember);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
    }
}

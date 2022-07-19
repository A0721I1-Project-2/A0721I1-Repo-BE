package project2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.Account;
import project2.model.Member;
import project2.service.IAccountService;
import project2.service.IMemberService;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IMemberService iMemberService;

    @GetMapping("/getAccountByMemberId/{id}")
    public ResponseEntity<Account> getAccountByMember(@PathVariable Long id) {
        Member member = iMemberService.findById(id).get();
        return new ResponseEntity<Account>(iAccountService.findByMember(member), HttpStatus.OK);
    }
}

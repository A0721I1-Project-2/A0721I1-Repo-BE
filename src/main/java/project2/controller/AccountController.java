package project2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.model.Account;
import project2.service.impl.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(value = "/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /* Get all accounts -TuanNHA */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = this.accountService.findAll();

        if(accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(accounts , HttpStatus.OK);
    }

    /* Get accounts by role member -TuanNHA */
    @RequestMapping(value = "/members" , method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAccountsByRoleMember() {
        List<Account> accounts = this.accountService.getAccountsByRoleName("ROLE_MEMBER");

        if(accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(accounts , HttpStatus.OK);
    }

    /* Get account by username -TuanNHA */
    @RequestMapping(value = "/username&{username}" , method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountByUsername(@PathVariable("username") String username) {
        Optional<Account> account = accountService.getAccountByUsername(username);

        if(account.isPresent()) {
            return new ResponseEntity<>(account.get() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

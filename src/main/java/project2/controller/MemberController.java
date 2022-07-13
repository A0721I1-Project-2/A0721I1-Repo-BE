package project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project2.dto.AccountMemberDTO;
import project2.dto.ValidateAccountDTO;
import project2.model.Account;
import project2.model.Member;
import project2.model.Rank;
import project2.model.Role;
import project2.service.IAccountService;
import project2.service.IMemberService;
import project2.service.IRankService;
import project2.service.IRoleService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/member")
@CrossOrigin("http://localhost:4200/")
public class MemberController {

    @Autowired
    private IRankService iRankService;

    @Autowired
    private IMemberService iMemberService;

    @Autowired
    private IRoleService iRoleService;


    @Autowired
    private IAccountService iAccountService;


    @Autowired
    private ValidateAccountDTO validateAccountDTO;


    //Bin code method create account member
    @PostMapping("/saveNewAccountMember")
    public ResponseEntity<?> saveAccountMember(@Valid @RequestBody AccountMemberDTO accountMemberDTO, BindingResult bindingResult) {
        Boolean check = true;
        validateAccountDTO.validate(accountMemberDTO, bindingResult);
        List<Account> accountList = iAccountService.findAll();
        for (Integer i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUsername().equals(accountMemberDTO.getAccount().getUsername())) {
                check = false;
                break;
            }
        }
        if (bindingResult.hasErrors() || !check) {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
            } else {
                return new ResponseEntity<>("Tên tài khoản đã tồn tại", HttpStatus.NOT_MODIFIED);
            }
        } else {
            Member member = new Member();
            Account account = new Account();


            Set<Role> roles = new HashSet<>();
            /* Set data for Account */
            account.setUsername(accountMemberDTO.getAccount().getUsername());
            account.setPassword(accountMemberDTO.getAccount().getPassword());

            /*Set row mặc định*/
            Role role = iRoleService.findByName("ROLE_MEMBER").get();
            roles.add(role);
            account.setRoles(roles);

            Account accountCreated = iAccountService.save(account);
            /* Set data for member */
            member.setAccount(iAccountService.findById(accountCreated.getIdAccount()).get());
            member.setNameMember(accountMemberDTO.getNameMember());
            member.setEmailMember(accountMemberDTO.getEmailMember());
            member.setAddressMember(accountMemberDTO.getAddressMember());
            member.setDateOfBirthMember(accountMemberDTO.getDateOfBirthMember());
            member.setFlagDelete(false);
            member.setIdCardMember(accountMemberDTO.getIdCardMember());
            member.setPaypalMember(accountMemberDTO.getPaypalMember());
            member.setPhoneMember(accountMemberDTO.getPhoneMember());

            /*Set rank default*/
            Rank rank = iRankService.findByName("RANK_BẠC").get();
            member.setRank(rank);
            iMemberService.save(member);

            return new ResponseEntity<>(HttpStatus.CREATED);

        }
    }
}

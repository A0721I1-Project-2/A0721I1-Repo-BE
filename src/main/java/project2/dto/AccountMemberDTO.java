package project2.dto;

import project2.model.Account;
import project2.model.Rank;

import javax.validation.constraints.NotEmpty;

public class AccountMemberDTO {
    private Account account;
    private String emailMember;
    private String addressMember;
    private String phoneMember;
    private String idCardMember;
    private String paypalMember;
    private Boolean flagDelete;
    private String dateOfBirthMember;
    private String nameMember;


/*  @NotEmpty(message = "Confirm password not empty")
    private String confirmPassword;*/

    public AccountMemberDTO() {
    }

    public String getNameMember() {
        return nameMember;
    }

    public void setNameMember(String nameMember) {
        this.nameMember = nameMember;
    }

    public String getDateOfBirthMember() {
        return dateOfBirthMember;
    }

    public void setDateOfBirthMember(String dateOfBirthMember) {
        this.dateOfBirthMember = dateOfBirthMember;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getEmailMember() {
        return emailMember;
    }

    public void setEmailMember(String emailMember) {
        this.emailMember = emailMember;
    }

    public String getAddressMember() {
        return addressMember;
    }

    public void setAddressMember(String addressMember) {
        this.addressMember = addressMember;
    }

    public String getPhoneMember() {
        return phoneMember;
    }

    public void setPhoneMember(String phoneMember) {
        this.phoneMember = phoneMember;
    }

    public String getIdCardMember() {
        return idCardMember;
    }

    public void setIdCardMember(String idCardMember) {
        this.idCardMember = idCardMember;
    }

    public String getPaypalMember() {
        return paypalMember;
    }

    public void setPaypalMember(String paypalMember) {
        this.paypalMember = paypalMember;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    /*    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }*/
}

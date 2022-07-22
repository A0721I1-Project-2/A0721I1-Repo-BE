package project2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_member")
    private Long idMember;

    @Column(name = "name_member")
    private String nameMember;

    @Column(name = "date_of_birth_member")
    private String dateOfBirthMember;

    @Column(name = "email_member")
    private String emailMember;

    @Column(name = "address_member")
    private String addressMember;

    @Column(name = "phone_member")
    private String phoneMember;

    @Column(name = "id_card_member")
    private String idCardMember;

    @Column(name = "paypal_member")
    private String paypalMember;

    @Column(name = "flag_delete")
    private Boolean flagDelete;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_account", referencedColumnName = "id_account")
    private Account account;

    @OneToMany(mappedBy = "member")
    @JsonBackReference(value = "member_invoice")
    private List<Invoice> invoiceList;

    @Column(name = "point")
    private Double point = Double.valueOf(10);

    @OneToMany(mappedBy = "member")
    @JsonBackReference(value = "member_payment")
    private List<Payment> paymentList;

    @ManyToOne(targetEntity = Rank.class)
    @JoinColumn(name = "id_rank", nullable = false)
    private Rank rank;

    @OneToOne(mappedBy = "member")
    @JsonBackReference(value = "member_cart")
    private Cart cart;


    @OneToMany(mappedBy = "members")
    @JsonBackReference(value = "member_product")
    private List<Product> products;

    public Member() {
    }

    public Member(Long idMember, String nameMember, String dateOfBirthMember, String emailMember, String addressMember, String phoneMember, String idCardMember, String paypalMember, Boolean flagDelete, Account account, List<Invoice> invoiceList, Double point, List<Payment> paymentList, Rank rank, Cart cart, List<Product> products) {
        this.idMember = idMember;
        this.nameMember = nameMember;
        this.dateOfBirthMember = dateOfBirthMember;
        this.emailMember = emailMember;
        this.addressMember = addressMember;
        this.phoneMember = phoneMember;
        this.idCardMember = idCardMember;
        this.paypalMember = paypalMember;
        this.flagDelete = flagDelete;
        this.account = account;
        this.invoiceList = invoiceList;
        this.point = point;
        this.paymentList = paymentList;
        this.rank = rank;
        this.cart = cart;
        this.products = products;
    }

    public Long getIdMember() {
        return idMember;
    }

    public void setIdMember(Long idMember) {
        this.idMember = idMember;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
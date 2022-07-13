package project2.dto;

import project2.model.Cart;
import project2.model.Member;
import project2.model.PaymentMethod;
import project2.model.Transport;

public class PaymentDTO {
    private Long idPayment;
    private String fullNameReceiver;
    private String addressReceiver;
    private String emailReceiver;
    private String phoneReceiver;
    private Double feeService;
    private String descriptionReceiver;
    private Member member;
    private PaymentMethod paymentMethod;
    private Cart cart;
    private Transport transport;

    public PaymentDTO(Long idPayment, String fullNameReceiver, String addressReceiver, String emailReceiver, String phoneReceiver, Double feeService, String descriptionReceiver) {
        this.idPayment = idPayment;
        this.fullNameReceiver = fullNameReceiver;
        this.addressReceiver = addressReceiver;
        this.emailReceiver = emailReceiver;
        this.phoneReceiver = phoneReceiver;
        this.feeService = feeService;
        this.descriptionReceiver = descriptionReceiver;
    }

    public PaymentDTO(Long idPayment, String fullNameReceiver, String addressReceiver, String emailReceiver, String phoneReceiver, Double feeService, String descriptionReceiver, Member member, PaymentMethod paymentMethod, Cart cart, Transport transport) {
        this.idPayment = idPayment;
        this.fullNameReceiver = fullNameReceiver;
        this.addressReceiver = addressReceiver;
        this.emailReceiver = emailReceiver;
        this.phoneReceiver = phoneReceiver;
        this.feeService = feeService;
        this.descriptionReceiver = descriptionReceiver;
        this.member = member;
        this.paymentMethod = paymentMethod;
        this.cart = cart;
        this.transport = transport;
    }

    public PaymentDTO() {
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Long getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Long idPayment) {
        this.idPayment = idPayment;
    }

    public String getFullNameReceiver() {
        return fullNameReceiver;
    }

    public void setFullNameReceiver(String fullNameReceiver) {
        this.fullNameReceiver = fullNameReceiver;
    }

    public String getAddressReceiver() {
        return addressReceiver;
    }

    public void setAddressReceiver(String addressReceiver) {
        this.addressReceiver = addressReceiver;
    }

    public String getEmailReceiver() {
        return emailReceiver;
    }

    public void setEmailReceiver(String emailReceiver) {
        this.emailReceiver = emailReceiver;
    }

    public String getPhoneReceiver() {
        return phoneReceiver;
    }

    public void setPhoneReceiver(String phoneReceiver) {
        this.phoneReceiver = phoneReceiver;
    }

    public Double getFeeService() {
        return feeService;
    }

    public void setFeeService(Double feeService) {
        this.feeService = feeService;
    }

    public String getDescriptionReceiver() {
        return descriptionReceiver;
    }

    public void setDescriptionReceiver(String descriptionReceiver) {
        this.descriptionReceiver = descriptionReceiver;
    }
}

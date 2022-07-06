package project2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long idPayment;

    @Column(name = "full_name_receiver")
    private String fullNameReceiver;

    @Column(name = "address_receiver")
    private String addressReceiver;

    @Column(name = "email_receiver")
    private String emailReceiver;

    @Column(name = "phone_receiver")
    private String phoneReceiver;

    @Column(name = "fee_service")
    private Double feeService;

    @Column(name = "description_receiver")
    private String descriptionReceiver;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "id_member", nullable = false)
    private Member member;

    @ManyToOne(targetEntity = PaymentMethod.class)
    @JoinColumn(name = "id_payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne(targetEntity = Transport.class)
    @JoinColumn(name = "id_transport", nullable = false)
    private Transport transport;

    @OneToMany(mappedBy = "payment")
    @JsonBackReference(value = "payment_invoice")
    private List<Invoice> invoiceList;

    public Payment() {
    }

    public Payment(Long idPayment, String fullNameReceiver, String addressReceiver, String emailReceiver, String phoneReceiver, Double feeService, String descriptionReceiver, Member member, PaymentMethod paymentMethod, Transport transport, List<Invoice> invoiceList) {
        this.idPayment = idPayment;
        this.fullNameReceiver = fullNameReceiver;
        this.addressReceiver = addressReceiver;
        this.emailReceiver = emailReceiver;
        this.phoneReceiver = phoneReceiver;
        this.feeService = feeService;
        this.descriptionReceiver = descriptionReceiver;
        this.member = member;
        this.paymentMethod = paymentMethod;
        this.transport = transport;
        this.invoiceList = invoiceList;
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

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}

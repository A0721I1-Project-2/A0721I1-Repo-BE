package project2.model;

import javax.persistence.*;

@Entity
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice_detail")
    private Long idInvoiceDetail;

    @Column(name = "warning")
    private int warning;

    @Column(name = "warning_date")
    private String warningDate;

    @ManyToOne
    @JoinColumn(name = "id_invoice",nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false)
    private Product product;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Long idInvoiceDetail, int warning, String warningDate, Invoice invoice, Product product) {
        this.idInvoiceDetail = idInvoiceDetail;
        this.warning = warning;
        this.warningDate = warningDate;
        this.invoice = invoice;
        this.product = product;
    }

    public Long getIdInvoiceDetail() {
        return idInvoiceDetail;
    }

    public void setIdInvoiceDetail(Long idInvoiceDetail) {
        this.idInvoiceDetail = idInvoiceDetail;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public String getWarningDate() {
        return warningDate;
    }

    public void setWarningDate(String warningDate) {
        this.warningDate = warningDate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

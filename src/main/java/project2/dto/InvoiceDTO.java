package project2.dto;

import project2.model.ImageProduct;

import java.util.List;

public class InvoiceDTO {
    private List<ImageProduct> imageProductList;

    public List<ImageProduct> getImageProductList() {
        return imageProductList;
    }

    public void setImageProductList(List<ImageProduct> imageProductList) {
        this.imageProductList = imageProductList;
    }
}

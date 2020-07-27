package unq.dapp.ComprandoEnCasa.model.dtos;

import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderDTO {
    private List<ProductPurchaseDTO> products;
    private LocalDate date;
    private String commerceName;
    private Integer total;

    public PurchaseOrderDTO() { }

    public List<ProductPurchaseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPurchaseDTO> products) {
        this.products = products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCommerceName() {
        return commerceName;
    }

    public void setCommerceName(String commerceName) {
        this.commerceName = commerceName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}

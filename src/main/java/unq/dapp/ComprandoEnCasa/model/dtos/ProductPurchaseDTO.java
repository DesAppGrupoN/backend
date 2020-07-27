package unq.dapp.ComprandoEnCasa.model.dtos;

public class ProductPurchaseDTO {
    private String name;
    private Integer quantity;
    private Integer price;

    public ProductPurchaseDTO() { }

    public ProductPurchaseDTO(String name, Integer price, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getTotal() {
        return price * quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

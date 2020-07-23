package unq.dapp.ComprandoEnCasa.model.dtos;

public class ProductShoppingCartDTO {

    private Integer idProduct;
    private String userEmail;
    private Integer quantity;

    public ProductShoppingCartDTO() { }


    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

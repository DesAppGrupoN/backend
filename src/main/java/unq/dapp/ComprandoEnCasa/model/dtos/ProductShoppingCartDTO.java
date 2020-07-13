package unq.dapp.ComprandoEnCasa.model.dtos;

public class ProductShoppingCartDTO {

    private Integer idProduct;
    private String userEmail;

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
}

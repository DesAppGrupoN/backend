package unq.dapp.ComprandoEnCasa.model.builders;


import unq.dapp.ComprandoEnCasa.model.domain.Category;
import unq.dapp.ComprandoEnCasa.model.domain.Product;

public class ProductBuilder {

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    private String name ;
    private Category category ;
    private String brand ;
    private Integer stock ;
    private Integer price ;
    private String image ;

    public ProductBuilder(){
        this.name = "not name";
        this.category= Category.LIMPIEZA;
        this.brand = "not brand";
        this.stock = 0;
        this.price = 0;
        this.image = "";
    }


    public Product build() {
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setBrand(brand);
        product.setStock(stock);
        product.setPrice(price);
        product.setImage(image);

        return product;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductBuilder withStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public ProductBuilder withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withImage(String image) {
        this.image = image;
        return this;
    }
    public ProductBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

}

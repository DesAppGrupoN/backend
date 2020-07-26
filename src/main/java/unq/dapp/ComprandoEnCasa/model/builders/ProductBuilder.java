package unq.dapp.ComprandoEnCasa.model.builders;


import unq.dapp.ComprandoEnCasa.model.domain.Category;
import unq.dapp.ComprandoEnCasa.model.domain.Product;

public class ProductBuilder {
    private Integer commerceId ;
    private Integer id ;
    private String name ;
    private Category category ;
    private String brand ;
    private Integer stock ;
    private Integer price ;
    private String image ;

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public ProductBuilder(){
        this.commerceId = null;
        this.id = null;
        this.name = "not name";
        this.category= Category.CLEANING;
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

        if(this.id != null) {
            product.setId(this.id);
        }
        if(this.commerceId != null) {
            product.setCommerceId(this.commerceId);
        }
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
    public ProductBuilder withId(Integer id) {
        this.id = id;
        return this;
    }
    public ProductBuilder withCommerceId(Integer commerceId) {
        this.commerceId = commerceId;
        return this;
    }
}

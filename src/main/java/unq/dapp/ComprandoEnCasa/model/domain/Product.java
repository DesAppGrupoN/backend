package unq.dapp.ComprandoEnCasa.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    private String commerceId;
    @Id
    private Integer id;
    private String name;
    private Category category;
    private String brand;
    private Integer stock;
    private Integer price;
    private String image;

    public Product() { }

    public Product(String commerceId,Integer id,String name, Category category, String brand, Integer stock, Integer price, String image){
        this.commerceId = commerceId;
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.stock = stock;
        this.price = price;
        this.image = image;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public Integer getStock() { return stock; }

    public void setStock(Integer stock) { this.stock = stock; }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public Integer getId() { return id; }

    public String getCommerceId() { return commerceId; }

}

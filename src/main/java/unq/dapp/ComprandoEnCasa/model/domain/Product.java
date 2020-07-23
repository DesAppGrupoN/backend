package unq.dapp.ComprandoEnCasa.model.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @JoinColumn(name="commerce_id")
    private Integer commerceId;
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotNull(message = "Category is mandatory")
    private Category category;
    private String brand;
    @NotNull(message = "Stock is mandatory")
    @Range(min = 0)
    private Integer stock;
    @NotNull(message = "Price is mandatory")
    @Range(min = 0)
    private Integer price;
    private String image;

    public Product() { }

    public Product(Integer commerceId, String name, Category category, String brand, Integer stock, Integer price, String image){
        this.commerceId = commerceId;
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

    public Integer getCommerceId() { return commerceId; }

    public void setCommerceId(Integer id) { this.commerceId = id; }
}

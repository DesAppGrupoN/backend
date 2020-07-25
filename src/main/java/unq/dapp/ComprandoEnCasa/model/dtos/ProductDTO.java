package unq.dapp.ComprandoEnCasa.model.dtos;

import unq.dapp.ComprandoEnCasa.model.domain.Category;

public class ProductDTO {
    private Integer commerceId;
    private Integer id;
    private String name;
    private Category category;
    private String brand;
    private Integer stock;
    private Integer price;
    private String image;

    public Integer getCommerceId() { return commerceId; }

    public void setCommerceId(Integer commerceId) { this.commerceId = commerceId; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public Integer getStock() { return stock; }

    public void setStock(Integer stock) { this.stock = stock; }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }
}

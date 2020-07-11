package unq.dapp.ComprandoEnCasa.model.utils;
import com.opencsv.bean.CsvBindByName;
import unq.dapp.ComprandoEnCasa.model.domain.Category;

public class CSVProduct {
    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "category")
    private Category category;

    @CsvBindByName(column = "brand")
    private String brand;

    @CsvBindByName(column = "stock")
    private Integer stock;

    @CsvBindByName(column = "price")
    private Integer price;

    @CsvBindByName(column = "image")
    private String image;

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

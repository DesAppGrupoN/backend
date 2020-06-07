package unq.dapp.ComprandoEnCasa.model.domain;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static unq.dapp.ComprandoEnCasa.model.domain.Category.LIMPIEZA;

public class ProductTest {

    @Test
    public void constructorTest() {
        String commerceId= "commerceId";
        String name = "name";
        Category category= LIMPIEZA;
        String brand = "brand";
        Integer stock= 10;
        Integer price = 50;
        String image = "image";


        Product product = new Product(commerceId,name, category, brand, stock, price, image);

        assertEquals(commerceId,product.getCommerceId());
        assertEquals(name,product.getName());
        assertEquals(category,product.getCategory());
        assertEquals(brand,product.getBrand());
        assertEquals(stock,product.getStock());
        assertEquals(price,product.getPrice());
        assertEquals(image,product.getImage());
    }

}

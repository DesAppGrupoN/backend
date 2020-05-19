package unq.dapp.comprandoEnCasa.model.builders;


import org.junit.jupiter.api.Test;
import unq.dapp.comprandoEnCasa.model.domain.Category;
import unq.dapp.comprandoEnCasa.model.domain.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsBuilderTest {

    @Test
    public void buildProductWithName() {
        Product product = ProductBuilder.aProduct().withName("Detergente").build();

        assertEquals("Detergente", product.getName());
    }

    @Test
    public void buildProductWithBrand() {
        Product product = ProductBuilder.aProduct().withBrand("Ala").build();

        assertEquals("Ala", product.getBrand());
    }

    @Test
    public void buildProductWithStock() {
        Product product = ProductBuilder.aProduct().withStock(1).build();

        assertEquals(Integer.valueOf(1), product.getStock());
    }

    @Test
    public void buildProductWithPrice() {
        Product product = ProductBuilder.aProduct().withPrice(50).build();

        assertEquals(Integer.valueOf(50), product.getPrice());
    }

    @Test
    public void buildProductWithImage() {
        String image = "";
        Product product = ProductBuilder.aProduct().withImage(image).build();

        assertEquals(image, product.getImage());
    }
    @Test
    public void buildProductWithCategory() {
        Category category= Category.LIMPIEZA;
        Product product = ProductBuilder.aProduct().withCategory(category).build();

        assertEquals(category, product.getCategory());
    }


}

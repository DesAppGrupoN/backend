package unq.dapp.comprandoencasa.model.domain.thresholds;

import org.junit.jupiter.api.Test;
import unq.dapp.comprandoencasa.model.domain.Category;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryThresholdTest {

    @Test
    public void setAndGetCategory() {
        Category category = Category.LIMPIEZA;
        CategoryThreshold categoryThreshold = new CategoryThreshold();
        categoryThreshold.setCategory(category);
        assertEquals(category, categoryThreshold.getCategory());
    }

    @Test
    public void setAndGetMaxMoney() {
        Integer maxMoney = 100;
        CategoryThreshold categoryThreshold = new CategoryThreshold();
        categoryThreshold.setMaxMoney(maxMoney);
        assertEquals(maxMoney, categoryThreshold.getMaxMoney());
    }

    @Test
    public void isExceeded() {
        Integer maxMoney = 100;
        CategoryThreshold categoryThreshold = new CategoryThreshold();
        categoryThreshold.setMaxMoney(maxMoney);
        assertTrue(categoryThreshold.isExceeded(maxMoney + 1));
    }

    @Test
    public void turnOn() {
        CategoryThreshold categoryThreshold = new CategoryThreshold();
        categoryThreshold.turnOn();
        assertTrue(categoryThreshold.isActivated());
    }

    @Test
    public void turnOff() {
        CategoryThreshold categoryThreshold = new CategoryThreshold();
        categoryThreshold.turnOff();
        assertFalse(categoryThreshold.isActivated());
    }
}
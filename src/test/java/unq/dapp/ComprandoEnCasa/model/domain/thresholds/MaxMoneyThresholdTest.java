package unq.dapp.ComprandoEnCasa.model.domain.thresholds;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxMoneyThresholdTest {

    @Test
    public void turnOn() {
        MaxMoneyThreshold maxMoneyThreshold = new MaxMoneyThreshold();
        maxMoneyThreshold.turnOn();
        assertTrue(maxMoneyThreshold.isActivated());
    }

    @Test
    public void turnOff() {
        MaxMoneyThreshold maxMoneyThreshold = new MaxMoneyThreshold();
        maxMoneyThreshold.turnOff();
        assertFalse(maxMoneyThreshold.isActivated());
    }

    @Test
    public void setAndGetMaxMoney() {
        Integer maxMoney = 100;
        MaxMoneyThreshold maxMoneyThreshold = new MaxMoneyThreshold();
        maxMoneyThreshold.setMaxMoney(maxMoney);
        assertEquals(maxMoney, maxMoneyThreshold.getMaxMoney());
    }

    @Test
    public void isExceeded() {
        Integer maxMoney = 100;
        MaxMoneyThreshold maxMoneyThreshold = new MaxMoneyThreshold();
        maxMoneyThreshold.setMaxMoney(maxMoney);
        assertTrue(maxMoneyThreshold.isExceeded(maxMoney + 1));
    }

}
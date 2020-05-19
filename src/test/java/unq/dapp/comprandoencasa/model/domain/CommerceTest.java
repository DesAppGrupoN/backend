package unq.dapp.comprandoencasa.model.domain;


import org.junit.jupiter.api.Test;
import unq.dapp.comprandoencasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.comprandoencasa.model.domain.commerce.Commerce;
import unq.dapp.comprandoencasa.model.domain.commerce.PayMethods;
import unq.dapp.comprandoencasa.model.domain.commerce.Sector;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommerceTest {
    @Test
    public void constructorTest() {
        Sector sector = Sector.FOOD;
        String address = "address";
        ArrayList<PayMethods> payMethods = new ArrayList<PayMethods>();
        Integer maxDistance = 100;
        AttentionSchedule attentionSchedule = new AttentionSchedule();

        Commerce commerce = new Commerce(sector, address, payMethods, maxDistance, attentionSchedule);

        assertEquals(sector, commerce.getSector());
        assertEquals(address, commerce.getAddress());
        assertEquals(payMethods, commerce.getPayMethods());
        assertEquals(maxDistance, commerce.getMaxDistance());
        assertEquals(attentionSchedule, commerce.getAttentionSchedule());
    }

}

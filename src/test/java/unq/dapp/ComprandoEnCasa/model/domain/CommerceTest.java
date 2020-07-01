package unq.dapp.ComprandoEnCasa.model.domain;


import org.junit.jupiter.api.Test;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommerceTest {
    @Test
    public void constructorTest() {
        String name = "CommerceName";
        String description = "CommerceDescription";
        Sector sector = Sector.FOOD;
        String address = "address";
        String image = "image";
        ArrayList<PayMethods> payMethods = new ArrayList<PayMethods>();
        Integer maxDistance = 100;
        AttentionSchedule attentionSchedule = new AttentionSchedule();

        Commerce commerce = new Commerce(name,description,sector, address,image, payMethods, maxDistance,attentionSchedule);

        assertEquals(name, commerce.getName());
        assertEquals(description, commerce.getDescription());
        assertEquals(sector, commerce.getSector());
        assertEquals(address, commerce.getAddress());
        assertEquals(image, commerce.getImage());
        assertEquals(payMethods, commerce.getPayMethods());
        assertEquals(maxDistance, commerce.getMaxDistance());
    }

}

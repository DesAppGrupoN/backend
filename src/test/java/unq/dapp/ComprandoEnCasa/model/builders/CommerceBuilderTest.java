package unq.dapp.ComprandoEnCasa.model.builders;


import org.junit.jupiter.api.Test;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CommerceBuilderTest {
    @Test
    public void buildCommerceWithName() {
        String name = "name";
        Commerce commerce = CommerceBuilder.aCommerce().withName(name).build();

        assertEquals(name, commerce.getName());
    }

    @Test
    public void buildCommerceWithDescription() {
        String description = "description";
        Commerce commerce = CommerceBuilder.aCommerce().withName(description).build();

        assertEquals(description, commerce.getDescription());
    }

    @Test
    public void buildCommerceWithSector() {
        Sector sector= Sector.FOOD;
        Commerce commerce = CommerceBuilder.aCommerce().withSector(sector).build();

        assertEquals(sector, commerce.getSector());
    }

    @Test
    public void buildCommercewithAddress() {
        String address = "Quilmes";
        Commerce commerce = CommerceBuilder.aCommerce().withAddress(address).build();

        assertEquals(address, commerce.getAddress());
    }

    @Test
    public void buildCommerceWithImage() {
        String imageUrl = "imageUrl";
        Commerce commerce = CommerceBuilder.aCommerce().withImage(imageUrl).build();

        assertEquals(imageUrl, commerce.getImage());
    }

    @Test
    public void buildCommercewithPayMethods() {
        ArrayList<PayMethods> payMethods = new ArrayList<PayMethods>();
        payMethods.add(PayMethods.CASH);
        Commerce commerce = CommerceBuilder.aCommerce().withPayMethods(payMethods).build();

        assertEquals(payMethods, commerce.getPayMethods());
    }

    @Test
    public void buildCommercewithMaDistance() {
        Integer maxDistance = 100;
        Commerce commerce = CommerceBuilder.aCommerce().withMaDistance(maxDistance).build();

        assertEquals(maxDistance, commerce.getMaxDistance());
    }

    @Test
    public void buildCommercewithAttentionSchedule() {
        AttentionSchedule attentionSchedule = mock(AttentionSchedule.class);
        Commerce commerce = CommerceBuilder.aCommerce().withAttentionSchedule(attentionSchedule).build();

        assertEquals(attentionSchedule, commerce.getAttentionSchedule());
    }
}
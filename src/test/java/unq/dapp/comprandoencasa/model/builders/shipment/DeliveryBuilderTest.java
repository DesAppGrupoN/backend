package unq.dapp.comprandoencasa.model.builders.shipment;

import org.junit.jupiter.api.Test;
import unq.dapp.comprandoencasa.model.domain.shipment.Delivery;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeliveryBuilderTest {

    @Test
    public void withShippingAddress() {
        String shippingAddress = "any address";
        Delivery delivery = DeliveryBuilder.aDelivery().withShippingAddress(shippingAddress).build();

        assertEquals(shippingAddress, delivery.getShippingAddress());
    }

    @Test
    public void withDistance() {
        Integer distance = 100;
        Delivery delivery = DeliveryBuilder.aDelivery().withDistance(distance).build();

        assertEquals(distance, delivery.getDistance());
    }

    @Test
    public void withShippingDate() {
        LocalDate shippingDate = LocalDate.now();
        Delivery delivery = DeliveryBuilder.aDelivery().withShippingDate(shippingDate).build();

        assertEquals(shippingDate, delivery.getShippingDate());
    }
}
package unq.dapp.comprandoEnCasa.model.domain;

import org.junit.jupiter.api.Test;
import unq.dapp.comprandoEnCasa.model.domain.shipment.ShipmentType;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class PurchaseOrderTest {

    @Test
    public void constructorTest() {
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        ShipmentType shipmentType = mock(ShipmentType.class);
        LocalDate date = LocalDate.now();

        PurchaseOrder purchaseOrder = new PurchaseOrder(shoppingCart, shipmentType, date);

        assertEquals(shoppingCart, purchaseOrder.getShoppingCart());
        assertEquals(shipmentType, purchaseOrder.getShipmentType());
        assertEquals(date, purchaseOrder.getDate());
    }

}
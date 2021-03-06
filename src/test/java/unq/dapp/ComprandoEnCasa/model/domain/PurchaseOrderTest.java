package unq.dapp.ComprandoEnCasa.model.domain;

import org.junit.jupiter.api.Test;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentType;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentTypeEnum;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class PurchaseOrderTest {

    @Test
    public void constructorTest() {
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        ShipmentTypeEnum shipmentType = ShipmentTypeEnum.DELIVERY;
        LocalDate date = LocalDate.now();

        PurchaseOrder purchaseOrder = new PurchaseOrder(shoppingCart, shipmentType, date);

        assertEquals(shoppingCart, purchaseOrder.getShoppingCart());
        assertEquals(shipmentType, purchaseOrder.getShipmentType());
        assertEquals(date, purchaseOrder.getDate());
    }

}
package unq.dapp.ComprandoEnCasa.model.builders;

import org.junit.jupiter.api.Test;
import unq.dapp.ComprandoEnCasa.model.domain.PurchaseOrder;
import unq.dapp.ComprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentType;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentTypeEnum;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PurchaseOrderBuilderTest {

    @Test
    public void build() {
    }

    @Test
    public void withShoppingCart() {
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        Integer expectedTotalPrice = 100;
        when(shoppingCart.getTotalPrice()).thenReturn(expectedTotalPrice);
        PurchaseOrder purchaseOrder = PurchaseOrderBuilder.aPurchaseOrder().withShoppingCart(shoppingCart).build();

        assertEquals(shoppingCart, purchaseOrder.getShoppingCart());
        assertEquals(expectedTotalPrice, purchaseOrder.getTotalPrice());
    }

    @Test
    public void withShipmentType() {
        ShipmentTypeEnum shipmentType = ShipmentTypeEnum.DELIVERY;
        PurchaseOrder purchaseOrder = PurchaseOrderBuilder.aPurchaseOrder().withShipmentType(shipmentType).build();

        assertEquals(shipmentType, purchaseOrder.getShipmentType());
    }

    @Test
    public void withDate() {
        LocalDate date = LocalDate.now();
        PurchaseOrder purchaseOrder = PurchaseOrderBuilder.aPurchaseOrder().withDate(date).build();

        assertEquals(date, purchaseOrder.getDate());
    }

}
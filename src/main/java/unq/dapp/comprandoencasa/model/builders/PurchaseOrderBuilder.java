package unq.dapp.comprandoEnCasa.model.builders;


import unq.dapp.comprandoEnCasa.model.domain.PurchaseOrder;
import unq.dapp.comprandoEnCasa.model.domain.ShoppingCart;
import unq.dapp.comprandoEnCasa.model.domain.shipment.ShipmentType;

import java.time.LocalDate;

public class PurchaseOrderBuilder {

    private ShoppingCart shoppingCart ;
    private ShipmentType shipmentType;
    private LocalDate date;

    public static PurchaseOrderBuilder aPurchaseOrder() {
        return new PurchaseOrderBuilder();
    }

    public PurchaseOrderBuilder(){
        this.shoppingCart = new ShoppingCart();
        this.shipmentType = new ShipmentType() {};
        this.date = LocalDate.now();

    }
    public PurchaseOrder build() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setShoppingCart(this.shoppingCart);
        purchaseOrder.setShipmentType(this.shipmentType);
        purchaseOrder.setDate(this.date);

        return purchaseOrder;
    }

    public PurchaseOrderBuilder withShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        return this;
    }

    public PurchaseOrderBuilder withShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
        return this;
    }

    public PurchaseOrderBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

}

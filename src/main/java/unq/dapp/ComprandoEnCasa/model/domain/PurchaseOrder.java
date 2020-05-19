package unq.dapp.ComprandoEnCasa.model.domain;


import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentType;

import java.time.LocalDate;

public class PurchaseOrder {

    private ShoppingCart shoppingCart;
    private ShipmentType shipmentType;
    private LocalDate date;


    public PurchaseOrder() { }

    public PurchaseOrder(ShoppingCart shoppingCart, ShipmentType shipmentType, LocalDate date) {
        this.shoppingCart = shoppingCart;
        this.shipmentType = shipmentType;
        this.date = date;
    }

    public Integer getTotalPrice() {
        return this.shoppingCart.getTotalPrice();
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
    }

    public ShipmentType getShipmentType() {
        return shipmentType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

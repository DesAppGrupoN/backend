package unq.dapp.ComprandoEnCasa.model.domain;


import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentType;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentTypeEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseOrder {


    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    @Enumerated(EnumType.STRING)
    private ShipmentTypeEnum shipmentType;
    private Integer commerceId;
    private LocalDate date;


    public PurchaseOrder() { }

    public PurchaseOrder(ShoppingCart shoppingCart, ShipmentTypeEnum shipmentType, LocalDate date) {
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

    public void setShipmentType(ShipmentTypeEnum shipmentType) {
        this.shipmentType = shipmentType;
    }

    public ShipmentTypeEnum getShipmentType() {
        return shipmentType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(Integer commerceId) {
        this.commerceId = commerceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

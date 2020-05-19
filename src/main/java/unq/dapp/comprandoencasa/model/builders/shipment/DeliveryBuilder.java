package unq.dapp.comprandoEnCasa.model.builders.shipment;


import unq.dapp.comprandoEnCasa.model.domain.shipment.Delivery;

import java.time.LocalDate;

public class DeliveryBuilder {

    private String shippingAddress = "any address";
    private Integer distance = 0;
    private LocalDate shippingDate = LocalDate.MIN;

    public static DeliveryBuilder aDelivery() {
        return new DeliveryBuilder();
    }

    public Delivery build() {
        Delivery delivery = new Delivery();
        delivery.setShippingAddress(this.shippingAddress);
        delivery.setDistance(this.distance);
        delivery.setShippingDate(this.shippingDate);

        return delivery;
    }

    public DeliveryBuilder withShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public DeliveryBuilder withDistance(Integer distance) {
        this.distance = distance;
        return this;
    }

    public DeliveryBuilder withShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

}

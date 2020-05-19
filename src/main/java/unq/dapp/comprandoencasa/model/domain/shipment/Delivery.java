package unq.dapp.comprandoEnCasa.model.domain.shipment;

import java.time.LocalDate;

public class Delivery extends ShipmentType {
    private String shippingAddress;
    private Integer distance;
    private LocalDate shippingDate;

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}

package unq.dapp.ComprandoEnCasa.model.dtos;

import unq.dapp.ComprandoEnCasa.model.domain.shipment.ShipmentTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnDTO {
    private Integer commerceId;
    private LocalDate day;
    private LocalTime time;
    private ShipmentTypeEnum shipment;

    public TurnDTO() { }

    public Integer getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(Integer commerceId) {
        this.commerceId = commerceId;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public ShipmentTypeEnum getShipment() {
        return shipment;
    }

    public void setShipment(ShipmentTypeEnum shipment) {
        this.shipment = shipment;
    }
}

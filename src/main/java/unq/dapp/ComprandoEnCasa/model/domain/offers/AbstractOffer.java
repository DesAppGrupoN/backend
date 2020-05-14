package unq.dapp.ComprandoEnCasa.model.domain.offers;

import java.time.LocalDate;

abstract class AbstractOffer {

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer discount;

    public abstract Integer getTotal();

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}

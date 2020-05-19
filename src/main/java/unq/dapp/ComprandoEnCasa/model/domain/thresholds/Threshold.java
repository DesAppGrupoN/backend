package unq.dapp.ComprandoEnCasa.model.domain.thresholds;

public abstract class Threshold {

    private Boolean activated;
    private Integer maxMoney;

    public Boolean isActivated() {
        return this.activated;
    }

    public void turnOn() {
        this.activated = true;
    }

    public void turnOff() {
        this.activated = false;
    }

    public Integer getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(Integer maxMoney) {
        this.maxMoney = maxMoney;
    }

    public Boolean isExceeded(Integer amount) {
        return amount > this.maxMoney;
    }

}

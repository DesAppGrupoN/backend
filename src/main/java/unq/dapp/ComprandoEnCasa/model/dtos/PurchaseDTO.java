package unq.dapp.ComprandoEnCasa.model.dtos;

import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;

import java.util.List;

public class PurchaseDTO {

    private String userEmail;
    private PayMethods payMethod;
    private List<TurnDTO> turns;

    public PurchaseDTO() { }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public PayMethods getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethods payMethod) {
        this.payMethod = payMethod;
    }

    public List<TurnDTO> getTurns() {
        return turns;
    }

    public void setTurns(List<TurnDTO> turns) {
        this.turns = turns;
    }
}

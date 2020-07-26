package unq.dapp.ComprandoEnCasa.model.domain.shipment;


import unq.dapp.ComprandoEnCasa.model.domain.Turn;

public class OnSite extends ShipmentType {

    private Turn turn;

    public OnSite() { }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }
}

package unq.dapp.comprandoEnCasa.model.domain.shipment;


import unq.dapp.comprandoEnCasa.model.domain.Turn;

public class OnSite extends ShipmentType {

    private Turn turn;

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }
}

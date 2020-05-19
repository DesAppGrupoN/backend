package unq.dapp.comprandoencasa.model.domain.shipment;


import unq.dapp.comprandoencasa.model.domain.Turn;

public class OnSite extends ShipmentType {

    private Turn turn;

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }
}

package unq.dapp.ComprandoEnCasa.model.builders.shipment;


import unq.dapp.ComprandoEnCasa.model.domain.Turn;
import unq.dapp.ComprandoEnCasa.model.domain.shipment.OnSite;

public class OnSiteBuilder {

    private Turn turn = new Turn();

    public static OnSiteBuilder anOnSite() {
        return new OnSiteBuilder();
    }

    public OnSite build() {
        OnSite onSite = new OnSite();
        onSite.setTurn(this.turn);
        return onSite;
    }

    public OnSiteBuilder withTurn(Turn turn) {
        this.turn = turn;
        return this;
    }

}

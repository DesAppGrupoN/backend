package unq.dapp.comprandoEnCasa.model.builders;



import unq.dapp.comprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.comprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.comprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.comprandoEnCasa.model.domain.commerce.Sector;

import java.util.ArrayList;
import java.util.List;

public class CommerceBuilder {

    private Sector sector;
    private String address;
    private List<PayMethods> payMethods;
    private Integer maxDistance;
    private AttentionSchedule attentionSchedule;

    public static CommerceBuilder aCommerce() {
        return new CommerceBuilder();
    }

    public  CommerceBuilder(){
        this.sector = Sector.FOOD;
        this.address = "no address";
        this.payMethods = new ArrayList<PayMethods>();
        this.maxDistance = 0;
        this.attentionSchedule = new AttentionSchedule();

    }
    public Commerce build() {
        Commerce commerce = new Commerce();
        commerce.setSector(this.sector);
        commerce.setAddress(this.address);
        commerce.setPayMethods(this.payMethods);
        commerce.setMaxDistance(this.maxDistance);
        commerce.setAttentionSchedule(this.attentionSchedule);
        return commerce;
    }

    public CommerceBuilder withSector(Sector sector) {
        this.sector = sector;
        return this;
    }

    public CommerceBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CommerceBuilder withPayMethods(ArrayList<PayMethods> payMethods) {
        this.payMethods = payMethods;
        return this;
    }

    public CommerceBuilder withMaDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
        return this;
    }

    public CommerceBuilder withAttentionSchedule(AttentionSchedule attentionSchedule) {
        this.attentionSchedule = attentionSchedule;
        return this;
    }



}

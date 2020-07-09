package unq.dapp.ComprandoEnCasa.model.builders;



import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Commerce;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;

import java.util.ArrayList;
import java.util.List;

public class CommerceBuilder {

    private Integer id;
    private String name;
    private String description;
    private Sector sector;
    private String address;
    private String image;
    private List<PayMethods> payMethods;
    private Integer maxDistance;
    private AttentionSchedule attentionSchedule;

    public static CommerceBuilder aCommerce() {
        return new CommerceBuilder();
    }

    public  CommerceBuilder(){
        this.id = null;
        this.name = "name";
        this.description = "description";
        this.sector = Sector.FOOD;
        this.address = "no address";
        this.image = "urlImage";
        this.payMethods = new ArrayList<PayMethods>();
        this.maxDistance = 0;
        this.attentionSchedule = new AttentionSchedule();

    }
    public Commerce build() {
        Commerce commerce = new Commerce();
        commerce.setName(this.name);
        commerce.setDescription(this.description);
        commerce.setSector(this.sector);
        commerce.setAddress(this.address);
        commerce.setImage(this.image);
        commerce.setPayMethods(this.payMethods);
        commerce.setMaxDistance(this.maxDistance);
        commerce.setAttentionSchedule(this.attentionSchedule);

        if(this.id != null) {
            commerce.setId(this.id);
        }

        return commerce;
    }

    public CommerceBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CommerceBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
    public CommerceBuilder withSector(Sector sector) {
        this.sector = sector;
        return this;
    }

    public CommerceBuilder withAddress(String address) {
        this.address = address;
        return this;
    }
    public CommerceBuilder withImage(String imageUrl) {
        this.image = imageUrl;
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


    public CommerceBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

}

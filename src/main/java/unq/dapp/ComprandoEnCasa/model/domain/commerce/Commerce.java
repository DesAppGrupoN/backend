package unq.dapp.ComprandoEnCasa.model.domain.commerce;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commerce {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Sector sector;

    private String address;

    private String image ;

    @ElementCollection(targetClass = PayMethods.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<PayMethods> payMethods;

    private Integer maxDistance;
    @OneToOne(targetEntity=AttentionSchedule.class)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private AttentionSchedule attentionSchedule;

    public Commerce() { }

    public Commerce(String name,String description,Sector sector, String address,String image, List<PayMethods> payMethods, Integer maxDistance) {
        this.name = name;
        this.description = description;
        this.sector = sector;
        this.address = address;
        this.image = image ;
        this.payMethods = payMethods;
        this.maxDistance = maxDistance;
        this.attentionSchedule = new AttentionSchedule();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Sector getSector() {
        return this.sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public List<PayMethods> getPayMethods() {
        return this.payMethods;
    }

    public void setPayMethods(List<PayMethods> payMethods) {
        this.payMethods = payMethods;
    }

    public Integer getMaxDistance() {
        return this.maxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public AttentionSchedule getAttentionSchedule() {
        return this.attentionSchedule;
    }

    public Integer getId() { return id; }

    public void setAttentionSchedule(AttentionSchedule attentionSchedule) {
        this.attentionSchedule = attentionSchedule;
    }
}

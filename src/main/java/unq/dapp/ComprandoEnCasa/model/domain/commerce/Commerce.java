package unq.dapp.ComprandoEnCasa.model.domain.commerce;


import javax.persistence.*;
import java.util.List;

@Entity
public class Commerce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Sector sector;

    private String address;

    @ElementCollection(targetClass = PayMethods.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<PayMethods> payMethods;

    private Integer maxDistance;

    @Transient
    private AttentionSchedule attentionSchedule;

    public Commerce() { }

    public Commerce(Sector sector, String address, List<PayMethods> payMethods, Integer maxDistance, AttentionSchedule attentionSchedule) {
        this.sector = sector;
        this.address = address;
        this.payMethods = payMethods;
        this.maxDistance = maxDistance;
        this.attentionSchedule = attentionSchedule;
    }

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

    public void setAttentionSchedule(AttentionSchedule attentionSchedule) {
        this.attentionSchedule = attentionSchedule;
    }
}

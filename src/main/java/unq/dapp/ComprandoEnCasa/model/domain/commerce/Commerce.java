package unq.dapp.ComprandoEnCasa.model.domain.commerce;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Commerce {

    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Sector sector;
    @NotBlank(message = "Address is mandatory")
    private String address;

    private String image;

    @ElementCollection(targetClass = PayMethods.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<PayMethods> payMethods;
    @NotNull(message = "maxDistance is mandatory")
    @Range(min = 0)
    private Integer maxDistance;

    @OneToOne(cascade = CascadeType.ALL)
    private AttentionSchedule attentionSchedule;

    public Commerce() { }

    public Commerce(String name,String description,Sector sector, String address,String image, List<PayMethods> payMethods, Integer maxDistance,AttentionSchedule attentionSchedule) {
        this.name = name;
        this.description = description;
        this.sector = sector;
        this.address = address;
        this.image = image ;
        this.payMethods = payMethods;
        this.maxDistance = maxDistance;
        this.attentionSchedule = attentionSchedule;
    }

    @Override
    public boolean equals(Object other) {
        return other.getClass() == this.getClass() && ((Commerce) other).id == this.id;
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

    public void setId(Integer id) { this.id = id; }

    public void setAttentionSchedule(AttentionSchedule attentionSchedule) {
        this.attentionSchedule = attentionSchedule;
    }
}

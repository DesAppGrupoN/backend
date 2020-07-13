package unq.dapp.ComprandoEnCasa.model.dtos;

import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.PayMethods;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.Sector;

import java.time.LocalTime;
import java.util.ArrayList;

public class CommerceDTO {

    private Integer id;
    private String name;
    private String description;
    private Sector sector;
    private String address;
    private String image;
    private ArrayList<PayMethods> payMethods;
    private Integer maxDistance;
    private AttentionScheduleDTO attentionScheduleDTO;
    private String userEmail;

    public CommerceDTO() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<PayMethods> getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(ArrayList<PayMethods> payMethods) {
        this.payMethods = payMethods;
    }

    public Integer getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public AttentionSchedule getAttentionSchedule() {
        AttentionSchedule attentionSchedule = new AttentionSchedule();
        attentionSchedule.setDays(this.attentionScheduleDTO.getDays());
        String[] timesOpening = attentionScheduleDTO.getOpeningTime().split(":");
        LocalTime openingTime = LocalTime.of(Integer.parseInt(timesOpening [0]), Integer.parseInt(timesOpening [1]));
        attentionSchedule.setOpeningTime(openingTime);
        String[] timesClosing = attentionScheduleDTO.getClosingTime().split(":");
        LocalTime closingTime = LocalTime.of(Integer.parseInt(timesClosing[0]), Integer.parseInt(timesClosing[1]));
        attentionSchedule.setClosingTime(closingTime);

        return attentionSchedule; }

    public void setAttentionScheduleDTO(AttentionScheduleDTO attentionScheduleDTO) { this.attentionScheduleDTO = attentionScheduleDTO; }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

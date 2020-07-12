package unq.dapp.ComprandoEnCasa.model.domain.commerce;
import unq.dapp.ComprandoEnCasa.model.domain.Turn;
import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Entity
public class AttentionSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> days;
    private LocalTime openingTime;
    private LocalTime closingTime;

    @Transient
    private List<Turn> turns;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public AttentionSchedule() {
    }

    public AttentionSchedule(List<DayOfWeek> days, LocalTime openingTime, LocalTime closingTime) {
        this.days = days;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public List<DayOfWeek> getDays() {
        return this.days;
    }

    public void setDays(List<DayOfWeek> days) { this.days = days; }

    public boolean isOpeningDay(DayOfWeek day){
        return days.contains(day);
    }

    public boolean isOpening(DayOfWeek day, LocalTime time) {
        return this.days.contains(day) && time.isAfter(openingTime) && time.isBefore(closingTime);
    }

    public LocalTime getOpeningTime() { return openingTime; }

    public void setOpeningTime(LocalTime openingTime) { this.openingTime = openingTime; }

    public LocalTime getClosingTime() { return closingTime; }

    public void setClosingTime(LocalTime closingTime) { this.closingTime = closingTime; }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public List<LocalTime> getTurnsForDay(DayOfWeek day) {
        List<LocalTime> turns = new ArrayList<LocalTime>();
        LocalTime hour = this.openingTime;
        long hours = this.openHours();
        LocalTime hourClosing = this.closingTime;
        for (int i = -1; i < hours * 2; ++i)
            if (hour.isBefore(hourClosing) || hour.equals(hourClosing)) {
                turns.add(hour);
                hour = hour.plusMinutes(30);
            }

        return turns;
    }

    public long openHours() { return this.openingTime.until(this.closingTime, ChronoUnit.HOURS); }


    public void assignTurn(Turn turn) {
        this.turns.add(turn);
    }
    public void removeTurn(Turn turn) {
        this.turns.remove(turn);
    }


}
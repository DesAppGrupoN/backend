package unq.dapp.ComprandoEnCasa.model.domain.commerce;


import unq.dapp.ComprandoEnCasa.model.domain.Turn;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class AttentionSchedule {
    @Id
    @GeneratedValue
    private Integer Id;
    @ElementCollection
    private List<OpeningTime> schedule;
    @Transient
    private List<Turn> turns;

    public AttentionSchedule() {
        this.schedule = new ArrayList<>();
        this.turns = new ArrayList<>();
    }

    public void addDayTimes( OpeningTime time) { schedule.add(time); }

    public List<OpeningTime> getTimesOfTheDay(DayOfWeek day) {
        return schedule.stream()
                .filter(openingTime -> openingTime.getDay() == day)
                .collect(Collectors.toList());
    }

    public List<DayOfWeek> getDays() {
        return schedule.stream()
                        .map(e->e.getDay())
                        .collect(Collectors.toList());
    }

    public void removeDayTime( OpeningTime time) { this.schedule.remove(time); }

    public boolean isOpening(DayOfWeek day, LocalTime time) {
        List<OpeningTime> times = this.getTimesOfTheDay(day);
        boolean bool = false;

        for (OpeningTime openingTime : times) {
            bool = bool || openingTime.isOpening(time);
        }

        return bool;
    }

    public List<Turn> getTurns() { return turns; }

    public void setTurns(List<Turn> turns) { this.turns = turns; }

    public List<LocalTime> getTurnsForDay(DayOfWeek day) {
        List<OpeningTime> times = this.getTimesOfTheDay(day);
        List<LocalTime> turns = new ArrayList<LocalTime>();

        for (OpeningTime openingTime : times) {
            LocalTime hour = openingTime.getHourStart();
            long hours = openingTime.getHoursOpening();
            LocalTime hourClosing = openingTime.getHourEnd();
            for (int i = -1; i < hours*2; ++i)
                if(hour.isBefore(hourClosing) || hour.equals(hourClosing)){
                    turns.add(hour);
                    hour= hour.plusMinutes(30);}
        }
        return turns;
    }

    public void assignTurn(Turn turn) {
        this.turns.add(turn);
    }
    public void removeTurn(Turn turn) {
        this.turns.remove(turn);
    }

}
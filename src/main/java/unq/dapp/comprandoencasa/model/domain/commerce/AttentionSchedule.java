package unq.dapp.comprandoEnCasa.model.domain.commerce;


import unq.dapp.comprandoEnCasa.model.domain.Turn;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class AttentionSchedule {

    private Map<DayOfWeek, List<OpeningTime>> schedule;
    private List<Turn> turns ;

    public AttentionSchedule() {
        this.schedule = new HashMap<DayOfWeek, List<OpeningTime>>();
        this.turns = new ArrayList<Turn>();
    }

    public void addDayTimes(DayOfWeek day, OpeningTime time) {
        if (!schedule.containsKey(day)) {
            List list = new ArrayList();
            list.add(time);
            schedule.put(day, list);
        } else {
            List list = schedule.get(day);
            list.add(time);
            schedule.put(day, list);
        }
    }

    public List<OpeningTime> getTimesOfTheDay(DayOfWeek day) {
        return schedule.get(day);
    }

    public Set<DayOfWeek> getDays() {
        return this.schedule.keySet();
    }

    public void removeDay(DayOfWeek day) {
        this.schedule.remove(day);
    }

    public void removeDayTime(DayOfWeek day, OpeningTime time) {

        List<OpeningTime> times = this.getTimesOfTheDay(day);
        times.remove(time);
        this.schedule.remove(day);
        this.schedule.put(day, times);
    }

    public boolean isOpening(DayOfWeek day, LocalTime time) {
        List<OpeningTime> times = this.getTimesOfTheDay(day);
        Boolean bool = false;

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
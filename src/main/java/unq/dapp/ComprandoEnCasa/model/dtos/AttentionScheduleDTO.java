package unq.dapp.ComprandoEnCasa.model.dtos;

import unq.dapp.ComprandoEnCasa.model.domain.Turn;

import javax.persistence.Transient;
import java.time.DayOfWeek;
import java.util.List;

public class AttentionScheduleDTO {
    private List<DayOfWeek> days;
    private String openingTime;
    private String closingTime;

    @Transient
    private List<Turn> turns;

    public List<DayOfWeek> getDays() { return days; }

    public void setDays(List<DayOfWeek> days) { this.days = days; }

    public String getOpeningTime() { return openingTime; }

    public void setOpeningTime(String openingTime) { this.openingTime = openingTime; }

    public String getClosingTime() { return closingTime; }

    public void setClosingTime(String closingTime) { this.closingTime = closingTime; }

    public List<Turn> getTurns() { return turns; }

    public void setTurns(List<Turn> turns) { this.turns = turns; }
}

package unq.dapp.comprandoencasa.model.domain.commerce;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class OpeningTime {
    public LocalTime hourStart;
    public LocalTime hourEnd;

    public OpeningTime(){}

    public LocalTime getHourStart() { return hourStart; }

    public LocalTime getHourEnd() { return hourEnd; }

    public void setHourStart(LocalTime time) { this.hourStart = time;}

    public void setHourEnd(LocalTime time) { this.hourEnd = time;}

    public long getHoursOpening() { return this.hourStart.until(this.hourEnd, ChronoUnit.HOURS ) ;}

    public boolean isOpening(LocalTime time) {

        return time.isAfter(getHourStart()) && time.isBefore(getHourEnd());

    }
}

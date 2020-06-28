package unq.dapp.ComprandoEnCasa.model.domain.commerce;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
@Entity
public class OpeningTime {
    @Id
    String id;
    public DayOfWeek day;
    public LocalTime hourStart;
    public LocalTime hourEnd;

    public OpeningTime(){}

    public LocalTime getHourStart() { return hourStart; }

    public LocalTime getHourEnd() { return hourEnd; }

    public DayOfWeek getDay() { return day; }

    public void setDay(DayOfWeek day) { this.day = day; }

    public void setHourStart(LocalTime time) { this.hourStart = time;}

    public void setHourEnd(LocalTime time) { this.hourEnd = time;}

    public long getHoursOpening() { return this.hourStart.until(this.hourEnd, ChronoUnit.HOURS ) ;}

    public boolean isOpening(LocalTime time) {
        return time.isAfter(getHourStart()) && time.isBefore(getHourEnd());
    }
}

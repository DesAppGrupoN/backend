package unq.dapp.ComprandoEnCasa.model.domain;


import org.junit.jupiter.api.Test;
import unq.dapp.ComprandoEnCasa.model.domain.commerce.AttentionSchedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AttentionScheduleTest {

    @Test
    public void attentionScheduleIsOpeningTimeDay(){
        LocalTime startingTime = LocalTime.of(9, 00);
        LocalTime endingTime = LocalTime.of(12, 30);
        DayOfWeek day = DayOfWeek.FRIDAY;
        ArrayList<DayOfWeek> days = new ArrayList<>();
        days.add(day);
        AttentionSchedule attentionSchedule = new AttentionSchedule(days,startingTime,endingTime);

        assertTrue(attentionSchedule.isOpening(day,(LocalTime.of(10,00))));
        assertFalse(attentionSchedule.isOpening(day,(LocalTime.of(15,00))));
        assertEquals(attentionSchedule.openHours(),3);
    }

    @Test
    public void attentionScheduleIsOpeningDay(){
        LocalTime startingTime = LocalTime.of(9, 00);
        LocalTime endingTime = LocalTime.of(12, 30);
        DayOfWeek day = DayOfWeek.FRIDAY;
        DayOfWeek day2 = DayOfWeek.SATURDAY;
        ArrayList<DayOfWeek> days = new ArrayList<>();
        days.add(day);
        AttentionSchedule attentionSchedule = new AttentionSchedule(days,startingTime,endingTime);

        assertTrue(attentionSchedule.isOpeningDay(day));
        assertFalse(attentionSchedule.isOpeningDay(day2));
    }
}

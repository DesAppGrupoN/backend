package unq.dapp.comprandoEnCasa.model.domain;


import org.junit.jupiter.api.Test;
import unq.dapp.comprandoEnCasa.model.domain.commerce.AttentionSchedule;
import unq.dapp.comprandoEnCasa.model.domain.commerce.OpeningTime;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AttentionScheduleTest {

    @Test
    public void attentionScheduleAddDayTimesTest() {
        DayOfWeek day = DayOfWeek.FRIDAY;
        OpeningTime openingTime= mock(OpeningTime.class);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.addDayTimes(day, openingTime);
        assertEquals(schedule.getTimesOfTheDay(day).size(),1);
    }

    @Test
    public void attentionScheduleAddDayTwoTimesTest() {
        DayOfWeek day = DayOfWeek.FRIDAY;
        OpeningTime openingTime= mock(OpeningTime.class);
        OpeningTime openingTime2= mock(OpeningTime.class);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.addDayTimes(day, openingTime);
        assertEquals(schedule.getTimesOfTheDay(day).size(),1);
        schedule.addDayTimes(day, openingTime2);
        assertEquals(schedule.getTimesOfTheDay(day).size(),2);
    }
    @Test
    public void attentionScheduleAddTwoDayTimesTest() {
        DayOfWeek friday = DayOfWeek.FRIDAY;
        DayOfWeek saturday = DayOfWeek.SATURDAY;
        OpeningTime openingTime= mock(OpeningTime.class);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.addDayTimes(friday,openingTime);
        assertEquals(schedule.getDays().size(),1);
        schedule.addDayTimes(saturday,openingTime);
        assertEquals(schedule.getDays().size(),2);
    }
    @Test
    public void attentionScheduleRemoveDayTest() {
        DayOfWeek day = DayOfWeek.FRIDAY;
        OpeningTime openingTime= mock(OpeningTime.class);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.addDayTimes(day,openingTime);
        assertEquals(schedule.getDays().size(),1);
        schedule.removeDay(day);
        assertEquals(schedule.getDays().size(),0);
    }
    @Test
    public void attentionScheduleRemoveDayTimeTest() {
        DayOfWeek day = DayOfWeek.FRIDAY;
        OpeningTime openingTime= mock(OpeningTime.class);
        OpeningTime openingTime2= mock(OpeningTime.class);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.addDayTimes(day,openingTime);
        assertEquals(schedule.getTimesOfTheDay(day).size(),1);
        schedule.addDayTimes(day,openingTime2);
        assertEquals(schedule.getTimesOfTheDay(day).size(),2);
        schedule.removeDayTime(day,openingTime2);
        assertEquals(schedule.getTimesOfTheDay(day).size(),1);
    }

    @Test
    public void attentionScheduleDayOpeningTimeTest() {
        DayOfWeek day = DayOfWeek.FRIDAY;
        LocalTime openTime = LocalTime.of(9, 00);
        LocalTime closeTime = LocalTime.of(20, 00);
        OpeningTime openingTime= mock(OpeningTime.class);
        when(openingTime.isOpening(openTime)).thenReturn(true);
        when(openingTime.isOpening(closeTime)).thenReturn(false);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.addDayTimes(day,openingTime);
        assertTrue(schedule.isOpening(day,openTime));
        assertFalse(schedule.isOpening(day,closeTime));
    }

    @Test
    public void attentionScheduleDayTwoOpeningTimeTest() {
        DayOfWeek day = DayOfWeek.FRIDAY;
        LocalTime openTime = LocalTime.of(9, 00);
        LocalTime closeTime = LocalTime.of(20, 00);
        OpeningTime openingTime= mock(OpeningTime.class);
        when(openingTime.isOpening(openTime)).thenReturn(true);
        when(openingTime.isOpening(closeTime)).thenReturn(false);
        OpeningTime openingTime2= mock(OpeningTime.class);
        when(openingTime2.isOpening(openTime)).thenReturn(false);
        when(openingTime2.isOpening(closeTime)).thenReturn(false);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.addDayTimes(day,openingTime);
        schedule.addDayTimes(day,openingTime2);
        assertTrue(schedule.isOpening(day,openTime));
        assertFalse(schedule.isOpening(day,closeTime));
    }
    @Test
    public void attentionScheduleGetTurns(){
        DayOfWeek day = DayOfWeek.FRIDAY;
        OpeningTime openingTime= mock(OpeningTime.class);
        AttentionSchedule schedule = new AttentionSchedule();
        LocalTime startingTime = LocalTime.of(9, 00);
        LocalTime endingTime = LocalTime.of(12, 30);
        when(openingTime.getHourStart()).thenReturn(startingTime);
        when(openingTime.getHourEnd()).thenReturn(endingTime);
        when(openingTime.getHoursOpening()).thenReturn(startingTime.until(endingTime, ChronoUnit.HOURS)+1);

        schedule.addDayTimes(day,openingTime);

        assertEquals(schedule.getTurnsForDay(day).get(0),startingTime);
        assertEquals(schedule.getTurnsForDay(day).size(),8);
    }
    @Test
    public void attentionScheduleGetTurnsTwoOpeningTime(){
        DayOfWeek day = DayOfWeek.FRIDAY;
        OpeningTime openingTime= mock(OpeningTime.class);
        OpeningTime openingTime2= mock(OpeningTime.class);
        AttentionSchedule schedule = new AttentionSchedule();
        LocalTime startingTime = LocalTime.of(9, 00);
        LocalTime endingTime = LocalTime.of(12, 30);
        LocalTime startingTime2 = LocalTime.of(16, 00);
        LocalTime endingTime2 = LocalTime.of(21, 30);
        when(openingTime.getHourStart()).thenReturn(startingTime);
        when(openingTime.getHourEnd()).thenReturn(endingTime);
        when(openingTime.getHoursOpening()).thenReturn(startingTime.until(endingTime, ChronoUnit.HOURS) +1);
        when(openingTime2.getHourStart()).thenReturn(startingTime2);
        when(openingTime2.getHourEnd()).thenReturn(endingTime2);
        when(openingTime2.getHoursOpening()).thenReturn(startingTime2.until(endingTime2, ChronoUnit.HOURS) +1);

        schedule.addDayTimes(day,openingTime);
        schedule.addDayTimes(day,openingTime2);

        assertEquals(schedule.getTurnsForDay(day).get(0),startingTime);
        assertEquals(schedule.getTurnsForDay(day).get(7),endingTime);
        assertEquals(schedule.getTurnsForDay(day).get(8),startingTime2);
        assertEquals(schedule.getTurnsForDay(day).get(19),endingTime2);
    }

    @Test
    public void attentionScheduleAssignTurn(){
        Turn turn = mock(Turn.class);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.assignTurn(turn);
        assertEquals(schedule.getTurns().size(),1);
        assertEquals(schedule.getTurns().get(0),turn);
    }
    @Test
    public void attentionScheduleRemoveTurn(){
        Turn turn = mock(Turn.class);
        AttentionSchedule schedule = new AttentionSchedule();

        schedule.assignTurn(turn);
        assertEquals(schedule.getTurns().size(),1);
        assertEquals(schedule.getTurns().get(0),turn);
        schedule.removeTurn(turn);
        assertEquals(schedule.getTurns().size(),0);
    }
}

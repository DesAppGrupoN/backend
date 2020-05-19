package unq.dapp.comprandoencasa.model.domain;


import org.junit.jupiter.api.Test;
import unq.dapp.comprandoencasa.model.domain.commerce.OpeningTime;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpeningTimeTest {

    @Test
    public void OpeningTimesAddTimesTest() {
        LocalTime startingTime = LocalTime.of(9, 00);
        LocalTime endingTime = LocalTime.of(18, 00);
        OpeningTime openingTime = new OpeningTime();

        openingTime.setHourStart(startingTime);
        openingTime.setHourEnd(endingTime);
        assertEquals(startingTime, openingTime.getHourStart());
        assertEquals(endingTime, openingTime.getHourEnd());
    }

    @Test
    public void attentionScheduleDayOpeningTimeTest() {
        LocalTime startingTime = LocalTime.of(9, 00);
        LocalTime endingTime = LocalTime.of(18, 00);
        OpeningTime openingTime = new OpeningTime();
        LocalTime timeOpen = LocalTime.of(11, 00);
        LocalTime timeClose = LocalTime.of(20, 00);

        openingTime.setHourStart(startingTime);
        openingTime.setHourEnd(endingTime);

        assertTrue(openingTime.isOpening(timeOpen));
        assertFalse(openingTime.isOpening(timeClose));
    }
    @Test
    public void attentionScheduleDayOpeningTimeHoursOpeningTest() {
        LocalTime startingTime = LocalTime.of(9, 00);
        LocalTime endingTime = LocalTime.of(18, 00);
        OpeningTime openingTime = new OpeningTime();
        openingTime.setHourStart(startingTime);
        openingTime.setHourEnd(endingTime);
        long hours= 9;

       assertEquals(openingTime.getHoursOpening(),hours);
    }
}

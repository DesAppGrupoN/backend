package unq.dapp.ComprandoEnCasa.model.domain.offers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class AbstractOfferTest {

    @Test
    public void getStartDate() {
        AbstractOffer abstractOffer = mock(AbstractOffer.class, Mockito.CALLS_REAL_METHODS);
        LocalDate startDate = LocalDate.now();
        abstractOffer.setStartDate(startDate);
        assertEquals(startDate, abstractOffer.getStartDate());
    }

    @Test
    public void getEndDate() {
        AbstractOffer abstractOffer = mock(AbstractOffer.class, Mockito.CALLS_REAL_METHODS);
        LocalDate endDate = LocalDate.now();
        abstractOffer.setEndDate(endDate);
        assertEquals(endDate, abstractOffer.getEndDate());
    }

    @Test
    public void getDiscount() {
        AbstractOffer abstractOffer = mock(AbstractOffer.class, Mockito.CALLS_REAL_METHODS);
        Integer discount = 10;
        abstractOffer.setDiscount(discount);
        assertEquals(discount, abstractOffer.getDiscount());
    }
}
package unq.dapp.comprandoEnCasa.model.builders.shipment;


import org.junit.jupiter.api.Test;
import unq.dapp.comprandoEnCasa.model.domain.Turn;
import unq.dapp.comprandoEnCasa.model.domain.shipment.OnSite;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class OnSiteBuilderTest {

    @Test
    public void withTurn() {
        Turn anyTurn = mock(Turn.class);
        OnSite onSite = OnSiteBuilder.anOnSite().withTurn(anyTurn).build();

        assertEquals(anyTurn, onSite.getTurn());
    }
}
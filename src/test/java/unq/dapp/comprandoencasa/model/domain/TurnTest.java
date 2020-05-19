package unq.dapp.comprandoencasa.model.domain;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class TurnTest {

    @Test
    public void TimeAndUserTest() {
        LocalTime time = LocalTime.of(9, 00);
        User user = mock(User.class);
        Turn turn = new Turn();

        turn.setTimeTurn(time);
        turn.setUser(user);
        assertEquals(time,turn.getTimeTurn());
        assertEquals(user,turn.getUser());
    }
}

package unq.dapp.comprandoencasa.model.domain;

import java.time.LocalTime;

public class Turn {

    public LocalTime timeTurn;
    public User user;

    public Turn(){}

    public LocalTime getTimeTurn() {
        return timeTurn;
    }

    public void setTimeTurn(LocalTime timeTurn) {
        this.timeTurn = timeTurn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

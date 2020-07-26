package unq.dapp.ComprandoEnCasa.model.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turn {

    private LocalDate dateTurn;
    private LocalTime timeTurn;
    private User user;

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

    public LocalDate getDateTurn() {
        return dateTurn;
    }

    public void setDateTurn(LocalDate dateTurn) {
        this.dateTurn = dateTurn;
    }
}

package com.ood.parkinglot;

import java.math.BigDecimal;

public class ExitPoint {
    private int  id;

    public ExitPoint(int id) {
        this.id = id;
    }

    double scanTicket(ParkingTicket ticket) {
        double amountToBePaid = ticket.calculateAmount();
        return amountToBePaid;
    }
}
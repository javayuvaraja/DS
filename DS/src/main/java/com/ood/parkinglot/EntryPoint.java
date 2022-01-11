package com.ood.parkinglot;

import java.time.LocalDateTime;

public class EntryPoint {
    private final int id;

    public EntryPoint(int id) {
        this.id = id;
    }

    ParkingTicket generateTicket(Vehicle vehicle) {
        VehicleType type = vehicle.getType();
        ParkingRate rate = ParkingRate.valueOf(type.toString());

        return new ParkingTicket(LocalDateTime.now(), rate);
    }
}
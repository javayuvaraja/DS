package com.ood.parkinglot;

import java.util.Objects;

class ParkingSpot {
    private final Double id;
    private final ParkingSpotType type;
    private Vehicle vehicle;

    ParkingSpot(ParkingSpotType type) {
        this.id = Math.random();
        this.type = type;
    }

    public ParkingSpotType getType() {
        return type;
    }

    void parkVehicle(Vehicle vehicle) throws RuntimeException {
        if (Objects.nonNull(this.vehicle)) {
            throw new RuntimeException("Already vehicle is parked");
        }
        this.vehicle = vehicle;
    }

    Vehicle unParkVehicle() throws RuntimeException {
        if (Objects.nonNull(this.vehicle)) {
            Vehicle vehicle = this.vehicle;
            this.vehicle = null;
            return vehicle;
        }
        throw new RuntimeException("Vehicle doesn't exist in parking spot");
    }

    @Override
    public String toString() {
        return "{id= " + id + ", type= " + type + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return id.equals(that.id) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
package com.ood.parkinglot;

import java.util.List;

public class ParkingLot {
    private final List<ParkingFloor> parkingFloors;
    private final List<EntryPoint> entryPoints;
    private final List<EntryPoint> exitPoints;
    private final EntrancePanel entrancePanel;

    public ParkingLot(List<ParkingFloor> parkingFloors, List<EntryPoint> entryPoints,
                      List<EntryPoint> exitPoints) {
        this.parkingFloors = parkingFloors;
        this.entryPoints = entryPoints;
        this.exitPoints = exitPoints;
        this.entrancePanel = new EntrancePanel();
    }

    ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            if (floor.hasSpace(vehicle)) {
                ParkingSpot parkingSpot = floor.parkVehicle(vehicle);
                // entrance panel has to refresh available total no.of.spots 
                // if no full then display full in the entrance panel.
                entrancePanel.showAvailability("");
                return parkingSpot;
            }
        }

        throw new RuntimeException("All floors are already full");
    }

    Vehicle unParkVehicle(ParkingSpot parkingSpot) {
        for (ParkingFloor floor : parkingFloors) {
            if (floor.hasGivenParkingSpot(parkingSpot)) {
            	// entrance panel has to refresh available total no.of.spots
            	entrancePanel.showAvailability("");
            	return floor.unParkVehicle(parkingSpot);
            }
        }

        throw new RuntimeException("Either this parking spot doesn't exist or it's empty");
    }

    Boolean isNotFull() {
        for (ParkingFloor parkingFloor : this.parkingFloors) {
            if (parkingFloor.isNotFull())
                return true;
        }
        return false;
    }
}
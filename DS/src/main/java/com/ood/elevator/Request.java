package com.ood.elevator;

public class Request {

    int currentFloor;
    int desiredFloor;
    Direction direction;
    RequestType requestType;

    public Request(int currentFloor, int desiredFloor, Direction direction, RequestType location) {
        this.currentFloor = currentFloor;
        this.desiredFloor = desiredFloor;
        this.direction = direction;
        this.requestType = location;
    }
}
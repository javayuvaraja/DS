package com.yuva.oop.design.battleship;

public class ShipField implements IGameField {
    private final Ship ship;

    public ShipField(Ship ship) {
        this.ship = ship;
    }

    @Override
    public char getIcon() {
        char icon;
        ShipStatus shipState = ship.getState();
        switch (shipState) {
            case PARTIAL_HIT: icon = 'O';
                break;
            case DESTROYED: icon = 'O';
                break;
            case NO_HIT: icon = 'X';
                break;
            default: icon = ' ';
                break;
        }
        return icon;
    }

    @Override
    public ShipStatus shootAt() {
        ship.hit();
        return ship.getState();
    }
}
package com.yuva.oop.design.battleship;


public class WaterField implements IGameField {
    private boolean isThisFieldHit = false;

    @Override
    public char getIcon() {
        return isThisFieldHit ? 'M' : '~';
    }

    @Override
    public ShipStatus shootAt() {
        isThisFieldHit = true;
        return ShipStatus.NO_HIT;
    }
}
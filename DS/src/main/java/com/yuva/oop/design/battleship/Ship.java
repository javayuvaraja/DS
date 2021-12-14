package com.yuva.oop.design.battleship;

public class Ship {
    private final String name;
    private final int size;
    private int lives;

    public Ship(ShipType ship) {
        this.name = ship.getName();
        this.size = ship.getSize();
        this.lives = ship.getSize();
    }

    public void hit() {
        if(lives > 0) {
            System.out.printf("%nGood shot! The %s was hit", name);
            lives--;
        } else {
            System.out.println("Ship is destroyed");
        }
    }

    public ShipStatus getState() {
        if(lives == 0) {
            return ShipStatus.DESTROYED;
        } else if(lives < size) {
            return ShipStatus.PARTIAL_HIT;
        } else {
            return ShipStatus.NO_HIT;
        }
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
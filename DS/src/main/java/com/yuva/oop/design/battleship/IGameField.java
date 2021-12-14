package com.yuva.oop.design.battleship;


public interface IGameField {
    char getIcon();
    ShipStatus shootAt();
}
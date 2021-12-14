package com.yuva.oop.design.battleship;

public interface IPlayer {
	void placeShips();
    void fireAt(IPlayer opponent);
    int getTotalLivesLeft();
}

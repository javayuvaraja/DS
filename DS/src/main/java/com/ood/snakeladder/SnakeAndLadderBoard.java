package com.ood.snakeladder;

import java.util.HashMap;
import java.util.Map;

public class SnakeAndLadderBoard {
    private int size;
    private Map<Integer, Snake> snakesMap; // The board also contains some snakes and ladders.
    private Map<Integer, Ladder> laddersMap;
    private Map<String, Integer> playerPieces;

    public SnakeAndLadderBoard(int size) {
        this.size = size;
        this.snakesMap = new HashMap<Integer, Snake>();
        this.laddersMap = new HashMap<Integer, Ladder>();
        this.playerPieces = new HashMap<String, Integer>();
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, Snake> getSnakes() {
        return snakesMap;
    }

    public void setSnakes(Map<Integer, Snake> snakes) {
        this.snakesMap = snakes;
    }

    public Map<Integer, Ladder> getLadders() {
        return laddersMap;
    }

    public void setLadders(Map<Integer, Ladder> ladders) {
        this.laddersMap = ladders;
    }

    public Map<String, Integer> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(Map<String, Integer> playerPieces) {
        this.playerPieces = playerPieces;
    }
}

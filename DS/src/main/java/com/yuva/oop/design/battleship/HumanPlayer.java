package com.yuva.oop.design.battleship;

import java.awt.Point;
import java.util.Scanner;

public class HumanPlayer implements IPlayer {

	private int totalLivesLeft = 17;

	private int id;
	private Board board;
	private Scanner scanner;
	
	// Record list of misses
	// Record list of hits
	

	public HumanPlayer(int id) {
		this.id = id;
		this.board = new Board();
		this.scanner = new Scanner(System.in);
	}

	public int getId() {
		return id;
	}

	public Board getBoard() {
		return board;
	}

	@Override
	public void placeShips() {
		System.out.printf("%n======== Player %d - Time to place out your ships ========%n", id);
		board.placeShipsOnBoard();
	}

	@Override
	public void fireAt(IPlayer opponent) {
		System.out.printf("%n Alright Player %d - Enter coordinates for your attack: ", id);

		boolean isPointValid = false;
		while (!isPointValid) {
			try {
				Point point = new Point(scanner.nextInt(), scanner.nextInt());
				int x = (int) point.getX() - 1;
				int y = (int) point.getY() - 1;

				ShipStatus result = ((HumanPlayer) opponent).getBoard().getField(x, y).shootAt();

				if (result == ShipStatus.PARTIAL_HIT || result == ShipStatus.DESTROYED) {
					totalLivesLeft--;
				}

				isPointValid = true;
			} catch (IllegalArgumentException e) {
				System.out.printf(e.getMessage());
			}
		}
	}

	@Override
	public int getTotalLivesLeft() {
		return totalLivesLeft;
	}

}

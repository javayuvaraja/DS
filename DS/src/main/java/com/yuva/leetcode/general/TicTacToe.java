package com.yuva.leetcode.general;

public class TicTacToe {

	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antiDiagonal;

	public TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		// For player 1 add 1 , for player 2 add -1
		int toAdd = player == 1 ? 1 : -1;

		rows[row] += toAdd;
		cols[col] += toAdd;
		// for diagonal
		if (row == col) {
			diagonal += toAdd;
		}
		// for anti diagonal
		if (row+col == rows.length-1) {
			antiDiagonal += toAdd;
		}

		int size = rows.length;
		if (Math.abs(rows[row]) == size || 
			Math.abs(cols[col]) == size || 
			Math.abs(diagonal) == size || 
			Math.abs(antiDiagonal) == size) {
			return player;
		}

		return 0;
	}
}

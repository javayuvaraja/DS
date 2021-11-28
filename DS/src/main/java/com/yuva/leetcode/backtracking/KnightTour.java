package com.yuva.leetcode.backtracking;

public class KnightTour {

	
	private static int moveX[] = new int[] { -1, -1, 1, 1, -2, -2, 2, 2 };
	private static int moveY[] = new int[] { -2, 2, -2, 2, -1, 1, -1, 1 };
	/**
	 * Check cell (row, col) is not OutOfBoundary and value is not visited already
	 * @return
	 */
	public boolean isValid (int row, int col, int[][]board) {
		if (row >=0 && row < board.length &&
				col>=0 && col < board[0].length &&
				board[row][col]==-1) {
			return true;
		}
		return false;
	}
	
	public boolean backtrack(int [][]board, int row, int col, int moveCount, boolean [][]visited) {
		// 1) Base case: If all moves are done
		if (moveCount >= board.length * board.length) {
			return true;
		}
		
		//2) Breath: --> Consider all possible moves
		
		for (int i = 0; i < 8; i++) {
			int newX = row + moveX[i];
			int newY = col + moveY[i];
			// 3) Check if this move can be taken
			if (!visited[newX][newY] && isValid(newX, newY, board) ) {
				// 4) Take this move
				board[newX][newY] = moveCount;
				// 5) Check if this move leads to a solution from all recur moves
				if(backtrack(board, newX, newY, moveCount, visited)) {
					return true;
				}
				// 6) This move didn't work, Backtrack...
				board[newX][newY] =-1;
			}
		}
		return false; //  # No move from all 8 possible worked, so Backtrack previous move and re-try

	}
}

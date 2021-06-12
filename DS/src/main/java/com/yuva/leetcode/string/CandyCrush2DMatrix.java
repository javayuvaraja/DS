package com.yuva.leetcode.string;

public class CandyCrush2DMatrix {

	/*
	 * Logic : 
	 *  1. Each traversal of the matrix, we only check two directions, rightward and downward. 
	 *    No need to check upward and leftward because they would have been checked from previous cells.

		2. If there are at least three candies of the same type rightward or downward, set them all to its negative value to mark them.
		3. After each traversal, we need to remove all those negative values by setting them to 0, then let the rest drop down to their correct position.
	 */
	public int[][] candyCrush(int[][] board) {
        int rowLen = board.length, colLen = board[0].length;
        boolean found = true;
        while (found) {
            found = false;
            for (int currRow = 0; currRow < rowLen; currRow++) {
                for (int currCol = 0; currCol < colLen; currCol++) {
                    int val = Math.abs(board[currRow][currCol]);
                    if (val == 0) continue;
                    if (currCol < colLen - 2 && 
                    		Math.abs(board[currRow][currCol + 1]) == val && 
                    		Math.abs(board[currRow][currCol + 2]) == val) {  // horizontally
                        found = true;
                        int index = currCol;
                        while (index < colLen && 
                        		Math.abs(board[currRow][index]) == val) {
                        	board[currRow][index++] = -val; // Marking as negative
                        }
                    }
                    if (currRow < rowLen - 2 && 
                    		Math.abs(board[currRow + 1][currCol]) == val && 
                    		Math.abs(board[currRow + 2][currCol]) == val) {
                        found = true;
                        int index = currRow;
                        while (index < rowLen && Math.abs(board[index][currCol]) == val) {  // vertically
                        	board[index++][currCol] = -val;           
                        }
                    }
                }
            }
            
            if (found) { // move positive values to the bottom, then set the rest to 0
                for (int currCol = 0; currCol < colLen; currCol++) { // Each column traverse it from bottom
                    int storeInd = rowLen - 1;
                    for (int currRow = rowLen - 1; currRow >= 0; currRow--) { // from last row
                        if (board[currRow][currCol] > 0) {
                            board[storeInd--][currCol] = board[currRow][currCol];
                        }
                    }
                    for (int k = storeInd; k >= 0; k--) { // marking the remaining cells are zero
                    	board[k][currCol] = 0;
                    }
                }
            }
        }
        return board;
    }
	
}

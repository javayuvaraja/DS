package com.yuva.leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueen {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		
		char[][] board= new char[n][n];
		
		for (char []row: board) {
			Arrays.fill(row, '.');
		}
		
		dfs(board, 0, result);
		return result;
	}
	
	private void dfs (char[][] board, int row, List<List<String>> result) {
		if(row ==  board.length) {
			result.add(buildResult(board));
			return;
		}
		
		for (int currCol = 0 ; currCol <  board[0].length; currCol++) {
			board[row][currCol] = 'Q';
			if (isValid (board, row, currCol)) {
				dfs(board, row+1, result);
			}
			board[row][currCol] = '.';
		}
		return;
	}
	
	private boolean isValid (char[][] board, int row, int col) {
		for (int currRow= 0; currRow < board.length ; currRow++) {
			for (int currCol = 0; currCol < board[0].length ; currCol++) {
				if (board[currRow][currCol] == 'Q'  && 
						(currCol ==  col || Math.abs(row-currRow) == Math.abs(col-currCol))) {
					return false;
				}
			}
		}
		return true;
	}
	
	private List<String> buildResult(char[][] board) {
		List<String> currResult = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String temp = new String(board[i]);
            currResult.add(temp);
        }
        return currResult;
	}
}

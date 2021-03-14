package com.yuva.leetcode.dfsbfs;

public class WordSearch {

	int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }};

	public boolean exist(char[][] board, String word) {
		for (int i =0; i < board.length; i++) {
			for (int j=0; j < board[0].length; j++) {
				boolean visited[][] = new boolean[board.length][board[0].length];
				if (board[i][j]==word.charAt(0)) {
					if (dfs(board, i, j, 0, visited, word)) {
						return true;
					}
				}
				
			}
		}
		return false;
	}
	
	private boolean dfs (char[][]board, int currRow, int currCol, 
			int index, boolean visited[][], String word ) {
		index++;
		if (index==word.length()) {
			return true;
		}
		
		visited[currRow][currCol] = true;
		
		for (int i=0; i < directions.length; i++) {
			int newRow = currRow + directions[i][0];
			int newCol = currCol + directions[i][1];
			
			if (newRow >=0 && newRow < board.length &&
					newCol>=0 && newCol < board[0].length &&
					!visited[newRow][newCol] &&
					board[newRow][newCol] == word.charAt(index)) {
				 if(dfs(board, newRow, newCol, index, visited, word)) {
					 return true;
				 }
				 visited[newRow][newCol] = false; // for back tracking
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		/*char [][]board = new char[][]{{'A','B','C','E'},
			{'S','F','C','S'},{'A','D','E','E'}};*/
		char [][]board = {{'A','B','C','E'},
				          {'S','F','E','S'},
				          {'A','D','E','E'}};
		String word = "ABCESEEEFS";
		//String word = "ABCCED";
		WordSearch obj = new WordSearch();
		System.out.println(obj.exist(board, word));
	}
	
}

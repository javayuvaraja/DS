package com.yuva.leetcode.dfsbfs;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		int rowLen = grid.length;
		int colLen = grid[0].length;
		boolean[][] visited = new boolean[rowLen][colLen];
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					int area = dfs(grid, i, j, visited);
					maxArea = Math.max(maxArea, area);
				}
			}
		}

		return maxArea;
	}

	private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
		if (row < 0 || row >= grid.length 
				|| col < 0 	|| col >= grid[0].length 
				|| visited[row][col] || grid[row][col] != 1) {
			return 0;
		}
		visited[row][col] = true;

		return 1 + dfs(grid, row + 1, col, visited) + 
				   dfs(grid, row - 1, col, visited) + 
				   dfs(grid, row, col + 1, visited) + 
				   dfs(grid, row, col - 1, visited);
	}
}

package com.yuva.leetcode.dfsbfs;

public class NumberOfIslands {

	public static int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
	public int numIslands(char[][] grid) {
		int islandCount = 0;
		boolean [][]visited = new boolean [grid.length][grid[0].length];
		for (int i=0; i < grid.length; i++) {
			for (int j=0; j < grid[0].length; j++) {
				if (!visited[i][j] && grid[i][j]=='1') {
					dfs(grid, i, j, visited);
					islandCount++;
				}
			}
		}
		return islandCount;
    }
	
	private void dfs (char[][] grid, int currRow, int currCol, boolean [][]visited) {
		visited[currRow][currCol] = true;
		for (int i=0; i < directions.length; i++) {
			int newRow = currRow+ directions[i][0];
			int newCol = currCol + directions[i][1];
			
			if (newRow>=0 && newRow < grid.length &&
					newCol >=0 && newCol < grid[0].length &&
					!visited[newRow][newCol] && 
					grid[newRow][newCol] == '1') {
				dfs(grid, newRow, newCol, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		NumberOfIslands obj = new NumberOfIslands();
		char [][]grid = {
			  {'1','1','0','0','0'},
			  {'1','1','0','0','0'},
			  {'0','0','1','0','0'},
			  {'0','0','0','1','1'}
			};
		
		System.out.println(obj.numIslands(grid));
		
	}
}

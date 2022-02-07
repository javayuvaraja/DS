package com.yuva.leetcode.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
1730. Shortest Path to Get Food

You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.

 

Example 1:


Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
Output: 3
Explanation: It takes 3 steps to reach the food.
Example 2:


Input: grid = [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
Output: -1
Explanation: It is not possible to reach the food.
Example 3:


Input: grid = [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
Output: 6
Explanation: There can be multiple food cells. It only takes 6 steps to reach the bottom food.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ShortestPathTogetFood {

	int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

	public int getFood(char[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		Queue<int[]> q = new LinkedList<>();
		q.add(findStart(grid));

		boolean[][] visited = new boolean[m][n];

		int step=0;
		while(!q.isEmpty()){
			int len = q.size();
			for(int i=0; i < len; i++){
				int[] pos = q.poll();

				int x = pos[0];
				int y = pos[1];

				if(grid[x][y] == '#') return step;

				for(int[] dir: dirs){
					int newX = x + dir[0];
					int newY = y + dir[1];

					if(isValid(grid, newX, newY) && !visited[newX][newY]){
						visited[newX][newY] = true;
						q.offer(new int[]{newX, newY});
					}
				}
			}
			step++;
		}

		return -1;
	}

	private int[] findStart(char[][] grid){
		for(int i=0; i < grid.length; i++){
			for(int j=0; j < grid[0].length; j++){
				if(grid[i][j] == '*'){
					return new int[]{i, j};
				}
			}
		}
		throw new RuntimeException();
	}

	private boolean isValid(char[][] grid, int i, int j){
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 'X';
	}
}

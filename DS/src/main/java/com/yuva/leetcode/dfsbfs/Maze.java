package com.yuva.leetcode.dfsbfs;

/**
 * Leetcode 490
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.


Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false
Explanation: There is no way for the ball to stop at the destination.

 * @author Yuvaraja Kanagarajan
 *
 */
public class Maze {

	//{0,1} -> down, {0,-1}-> up, {1,0} -> right, {-1,0} -> left 
	static int []dirX = {0,0,1,-1};
	static int []dirY = {1,-1,0,0};

	public static void main(String[] args) {
		int [][]maze = new int[][]{
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0}
		};
		System.out.println(hasPath(maze, new int[] {0,4}, new int[] {4,4}));
		
	}
	
	public static boolean hasPath (int[][] maze, int []start, int []dest) {
		boolean visited[][] = new boolean [maze.length] [maze[0].length];
		return dfs(maze, start[0], start[1], dest, visited);
	}
	
	private static boolean dfs (int [][]maze, int currRow, int currCol, int dest[], boolean visited[][]) {
		//checking reached the destination
		if (currRow == dest[0] && currCol == dest[1]) {
			return true;
		}
		// checking whether already visited
		if (visited[currRow][currCol] == true) {
			return false;
		}
		visited[currRow][currCol] = true;
		
		for (int i=0; i < dirX.length; i++) {
			int newRow = currRow;
			int newCol = currCol;
			
			while (newRow>=0 && newRow < maze.length && // for row boundary case
					newCol>=0 && newCol < maze[0].length && // for column boundary case
					maze[newRow][newCol]== 0 ) { // for checking wall 
				newRow = newRow + dirX[i];
				newCol = newCol + dirY[i];
			}
			// it hit the wall, so decrease to prev position
			newRow = newRow - dirX[i];
			newCol = newCol - dirY[i];
			if (dfs(maze, newRow, newCol, dest, visited)) {
				return true;
			}
			
		}
		return false;
	}
}

package com.yuva.leetcode.dp;
/**
 * Facebook Question
 *
LeetCode :329 Longest Increasing Path in a Matrix

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. 
You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestIncreasingPathInMatrix {

	public static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	/*
	 * Logic :
	 * 	1. Do DFS from every cell
		2. Compare every 4 direction and skip cells that are out of boundary or smaller
		3. Get matrix max from every cell's max
		4. Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
		5. The key is to cache the distance because it's highly possible to revisit a cell
	 */
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int rowLen = matrix.length, colLen = matrix[0].length;
		int[][] dp = new int[rowLen][colLen];
		int max = 1;
		for (int row = 0; row < rowLen; row++) {
			for (int col = 0; col < colLen; col++) {
				int len = dfs(matrix, row, col, rowLen, colLen, dp);
				max = Math.max(max, len);
			}
		}
		return max;
	}

	public int dfs(int[][] matrix, int currRow, int currCol, int rowLen, int colLen, int[][] dp) {
		if (dp[currRow][currCol] != 0) { // already calculated
			return dp[currRow][currCol];
		}
		int max = 1;
		for (int[] dir : dirs) {
			int newRow = currRow + dir[0];
			int newCol = currCol + dir[1];
			if (newRow < 0 || newRow >= rowLen || 
				newCol < 0 || newCol >= colLen || 
				matrix[newRow][newCol] <= matrix[currRow][currCol]) // comparing greater than the current
				continue;
			int len = 1 + dfs(matrix, newRow, newCol, rowLen, colLen, dp);
			max = Math.max(max, len);
		}
		dp[currRow][currCol] = max;
		return max;
	}
}

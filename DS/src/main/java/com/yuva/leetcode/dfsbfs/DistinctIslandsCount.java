package com.yuva.leetcode.dfsbfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 
694. Number of Distinct Islands

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be 
translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.

Example 1:
Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1

Example 2:
Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
Output: 3
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class DistinctIslandsCount {

	public int numDistinctIslands(int[][] grid) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != 0) {
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, sb, "o"); // origin
					grid[i][j] = 0;
					set.add(sb.toString()); // adding the path to the set
				}
			}
		}
		return set.size();
	}

	private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0)
			return;
		sb.append(dir);
		grid[i][j] = 0;
		dfs(grid, i - 1, j, sb, "u"); // upper
		dfs(grid, i + 1, j, sb, "d"); // down
		dfs(grid, i, j - 1, sb, "l"); // left 
		dfs(grid, i, j + 1, sb, "r"); // right
		sb.append("b"); // back
	}
}

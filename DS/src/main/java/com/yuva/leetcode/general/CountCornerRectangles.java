package com.yuva.leetcode.general;

/**
 * 750. Number Of Corner Rectangles

Given an m x n integer matrix grid where each entry is only 0 or 1, return the number of corner rectangles.

A corner rectangle is four distinct 1's on the grid that forms an axis-aligned rectangle. 
Note that only the corners need to have the value 1. Also, all four 1's used must be distinct.

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class CountCornerRectangles {

	public int countCornerRectangles(int[][] grid) {
		int ans = 0;
		for (int i = 0; i < grid.length - 1; i++) {
			for (int j = i + 1; j < grid.length; j++) {
				int counter = 0;
				for (int k = 0; k < grid[0].length; k++) {
					if (grid[i][k] == 1 && grid[j][k] == 1)
						counter++;
				}
				if (counter > 0)
					ans += counter * (counter - 1) / 2;
			}
		}
		return ans;
	}
}

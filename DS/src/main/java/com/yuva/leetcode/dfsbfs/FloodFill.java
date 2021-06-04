package com.yuva.leetcode.dfsbfs;

public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (sr > image.length - 1 || sc > image[0].length - 1) {
			return image;
		}
		int oldColor = image[sr][sc];
		if (oldColor == newColor) {
			return image;
		}
		fillColor(image, sr, sc, oldColor, newColor);
		return image;
	}

	private void fillColor(int[][] image, int row, int col, int oldColor, int newColor) {
		if (row < 0 || row > image.length - 1 || 
			col < 0 || col > image[0].length - 1 || 
			image[row][col] != oldColor) {
			return;
		} else {
			image[row][col] = newColor;
		}
		
		fillColor(image, row + 1, col, oldColor, newColor);
		fillColor(image, row - 1, col, oldColor, newColor);
		fillColor(image, row, col + 1, oldColor, newColor);
		fillColor(image, row, col - 1, oldColor, newColor);

	}
}

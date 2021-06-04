package com.yuva.leetcode.dp;

/**
Leetcode 63. Unique Paths II

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. 
How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 * @author Yuvaraja Kanagarajan
 *
 */
public class UniquePathWithObstacles {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowCount = obstacleGrid.length;
        int colCount = obstacleGrid[0].length;
        int result[][] = new int[rowCount][colCount];
        if (obstacleGrid[0][0]!=1) {
            result[0][0] = 1;    
        }        
        for (int i=1; i < colCount ; i++) {
            if (obstacleGrid[0][i]!=1) {
                result[0][i] =result[0][i-1];
            }
        }
        for (int i=1; i < rowCount ; i++) {
            if (obstacleGrid[i][0]!=1) {
                result[i][0] =result[i-1][0];
            }
        }
        
        for (int i=1; i < rowCount; i++) {
            for (int j=1; j < colCount; j++) {
                if (obstacleGrid[i][j]!=1) {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
        return result[rowCount-1][colCount-1];
    }
}

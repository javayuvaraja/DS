package com.yuva.leetcode.dp;

/**
 *  https://leetcode.com/problems/unique-paths/
 *  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid 
	(marked 'Finish' in the diagram below).

	How many possible unique paths are there?
 * @author Yuvaraja Kanagarajan
 *
 */
public class UniquePath {

	public int uniquePaths(int rowLen, int colLen) {
        if (rowLen==0 || colLen==0) {
            return 0;
        }
        int result[][]= new int[rowLen][colLen];
        for (int row=0; row < rowLen; row++) {
            for (int col=0; col < colLen; col++){
                if (row==0 || col==0) {
                    result[row][col]=1;
                    continue;
                }
                result[row][col] = result[row-1][col] + result[row][col-1];
            }
        }
        return result[rowLen-1][colLen-1];
    }
}

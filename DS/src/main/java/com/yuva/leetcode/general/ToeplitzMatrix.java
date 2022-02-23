package com.yuva.leetcode.general;

/**
766. Toeplitz Matrix

Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

 

Example 1:


Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:


Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ToeplitzMatrix {

	public boolean isToeplitzMatrix(int[][] matrix) {
        for (int row=1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row-1][col-1]!=matrix[row][col]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

package com.yuva.leetcode.general;

import java.util.List;

/**
 A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, 
 this row is sorted in non-decreasing order.
 
 Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. 
 If such index doesn't exist, return -1.
   
  Constraints :
  ---------------
   	You can’t access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
	1. BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
	2. BinaryMatrix.dimensions() returns a list of 2 elements [m, n], which means the matrix is m * n.
	
 * @author Yuvaraja Kanagarajan
 *
 */
public class LeftMostColumnAtleastOne {

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimension = binaryMatrix.dimensions();
		int rowLen = dimension.get(0);
		int colLen = dimension.get(1);

		int row = 0, col = colLen - 1, leftMostCol = -1;

		while (row < rowLen && col >= 0) {
			int result = binaryMatrix.get(row, col);
			// if current cell is 0 then move to the next row.
			if (result == 0) {
				row++;
			} else {  // move to the left
				leftMostCol = col;
				col--;
			}
		}
		return leftMostCol;
	}
	
	/**
	 * Solution 2 : Using binary search.
	 * Get the index 
	 * @param binaryMatrix
	 * @return
	 */
	
	public int leftMostColumnWithOne2(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rowLen = dim.get(0);
        int colLen = dim.get(1);
        int leftMost = colLen;
        
        for (int i = 0; i < rowLen; i++) {
            int left = 0;
            int right = leftMost; 
            while (left < right) {
                int mid = left + (right - left)/2;
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid;
                }
                else {
                    left = mid+1;
                }
            }
            leftMost = left;
        }
        
        return leftMost == colLen ? -1 : leftMost;
    }
}

interface BinaryMatrix {
	public int get(int row, int col);

	public List<Integer> dimensions();
};
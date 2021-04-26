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
	
	public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rowLen = dimension.get(0);
        int colLen = dimension.get(1);
        int min = Integer.MAX_VALUE;
        for (int row = 0; row < rowLen; row++) {
            min = Math.min(min, 
            		binarySearch(binaryMatrix, row, Math.min(colLen, min)));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
	
    private int binarySearch(BinaryMatrix matrix, int row, int col) {
        if (matrix.get(row, col - 1) == 0) return Integer.MAX_VALUE;
        if (matrix.get(row, 0) == 1) return 0;
        int lo = 0;
        int hi = col - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix.get(row, mid) == 1) {
              hi = mid - 1;
            } else {
              lo = mid + 1;
            }
        }
        return lo;
    }
}

interface BinaryMatrix {
	public int get(int row, int col);

	public List<Integer> dimensions();
};
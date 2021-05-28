package com.yuva.leetcode.array;

/**
 * Facebook interview Question
 * 
  Array of non-negative integers numbers and you can choose any number from this array 
  and swap any two digits in it. 
  When swapping you can also ignore leading zeros after the swap (e.g. 20 becomes 02 = 2). 
  Check whether we can swap at most once so that the elements of the resulting array are strictly increasing.
  For example, [5, 30, 40, 50] should return true, since no swaps are necessary. [5, 8000, 20, 30] should return true, 
  since we can swap 8000 to get 8, and then the final array will be strictly increasing [5, 8, 20, 30].
  
 * @author Yuvaraja Kanagarajan
 *
 */
public class CanSwapForMakingSorted {

	public boolean canSwap(int[] arr) {
        if (arr.length < 2) return true;

        int prev = arr[0];
        int outOfOrder = -1;
        // Checking the out of order index, 
        // If it is more than one out of order index return false;
       
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < prev) {
                if (outOfOrder > -1) {  // already out of order element is there
                	return false;
                }
                outOfOrder = i;
            }
            prev = arr[i];
        }

        if (outOfOrder == -1) { // no changes are required
        	return true;
        }
        // Check whether current or prev index can be reorder and make the array is sorted.
        return checkCanModifyNumber(arr, outOfOrder - 1)
                || checkCanModifyNumber(arr, outOfOrder);
    }


    private boolean checkCanModifyNumber(int[] arr, int idx) {
        int prev = idx > 0 ? arr[idx - 1] : -1;
        char[] currNumArr = ("" + arr[idx]).toCharArray();
        int next = idx < arr.length - 1 ? arr[idx + 1] : Integer.MAX_VALUE;

        // Making all the combination for checking whether the number can be 
        //greater than the previous and lesser than the next
        for (int i = 0; i < currNumArr.length - 1; i++) {
            for (int j = i + 1; j < currNumArr.length; j++) {
                swap(currNumArr, i, j);
                int val = Integer.parseInt(new String(currNumArr));
                if (val >= prev && val <= next) return true;
                swap(currNumArr, i, j);
            }
        }
        return false;
    }

    private void swap(char[] arr, int src, int trg) {
        char tmp = arr[src];
        arr[src] = arr[trg];
        arr[trg] = tmp;
    }
}

package com.yuva.leetcode.general;

/**
 * 1151. Minimum Swaps to Group All 1's Together

Given a binary array data, return the minimum number of swaps required to group 
all 1’s present in the array together in any place in the array.

Example 1:
Input: data = [1,0,1,0,1]
Output: 1
Explanation: There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.

Example 2:
Input: data = [0,0,0,1,0]
Output: 0
Explanation: Since there is only one 1 in the array, no swaps are needed.

Example 3:
Input: data = [1,0,1,0,1,0,0,1,1,0,1]
Output: 3
Explanation: One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].

 * @author Yuvaraja Kanagarajan
 *
 */
public class MinSwapGroup1Together {

	public int minSwaps(int[] arr) {
        int onesCount = 0;
        for (int i : arr) {
            if (i == 1) {
            	onesCount++;
            }
        }

        int start = 0;
        int end = 0;
        int maxOneCnt = 0;
        int currOneCnt = 0;

        while (end < arr.length) {
            if (end - start < onesCount) {  // checking the window is less than the total one's count
                if (arr[end] == 1) {
                    currOneCnt++;
                    maxOneCnt = Math.max(maxOneCnt, currOneCnt);
                }
                end++;
            } else {
                if (arr[start] == 1) {
                    currOneCnt--;
                }
                start++;
            }
        }

        return onesCount - maxOneCnt;
    }
}

package com.yuva.leetcode.stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * LeetCode 503. Next Greater Element II
 * Given a circular array (the next element of the last element is the first element of the array),
 *  print the Next Greater Number for every element. The Next Greater Number of a 
 *  number x is the first greater number to its traversing-order next in the array, 
 *  which means you could search circularly to find its next greater number. 
 *  If it doesn't exist, output -1 for this number.
 * 
 *  Ex : Input: [1,2,1]
	Output: [2,-1,2]
	Explanation: The first 1's next greater number is 2; 
	The number 2 can't find next greater number; 
	The second 1's next greater number needs to search circularly, which is also 2.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindNextGreaterElementII {

	public int[] nextGreaterElements(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int currIndex = (i + 1) % nums.length;
			boolean isNextFound = false;
			while (i != currIndex) {
				if (nums[i] < nums[currIndex]) {
					result[i] = nums[currIndex];
					isNextFound = true;
					break;
				}
				currIndex = (currIndex + 1) % nums.length;
			}

			if (!isNextFound) {
				result[i] = -1;
			}
		}
		return result;
	}

}

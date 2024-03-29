package com.yuva.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.

Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
If it does not exist, return -1 for this number.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation:
For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
For number 1 in the first array, the next greater number for it in the second array is 3.
For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 
 * Suppose we have a decreasing sequence followed by a greater number
   For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all 
   previous numbers in the sequence

   We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than 
   stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
   
   For example [9, 8, 7, 3, 2, 1, 6]
   The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 
   so we pop 1 2 3 whose next greater element should be 6
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindNextGreaterElementI {

	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
		Stack<Integer> stack = new Stack<>();
		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num)
				map.put(stack.pop(), num);
			stack.push(num);
		}
		for (int i = 0; i < findNums.length; i++)
			findNums[i] = map.getOrDefault(findNums[i], -1);
		return findNums;
	}
}

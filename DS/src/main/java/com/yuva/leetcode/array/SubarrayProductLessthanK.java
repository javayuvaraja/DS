package com.yuva.leetcode.array;

/**
 * 713. Subarray Product Less Than K

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements 
in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8

Explanation: The 8 subarrays that have product less than 100 are: 
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].

Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

 * @author Yuvaraja Kanagarajan
 *
 */
public class SubarrayProductLessthanK {

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int startIndex = 0;
        int product = 1;
        for (int endIndex = 0; endIndex < nums.length; endIndex++) {
            product = product * nums[endIndex];
            
            while (startIndex <=endIndex && 
                  product >=k) {
                product = product / nums[startIndex];
                startIndex++;
            }
            
            result = result + (endIndex - startIndex +1 );
        }
        return result;
    }
	
	
	/**
	 * Input: nums = [10, 5, 2, 6], k = 100
		Output: 8
		Explanation: The 8 subarrays that have product less than 100 are: 
		[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
		Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {10, 5, 2, 6};
		System.out.println(numSubarrayProductLessThanK(arr, 100));
	}
}

package com.yuva.leetcode.array;

public class SquaresOfSortedArray {

	public int[] sortedSquares(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		int result[] = new int[nums.length];
		int resIndex  = nums.length-1;
		while (start <= end ) {
			if (Math.abs(nums[start]) > Math.abs(nums[end])) {
				result[resIndex--] = nums[start]* nums[start];
				start++;
			} else {
				result[resIndex--] = nums[end]* nums[end];
				end--;
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		//int nums[] = {-7,-3,2,3,11};
		int nums[] = {-5,-3,-2,-1};
		SquaresOfSortedArray obj = new SquaresOfSortedArray();
		int result [] = obj.sortedSquares(nums);
		for (int num : result) {
			System.out.print(num + " " );
		}
	}
}

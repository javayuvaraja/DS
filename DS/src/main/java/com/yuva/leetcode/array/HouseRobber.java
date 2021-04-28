package com.yuva.leetcode.array;

/**
 * 
 * 198. House Robber

You are a professional robber planning to rob houses along a street. 

Each house has a certain amount of money stashed, the only constraint
 stopping you from robbing each of them is that adjacent houses have security 
 systems connected and it will automatically contact the police if two adjacent
 houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class HouseRobber {

	public int rob(int[] nums) {

		int incl = nums[0];
		int excl = 0;

		for (int i = 1; i < nums.length; i++) {
			int temp = incl;
			incl = Math.max(incl, excl + nums[i]);
			excl = Math.max(excl, temp);
		}
		return Math.max(incl, excl);
	}
	
	public int robDP(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int result[] = new int[nums.length];
		result[0] = nums[0];
		result[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			result[i] = Math.max(result[i - 1], result[i - 2] + nums[i]);
		}
		return result[nums.length - 1];
	}
	
	public static void main(String[] args) {
		int arr[] = {2,7,9,3,1};
		HouseRobber obj = new HouseRobber();
		System.out.println(obj.robDP(arr));
		
	}
}

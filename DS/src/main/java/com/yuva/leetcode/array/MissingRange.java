  package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 163
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
	Example:
	Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
	Output: ["2", "4->49", "51->74", "76->99"]
 * 
 * @author Yuvaraja Kanagarajan
 * 
 *
 */
public class MissingRange {

	public List<String> findMissingRanges(int[] nums, int low, int high) {
		List<String> result = new ArrayList<>();
		
		if (nums.length==0) {
			addRange(result, low-1, high+1);
		}
		
		addRange(result, low-1, nums[0]);
		
		for(int i=1; i < nums.length; i++) {
			addRange(result, nums[i-1], Math.min(nums[i], high+1)); // Math.min for till the higher
		}
		
		addRange(result, nums[nums.length-1], high+1);
		
		return result;
	}
	
	private void addRange(List<String> result, int low, int high) {
		if (low > high || low == high || low+1== high) { // for same and consecutive, lower is greater than the higher
			return;
		} else if (low+1 == high-1) { // single element missing
			result.add(String.valueOf(low+1));
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(String.valueOf(low+1));
			sb.append("->");
			sb.append(String.valueOf(high-1));
			result.add(sb.toString());
		}
	}
	
	public static void main(String[] args) {
		MissingRange obj = new MissingRange();
 		int nums[] = {10, 11, 13, 50, 75};
		System.out.println(obj.findMissingRanges(nums, 0, 65));
	}
}

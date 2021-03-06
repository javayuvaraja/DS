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
public class MissingRangeII {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		int len = nums.length;
		if (len==0) {
			addRange(result, lower-1, upper+1);
			return result;
		}
		
		addRange(result, lower-1, nums[0]);
		
		for (int i=1; i < len; i++) {
			addRange(result, nums[i-1], nums[i]);
		}
		addRange(result, nums[len-1], upper+1);
		
		return result;
	}
	
	private void addRange(List<String> result, int low, int high) {
		
		if (low == high) {  // no boundary
			return;
		} else if (low+1 == high){ // {0,1} 
			return;
		} else if (low+1 == high-1) { //{1, 3}  missing only one element
			result.add(String.valueOf(low+1));
		} else {  // missing many (range)
			String range = String.format("%d->%d", low+1,high-1);
			result.add(range);
		}				
	}
	
	public static void main(String[] args) {
		MissingRangeII obj = new MissingRangeII();
		int nums[] = {0, 1, 3, 50, 75};
		System.out.println(obj.findMissingRanges(nums, 0, 90));
	}
}

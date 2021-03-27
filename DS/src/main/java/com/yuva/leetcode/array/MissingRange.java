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

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		
		if (lower==Integer.MAX_VALUE) {
			return result;
		}		
		int expecting = lower;
		for (int i=0; i < nums.length; i++) {
			// not in the boundary
			if (expecting > nums[i]) {
				continue;
			}
			// if the current element is in consecutive order then continue
			if (expecting == nums[i]) {
				expecting++;
				continue;
			}
			// add the range
			result.add(createRange(expecting, nums[i]-1));
			
			if(nums[i]==upper) {
				break;
			}
			expecting = nums[i]+1;			
		}
		
		if(expecting < upper) {
			result.add(createRange(expecting, upper));
		}
		
		return result;
	}
	
	private String createRange(int start, int end) {
		return start==end ? String.valueOf(start) : start+"->"+end;
	}
	
	public static void main(String[] args) {
		MissingRange obj = new MissingRange();
		int nums[] = {0, 1, 3, 50, 75};
		System.out.println(obj.findMissingRanges(nums, 0, 90));
	}
}

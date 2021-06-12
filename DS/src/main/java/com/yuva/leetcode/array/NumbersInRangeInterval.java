package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given some numbers [3,5,7,8,10], and interval list : [1,6,15] , 
 * they wanted to know how many numbers occur between each interval . 
 * The answer for this example will be : [2,3] i.e [1,6] -> [3,5] and [6,15] -> [7,8,10].
 * @author Yuvaraja Kanagarajan
 *
 */
public class NumbersInRangeInterval {

	public static List<Integer> solution(int[] nums, int[] intervals) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1, j = 0; i < intervals.length; ++i) {
			int counter = 0;
			while (j < nums.length && nums[j] <= intervals[i]) {
				if (intervals[i - 1] <= nums[j]) {
					counter++;
				}
				j++;
			}
			if (counter > 0) {
				res.add(counter);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int nums[]= {3,5,7,8,10};
		int interval[] = {1,6,15};
		
		System.out.println(solution(nums, interval));
	}
}

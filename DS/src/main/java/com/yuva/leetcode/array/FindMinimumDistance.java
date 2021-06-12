package com.yuva.leetcode.array;
/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindMinimumDistance {
	public int getMinDistance(int[] nums, int target, int start) {
        int res = nums.length+1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target) {
                res = Math.min(res, Math.abs(start - i));
            }
        }
        return res;
    }
}

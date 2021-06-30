package com.yuva.leetcode.array;

import java.util.HashSet;

public class SplitArrayFourParts {

	/**
	 * 1. Divide the array into 4 equal parts. 
	  	  So we need at least 4 *2 -1 = 7 elements
	 	Divide the array into 4 parts
	 	check two quarters are same, then add to the set
	 	// check first half and check two quarter are same, if same add the sum to set
	 	// check the next half
	 	 
	 	Logic :  sum[0 to i-1] == sum [j-1 to i] add to set
	 	 		
	 */
	public boolean splitArray(int[] nums) {
        if (nums.length < 7)  // dont add this condition at the beginning
            return false;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int j = 3; j < nums.length - 3; j++) {
            HashSet < Integer > set = new HashSet < > ();
            for (int i = 1; i < j - 1; i++) {  // from 0 to i-1
                if (sum[i - 1] == sum[j - 1] - sum[i]) // checking 0 to i-1 == i to j-1 , basically two quarts
                    set.add(sum[i - 1]);
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] 
                		&& set.contains(sum[k - 1] - sum[j]))
                    return true;
            }
        }
        return false;
    }
}

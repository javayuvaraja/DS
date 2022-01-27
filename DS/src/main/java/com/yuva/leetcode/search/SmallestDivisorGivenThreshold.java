package com.yuva.leetcode.search;

public class SmallestDivisorGivenThreshold {

	public int smallestDivisor(int[] A, int threshold) {
        int left = 1, right = (int)1e6;
        while (left < right) {
            int m = (left + right) / 2; 
            int sum = 0;
            for (int i : A)
                sum += (i + m - 1) / m;
            if (sum > threshold)
                left = m + 1;
            else
                right = m;
        }
        return left;
    }
	
	 public int smallestDivisor1(int[] nums, int threshold) {
	        long sum = 0;
	        int low = 1, high = 1;
	        for (int num : nums) {
	            sum += num;
	            high = Math.max(high, num);
	        }
	        if (sum <= threshold) {
	        	return 1;
	        }
	        while (low < high) {
	            int divisor = low + (high-low)/2;
	            sum = 0;
	            for (int i = 0; i < nums.length && sum <= threshold; i++) {
	                sum += (int)Math.ceil((double)nums[i]/divisor);
	            }
	            if (sum > threshold) {
	            	low = divisor+1;
	            } else {
	            	high = divisor;
	            }
	        }
	        return low;
	    }
}

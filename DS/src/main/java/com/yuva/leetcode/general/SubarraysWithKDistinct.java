package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.Map;

/**
992. Subarrays with K Different Integers
Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of 
A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
Example 2:

Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].


Return the number of good subarrays of A
 * @author Yuvaraja Kanagarajan
 *
 */
public class SubarraysWithKDistinct {
	
	/**
	 	Logic : Find atmost K subarrays and Atmost k-1 subarray. 
	 	The difference will eliminate the less than K.
	 	So we will get exactly K items subarray
	 	
	 	Ex : {1,2,1,2,3} at most K=2
	 	      {1}, {1,2}, {1,2,1}, {1,2,1,2} , {2,3}  
	   SubArr: 1  +  2 + 3 + 4 + 2  = 12
	       at most K=1
	           {1}, {2}, {1}, {2}, {3}
	           1 +1 +1 +1 +1  = 5
	           
	   Formula = atmost(K) - atmost(k-1)
	           = 12 - 5 = 7
	 */
	public int subarraysWithKDistinct(int[] A, int K) {
		return atMostK(A, K) - atMostK(A, K - 1);
	}

	/*
	 * No .of Continous Subarrays 
	 * end -start+1
	 * 
	 * if length 1 =1 {1}
	 * length 2  =2   {1,2} , {2}
	 * length 3 = 3 {1,2,3}, {2,3}, {3}
	 */
	public int atMostK(int[] A, int K) {
		int start = 0, res = 0;
		Map<Integer, Integer> count = new HashMap<>();
		for (int end = 0; end < A.length; ++end) {
			if (count.getOrDefault(A[end], 0) == 0)
				K--;
			count.put(A[end], count.getOrDefault(A[end], 0) + 1);
			while (K < 0) {
				count.put(A[start], count.get(A[start]) - 1);
				if (count.get(A[start]) == 0)
					K++;
				start++;
			}
			res += end - start + 1;  // no. of continous sub arrays
		}
		return res;
	}
	public static void main(String[] args) {
		int arr[]= {1,2,1,2,3};
		int k=2;
		SubarraysWithKDistinct obj =  new SubarraysWithKDistinct();
		System.out.println(obj.subarraysWithKDistinct(arr, k));
		
	}
}


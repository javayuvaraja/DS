package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] of size N, the task is to count the number of subarrays from the given array, 
 * such that each distinct element in these subarray occurs at least twice.

Examples:

Input: arr[] = {1, 1, 2, 2, 2}
Output: 6
Explanation: Subarrays having each element occuring at least twice are :
{{1, 1}, {1, 1, 2, 2}, {1, 1, 2, 2, 2}, {2, 2}, {2, 2, 2}, {2, 2}}.

Therefore, the required output is 6.

Input: arr[] = {1, 2, 1, 2, 3}
Output: 1
 * @author Yuvaraja Kanagarajan
 *
 */
public class CountSubArrayWithAtleastTwo {

	/**
	 *  Logic : increase the unique count when first time, decrease the unique count same is occuring the second time
	 *   if unique count == 0 , then increase the subarray count 
	 */
	static int countSubarrays(int arr[]) {
		int subArrayCount = 0;
		int uniqueCount = 0;
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		for (int i=0; i < arr.length; i++) {
			for (int j=i; j < arr.length; j++) {
				freqMap.put(arr[j], freqMap.getOrDefault(arr[j], 0)+1);
				
				if (freqMap.get(arr[j])==1) { // one time occured
					uniqueCount++; 
				} else if (freqMap.get(arr[j])==2) { // second time occured
					uniqueCount--;
				}
				
				if (uniqueCount==0) {
					subArrayCount++;
				}
			}
			freqMap.clear();
			uniqueCount = 0;
		}
		
		return subArrayCount;
	}
	
	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 2 };
	     
	    System.out.println(countSubarrays(arr));
	}
}

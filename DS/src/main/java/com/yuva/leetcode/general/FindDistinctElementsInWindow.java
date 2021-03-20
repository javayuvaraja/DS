package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Print distinct elements in the window
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindDistinctElementsInWindow {

	public static void printDistinctElementsCount(int arr[], int k) {
		Map <Integer, Integer> countMap = new HashMap<>();
		for (int i= 0; i < k ; i++ ) {
			countMap.put(arr[i], countMap.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(countMap.size());
		
		for (int start= 0; start+k < arr.length ; start++ ) {
			// remove element from the start
			int endIndex = start+k;
			int lastIndex = endIndex-k;
			countMap.put(arr[lastIndex], countMap.get(arr[lastIndex])-1);
			if(countMap.get(arr[lastIndex])==0) {
				countMap.remove(arr[lastIndex]);
			}
			countMap.put(arr[endIndex], countMap.getOrDefault(arr[endIndex], 0)+1);
			System.out.print(countMap.size()+ " ");
		}		
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 1, 3, 4, 2, 3};
	    int   k = 4;
	    printDistinctElementsCount(arr, k);
	    		//Output: 3 4 4 3
	    		
	}
}

package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Print uncommon elements from two sorted arrays

   Given two sorted arrays of distinct elements, we need to print 
   those elements from both arrays that are not common. 
   The output should be printed in sorted order.
    
 * @author Yuvaraja Kanagarajan
 *
 */
public class PrintUncommonItems {

	static List<Integer> printUncommon(int arr1[], int arr2[]) {

		List<Integer> result = new ArrayList<Integer>();
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			
			if (arr1[i] == arr2[j]) {
				i++;
				j++;
				continue;
			}
			// If not common, print smaller
			if (arr1[i] < arr2[j]) {
				result.add(arr1[i++]);
			} else {
				result.add(arr2[j++]);
			} 
		}

		// printing remaining elements
		while (i < arr1.length) {
			result.add(arr1[i++]);
		}
		while (j < arr2.length) {
			result.add(arr2[j++]);
		}
		
		return result;
	}

	// Driver code
	public static void main(String[] args) {
		int arr1[] = { 10, 20, 30 };
		int arr2[] = { 20, 25, 30, 40, 50 };

		List<Integer> result = printUncommon(arr1, arr2);
		result.stream().forEach(e-> System.out.print(e + " "));
	}
}

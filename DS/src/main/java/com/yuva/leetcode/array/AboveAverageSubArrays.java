package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 Facebook interview question

You are given an array A containing N integers. Your task is to find all subarrays whose average sum is greater 
than the average sum of the remaining array elements
         -------------------------------------------
. You must return the start and end index of each subarray in sorted order.
A subarray that starts at position L1 and ends at position R1 comes before a subarray that starts at L2 and ends at R2 
if L1 < L2, or if L1 = L2 and R1 ≤ R2.
Note that we'll define the average sum of an empty array to be 0, and we'll define the indicies of the array 
(for the purpose of output) to be 1 through N. A subarray that contains a single element will have L1 = R1.
Signature
Subarray[] aboveAverageSubarrays(int[] A)
Input
1 ≤ N ≤ 2,000
1 ≤ A[i] ≤ 1,000,000
Output
A Subarray is an object with two integer fields, left and right, defining the range that a given subarray covers. 
Return a list of all above-average subarrays sorted as explained above.
Example 1
A = [3, 4, 2]
output = [[1, 2], [1, 3], [2, 2]]
The above-average subarrays are [3, 4], [3, 4, 2], and [4].
 * @author Yuvaraja Kanagarajan
 *
 */
public class AboveAverageSubArrays {

	class Pair {
		int start;
		int end;
		 Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	
	public List<Pair> aboveAvgSubArray(int[] arr) {
		int totalSum = 0;
		for (int num : arr) {
			totalSum += num;			
		}
		
		List<Pair> result = new ArrayList<>();
		for (int start=0; start < arr.length; start++) {
			int currSum = 0;
			for (int end=start; end < arr.length; end++) {
				currSum = currSum+ arr[end];
				
				int winLength = end-start+1;
				int remainLength = arr.length - winLength;
				remainLength = remainLength==0 ? arr.length : remainLength;
				double currAvg = (currSum) / winLength;
				double remainAvg = (totalSum- currSum) / (remainLength); 
				if (currAvg > remainAvg) {
					result.add(new Pair(start+1, end+1));
				}		
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		AboveAverageSubArrays obj = new AboveAverageSubArrays();
		int arr[] = {3,4,2};
		List<Pair> result = obj.aboveAvgSubArray(arr);
		
		for (Pair pair : result) {
			System.out.print("["+pair.start + "," + pair.end + "]");
		}
	}
	
}

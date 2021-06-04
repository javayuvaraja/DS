package com.yuva.leetcode.array;

public class SplitArrayLargestSum {

	public int splitArray(int arr[], int m) {
		int max = 0;
		int sum =0;
		for (int temp : arr) {
			max = Math.max(temp, max);
			sum += temp;
		}
		
		int low =max;
		int high = sum;
		
		while (low < high) {
			int mid = (low+high)/2;
			int splitCount = split (arr, mid);
			if (splitCount > m) {
				low = mid+1;
			} else {
				high = mid;
			}
		}
		
		return low;
	}
	
	private int split(int arr[], int maxSum) {
		int count = 1;
		int currSum = 0;
		for (int num : arr)  {
			if (currSum + num > maxSum) {
				currSum = num;
				count++;
			} else {
				currSum += num;
			}	
		}
		
		return count;
			
	}
}

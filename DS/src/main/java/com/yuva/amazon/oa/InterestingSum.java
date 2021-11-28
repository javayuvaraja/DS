package com.yuva.amazon.oa;

public class InterestingSum {

	public static void main(String[] args) {
		//int arr[] = {-4, -10, 3, 5};
		int arr[] = {-1, 2, -1, 4, 7};
		System.out.println(findInterestingSum(arr));
	}
	public static int findInterestingSum(int arr[]) {
		
		int max = Integer.MIN_VALUE;
		for (int i =0; i < arr.length; i++) {
			int currMax = arr[i];
			int sign = -1;
			int sum = arr[i];
			for (int j=i+1; j < arr.length; j++) {
				sum  = sum + (sign * arr[j]);
				if (sum > currMax) {
					currMax = sum;
				}
				sign = sign *-1;
			}
			
			if (currMax > max) {
				max = currMax;
			}
		}
		
		return max;
	}
	
	
}

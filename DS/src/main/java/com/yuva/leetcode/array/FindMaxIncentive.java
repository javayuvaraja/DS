package com.yuva.leetcode.array;

/**
 * Uber question

We want to give incentives to driver. So we need to devise a mechanism to calculate these incentives.

On the end of every trip, an Uber driver gets rating for the ride which is averaged per day. For a given period of days, the value of driver is computed as the sum of the rating of the days in the given period, multiplied by the least rating in that period.

For example
The average ratings for some 4 days are:

2, 1, 3, 4
The the value of driver over these days is (2 + 1 + 3 + 4) * 1 = 10

Let's create a hypothesis that the incentive calculated is proportional to the greatest value over any contiguous period in drivers days on Uber. Given driver's average ratings per day, return this greatest value.

Example
Input
Given driver's ratings over 6 days:

[3, 1, 6, 4, 5, 2]
Output
60
Explanation
Then the period from day 3 to day 5, i.e. 6, 4, 5 has the greatest value, which is (6 + 4 + 5) * 4 = 60

[execution time limit] 1 seconds (cpp)

[input] array.integer ratings

Array of integers. a[i] represents average integer rating on i'th day. Size of array <= 10^5. 0 <= a[i] <= 10^6.

[output] integer64

The greatest value of any contiguous period throughout whole period in given array.
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindMaxIncentive {

	public int findMaxIncentive(int ratings[]) {
		
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i < ratings.length; i++) {
			int currSum = 0;
			int minRating = Integer.MAX_VALUE;
			for (int j=i; j< ratings.length; j++) {
				
				minRating = Math.min(minRating, ratings[j]);
				currSum = currSum + ratings[j];
				max = Math.max(max, currSum*minRating);
			}
		}
		return max;
	}
	
	/**
	 * Logic : Same as largest histogram
	 * @param arr
	 * @return
	 */
	public int calIncentive(int[] arr) {
	    if (arr == null || arr.length == 0) {
	        return 0;
	    }

	    int[] prefixSum = new int[arr.length];
	    prefixSum[0] = arr[0];
	    for(int i = 1; i< arr.length ; i++) {
	        prefixSum[i] = arr[i] + prefixSum[i - 1];
	    }

	    int[] lessFromLeft = new int[arr.length];
	    int[] lessFromRight = new int[arr.length];

	    lessFromLeft[0] = -1;
	    lessFromRight[arr.length - 1] = arr.length;

	    int index;

	    for(int i = 1; i < lessFromLeft.length; i++) {
	        index = i - 1;
	        while(index >= 0 && arr[index] >= arr[i]){
	            index = lessFromLeft[index];
	        }
	        lessFromLeft[i] = index;
	    }

	    for(int j = lessFromRight.length - 2; j >= 0; j--){
	        index = j + 1;
	        while(index <= lessFromRight.length - 1 && arr[index] >= arr[j]){
	            index = lessFromRight[index];
	        }
	        lessFromRight[j] = index;
	    }

	    int maxIncentives = 0;
	    for (int i = 0; i < arr.length; i++) {
	        int rightValue = (lessFromRight[i] == arr.length ? prefixSum[arr.length - 1] : prefixSum[lessFromRight[i] - 1]);
	        int leftValue =  (lessFromLeft[i] == -1 ? 0 : prefixSum[lessFromLeft[i]]);
	        maxIncentives = Math.max(maxIncentives, (rightValue - leftValue) * arr[i]);
	    }

	    return maxIncentives;
	}
	    
	public static void main(String[] args) {
		int arr[] = {3,1,6,4,5,2};
		FindMaxIncentive obj = new FindMaxIncentive();
		System.out.println(obj.findMaxIncentive(arr));
		System.out.println(obj.calIncentive(arr));
	}
}

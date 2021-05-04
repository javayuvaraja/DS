package com.yuva.leetcode.stack;

import java.util.Stack;
import java.util.stream.IntStream;

/***
 * 
Facebook interview question

You are given an array a of N integers. For each index i, you are required to determine the number of 
contiguous subarrays that fulfills the following conditions:
The value at index i must be the maximum element in the contiguous subarrays, and
These contiguous subarrays must either start from or end with i.

Output
An array where each index i contains an integer denoting the maximum number of contiguous subarrays of a[i]
Example:
a = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]

Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, 
					and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 -[1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]
 * @author Yuvaraja Kanagarajan
 *
 */
public class CountContinousSubArrayLeftOrRightMax {
	
	/**
	 * Logic : Find max as left and find max as right using stack.
	 * @param arr
	 * @return
	 */
	public int[] findSubArrCount (int arr[]) {
		// Keep track of how many starting indexes we're carrying along for a ride    
	    Stack<Integer> onboard = new Stack<>();
	    
	    // Once we drop off the index from the stack we'll sum up the steps it traveled here.
	    int[] ways = new int[arr.length];        
	    
	    // Train's moving from L to R, picking up indices and carrying as max on left
	    for (int i = 0; i < arr.length; i++) {
	      
	      // Drop off everyone that is too small
	      while (!onboard.isEmpty() && arr[i] > arr[onboard.peek()]) {
	        // dismounted is the index where this one started to travel with us.
	        int dismounted = onboard.pop();
	        // Count how many steps this one travelled
	        ways[dismounted] = i - dismounted;
	      }
	      
	      // Pick up this index.
	      onboard.push(i);
	    }
	    
	    // Drop off everyone that stayed on for the whole ride.
	    while (!onboard.isEmpty()) {
	      int dismounted = onboard.pop();
	      ways[dismounted] = arr.length - dismounted;
	    }
	    
	    
	    // Train's moving from R to L, reverse of above... with max on right
	    for (int i = arr.length - 1; i >= 0; i--) {
	      // We'll always count one index as we did above, so don't double count it.
	      ways[i]--;
	      
	      // Drop off everyone that is too small
	      while (!onboard.isEmpty() && arr[i] > arr[onboard.peek()]) {
	        // dismounted is the index where this one started to travel with us.
	        int dismounted = onboard.pop();
	        // Count how many steps this one travelled
	        ways[dismounted] += dismounted - i;
	      }
	      onboard.push(i);
	    }
	    
	    // Drop off everyone that stayed on for the whole ride.
	    while (!onboard.isEmpty()) {
	      int dismounted = onboard.pop();
	      ways[dismounted] += dismounted + 1;
	    }
	    return ways;
	}
	
	public static void main(String[] args) {
		int arr[]= {3, 4, 1, 6, 2};
		CountContinousSubArrayLeftOrRightMax obj = new CountContinousSubArrayLeftOrRightMax();
		int [] result = obj.findSubArrCount(arr);
		IntStream.range(0, result.length).forEach(e-> System.out.print(result[e]+ " "));
	}
}

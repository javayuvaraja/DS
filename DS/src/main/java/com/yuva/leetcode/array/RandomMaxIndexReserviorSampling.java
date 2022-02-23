package com.yuva.leetcode.array;

import java.util.Random;

/**
Given an array of integers arr, randomly return an index of the maximum value seen by far.

Example:
Input: [11, 30, 2, 30, 30, 30, 6, 2, 62, 62]

Having iterated up to the at element index 5 (where the last 30 is), randomly give an index among
 [1, 3, 4, 5] which are indices of 30 - the max value by far. Each index should have a ¼ chance to get picked.

Having iterated through the entire array, randomly give an index between 8 and 9 which are indices of the max value 62.

 * @author Yuvaraja Kanagarajan
 *
 */

public class RandomMaxIndexReserviorSampling {
	public void maxRandomIndex(int[] nums) {
		Random random = new Random();

		int max = Integer.MIN_VALUE;
		int maxIndex = -1;

		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
				count = 1;
			} else if (nums[i] == max) {
				count++;
				// probability of 1/count
				if (random.nextInt(count) == 0) {
					maxIndex = i;
				}
			}
			
		
			System.out.print(maxIndex + " ");
		}
	}
	
	public static void main(String[] args) {
		int arr[]= {11, 30, 2, 30, 30, 30, 6, 2, 5,2,2};
		RandomMaxIndexReserviorSampling obj = new RandomMaxIndexReserviorSampling();
		obj.maxRandomIndex(arr);
	}
}

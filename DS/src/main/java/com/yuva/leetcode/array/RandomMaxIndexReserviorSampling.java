package com.yuva.leetcode.array;

import java.util.Random;

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

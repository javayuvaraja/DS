package com.yuva.leetcode.array;

import java.util.Random;

/**
 * 528. Random Pick with Weight

You are given an array of positive integers w where w[i] describes the weight of ith index (0-indexed).

We need to call the function pickIndex() which randomly returns an integer in the 
range [0, w.length - 1]. pickIndex() should return the integer proportional to its weight in the w array. 
For example, for w = [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25 (i.e 25%) 
while the probability of picking the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).

More formally, the probability of picking index i is w[i] / sum(w).
 * @author Yuvaraja Kanagarajan
 *
 */
public class RandomPickWithWeight {
	Random random;
	int[] wSums;

	// Logic : Build and weighted range array.
	// Then find the insert index in sorted array using binary search.
	public RandomPickWithWeight(int[] w) {
		this.random = new Random();
		for (int i = 1; i < w.length; ++i)
			w[i] += w[i - 1];
		this.wSums = w;
	}

	public int pickIndex() {
		int len = wSums.length;
		int randomNum = random.nextInt(wSums[len - 1]) + 1;
		int left = 0, right = len - 1;
		// search position
		while (left < right) {
			int mid = left + right / 2;
			if (wSums[mid] == randomNum)
				return mid;
			else if (wSums[mid] < randomNum)
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
}
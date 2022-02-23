package com.yuva.leetcode.search;

/**
1891. Cutting Ribbons


You are given an integer array ribbons, where ribbons[i] represents the length of the ith ribbon, and an integer k.
 You may cut any of the ribbons into any number of segments of positive integer lengths, or perform no cuts at all.

For example, if you have a ribbon of length 4, you can:
Keep the ribbon of length 4,
Cut it into one ribbon of length 3 and one ribbon of length 1,
Cut it into two ribbons of length 2,
Cut it into one ribbon of length 2 and two ribbons of length 1, or
Cut it into four ribbons of length 1.
Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to throw away any excess ribbon as a result of cutting.

Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if you cannot obtain k ribbons of the same length.

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class CuttingRibbons {
	public int maxLength(int[] ribbons, int k) {
		int max = Integer.MIN_VALUE;
		for (int len : ribbons)
			max = Math.max(max, len);

		int low = 1, high = max, mid, count;
		while (low <= high) {
			mid = low + (high - low) / 2;

			count = 0;
			for (int length : ribbons)
				count += length / mid;

			if (count < k)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return high > 0 ? high : 0;
	}
}

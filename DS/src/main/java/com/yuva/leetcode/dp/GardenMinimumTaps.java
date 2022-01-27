package com.yuva.leetcode.dp;

import java.util.Arrays;

public class GardenMinimumTaps {

	public int minTaps(int n, int[] A) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i <= n; ++i) {
			int leftCover = Math.max(i - A[i], 0);
			int rightCover = Math.min(i + A[i], n);
			for (int j = leftCover; j <= rightCover; ++j)
				dp[j] = Math.min(dp[j], dp[Math.max(0, leftCover)] + 1);
		}
			
		return dp[n] < Integer.MAX_VALUE ? dp[n] : -1;
	}
	
	public static void main(String[] args) {
		GardenMinimumTaps obj = new GardenMinimumTaps();
		System.out.println(obj.minTaps(5, new int[] {3, 4, 1, 1,0, 0}));
	}
}

package com.yuva.leetcode.dp;

/**
 * 887. Super Egg Drop
 * 
 * You are given k identical eggs and you have access to a building with n
 * floors labeled from 1 to n.
 * 
 * You know that there exists a floor f where 0 <= f <= n such that any egg
 * dropped at a floor higher than f will break, and any egg dropped at or below
 * floor f will not break.
 * 
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1
 * <= x <= n). If the egg breaks, you can no longer use it. However, if the egg
 * does not break, you may reuse it in future moves.
 * 
 * Return the minimum number of moves that you need to determine with certainty
 * what the value of f is.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: k = 1, n = 2 Output: 2 Explanation: Drop the egg from floor 1. If it
 * breaks, we know that f = 0. Otherwise, drop the egg from floor 2. If it
 * breaks, we know that f = 1. If it does not break, then we know f = 2. Hence,
 * we need at minimum 2 moves to determine with certainty what the value of f
 * is.
 * 
 * Example 2: Input: k = 2, n = 6 Output: 3
 * 
 * Example 3: Input: k = 3, n = 14 Output: 4
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class EggDropping {

	public int calculate(int eggs, int floors) {

		int dp[][] = new int[eggs + 1][floors + 1];
		int c = 0;
		for (int i = 0; i <= floors; i++) {
			dp[1][i] = i;
		}

		for (int egg = 2; egg <= eggs; egg++) {
			for (int floor = 1; floor <= floors; floor++) {
				dp[egg][floor] = Integer.MAX_VALUE;
				for (int k = 1; k <= floor; k++) {
					c = 1 + Math.max(dp[egg - 1][k - 1], dp[egg][floor - k]);
					dp[egg][floor] = Math.min(dp[egg][floor], c);					
				}
			}
		}
		return dp[eggs][floors];
	}

	public int calculateRecursive(int eggs, int floors) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 0) {
			return 0;
		}
		int min = 1000;
		for (int i = 1; i <= floors; i++) {
			int val = 1 + Math.max(calculateRecursive(eggs - 1, i - 1), calculateRecursive(eggs, floors - i));
			if (val < min) {
				min = val;
			}
		}
		return min;
	}

	public static void main(String args[]) {
		EggDropping ed = new EggDropping();
		int r = ed.calculate(3, 100);
		System.out.println(r);
	}

}

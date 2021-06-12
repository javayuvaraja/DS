package com.yuva.leetcode.dp;

import java.util.Arrays;

/**

322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

 * @author Yuvaraja Kanagarajan
 *
 */
public class CoinChangeMinimumCoin {

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= amount; i++) {
				if (i - coins[j] >= 0)
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
	
	public int min = Integer.MAX_VALUE;

	public int coinChangeRecursion(int[] coins, int amount) {
		helper(coins, amount, coins.length - 1, 0);
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public void helper(int[] coins, int amount, int index, int count) {
		if (index < 0 || amount < 0)
			return;
		if (amount == 0)
			min = Math.min(min, count);
		helper(coins, amount - coins[index], index, count + 1); // including the coin
		helper(coins, amount, index - 1, count); // not including
	}

	public static void main(String[] args) {
		int coins[] = { 2 };
		int amount = 3;
		CoinChangeMinimumCoin obj = new CoinChangeMinimumCoin();
		System.out.println(obj.coinChange(coins, amount));
	}
}

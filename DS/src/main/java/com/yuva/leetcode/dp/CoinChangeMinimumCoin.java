package com.yuva.leetcode.dp;

public class CoinChangeMinimumCoin {
	public int coinChange(int[] coins, int amount) {
        int []result = new int[amount+1];
        for (int i=1; i <=amount; i++) {
        	int min = Integer.MAX_VALUE;
        	for (int coin : coins) {
        		if (i-coin>=0 && result[i-coin]!=-1) {
        			min = Math.min(min, result[i-coin]);
        		}
        	}
        	result[i] = (min == Integer.MAX_VALUE) ? -1 : min+1;
        }
        
        return result[amount];
    }
	
	public int min = Integer.MAX_VALUE;
	public int coinChangeRecursion(int[] coins, int amount) {
	    helper(coins, amount, coins.length-1, 0);
	    return min==Integer.MAX_VALUE?-1:min;
	}
	public void helper(int[] coins, int amount, int i, int count)
	{
	    if(i<0||amount<0) return;
	    if(amount==0) min = Math.min(min, count);
	    helper(coins, amount-coins[i], i, count+1); // including the coin
	    helper(coins, amount, i-1, count); // not including
	}
	
	public static void main(String[] args) {
		int coins[] = {2};
		int amount = 3;
		CoinChangeMinimumCoin obj = new CoinChangeMinimumCoin();
		System.out.println(obj.coinChange(coins, amount));
	}
}

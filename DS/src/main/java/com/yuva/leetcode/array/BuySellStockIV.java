package com.yuva.leetcode.array;

public class BuySellStockIV {

	public static void main(String[] args) {
		
	}
	
	 public int maxProfit(int k, int[] prices) {
	 
		 int result[][] = new int[k+1][prices.length+1];
		 
		 for (int i=1; i < result.length; i++) {
			 int maxDiff = -prices[0];
			 for (int j=1; j < result[0].length; j++) {
				 result[i][j] = Math.max(result[i][j-1], prices[j]+maxDiff);
				 maxDiff = Math.max(maxDiff, result[i-1][j]-prices[j]);
			 }
		 }
		 
		 return result[k][prices.length-1];
	 }
	 
	 public int maxProfitSlow(int k, int[] prices) {
		 
		 int result[][] = new int[k+1][prices.length+1];
		 
		 for (int i=1; i < result.length; i++) {
			 for (int j=1; j < result[0].length; j++) {
				 int maxVal = 0;
				 for (int m=0; m <j; m++) {
					 maxVal = Math.max(maxVal, prices[j]-prices[m] + result[i-1][m]);
				 }
				 result[i][j] = Math.max(result[i][j-1], maxVal);
			 }
		 }
		 
		 return result[k][prices.length-1];
		 
	 }
	 
	 
}

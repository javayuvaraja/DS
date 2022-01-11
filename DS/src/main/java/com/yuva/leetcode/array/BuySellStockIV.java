package com.yuva.leetcode.array;

public class BuySellStockIV {

	public static void main(String[] args) {
		int prices[] = {3,3,5,0,0,3,1,4};
		BuySellStockIV obj = new BuySellStockIV();
		System.out.println(obj.maxProfit(2, prices));
	}
	
	 public int maxProfit(int k, int[] prices) {
	 	 int result[][] = new int[k+1][prices.length];
		 
		 for (int i=1; i < result.length; i++) {
			 int maxDiff = -prices[0];
			 for (int j=1; j <prices.length; j++) {
				 result[i][j] = Math.max(result[i][j-1], prices[j]+maxDiff);
				 maxDiff = Math.max(maxDiff, result[i-1][j]-prices[j]);
			 }
		 }
		 
		 return result[k][prices.length-1];
	 }
	 
	 /**
	  * Formula 
	  * i- no.of.transactions
	  * j- day
	  * T[i][j]  = Max (T[i][j-1]),   // not transacting on the day
	  *                 prices[j] - prices[m] + T[i-1] [m] ) m=0,j-1    // Transacting on the jth day bought it in mth day.
	  *                                                                 // before mthday with one less transaction 
	  * @param k
	  * @param prices
	  * @return
	  */
	 public int maxProfitSlow(int k, int[] prices) {
		 int result[][] = new int[k+1][prices.length];
		 
		 for (int i=1; i < result.length; i++) {
			 for (int j=1; j < prices.length; j++) {
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

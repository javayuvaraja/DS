package com.yuva.leetcode.dp;


public class PaintHouseII {
	
	public int minCostIIDP(int[][] costs) {
		if (costs.length == 0)
			return 0;
		int n = costs.length, k = costs[0].length;
		int[][] dp = new int[n][k];
		for (int i = 0; i < k; i++) {
			dp[0][i] = costs[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int s = 0; s < k; s++) {
					if (s == j)
						continue;
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][s] + costs[i][j]);
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			res = Math.min(res, dp[n - 1][i]);
		}
		return res;
	}
	
	
	public int minCostII(int[][] costs) {
	    if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
	    
	    int n = costs.length, k = costs[0].length;
	    if(k == 1) return (n==1? costs[0][0] : -1);
	    
	    int prevMin = 0, prevMinInd = -1, prevSecMin = 0;//prevSecMin always >= prevMin
	    for(int i = 0; i<n; i++) {
	        int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
	        for(int j = 0; j<k;  j++) {
	            int val = costs[i][j] + (j == prevMinInd? prevSecMin : prevMin);
	            if(minInd< 0) {min = val; minInd = j;}//when min isn't initialized
	            else if(val < min) {//when val < min, 
	                secMin = min;
	                min = val;
	                minInd = j;
	            } else if(val < secMin) { //when min<=val< secMin
	                secMin = val;
	            }
	        }
	        prevMin = min;
	        prevMinInd = minInd;
	        prevSecMin = secMin;
	    }
	    return prevMin;
	}
}

package com.yuva.leetcode.dp;

public class BurstBaloon {

	public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = arr[n+1] = 1;   // Giving padding of 1 to the corner elements
        for(int i=1;i<=n;i++){
            arr[i] = nums[i-1];   //final padded array
        }
        
        int dp[][] = new int[n+2][n+2];
        
        for(int window = 1;window<=n;window++){     // window size
		
            for(int left = 1;left<=n-window+1;left++){    // left pointer
			
                int right = left+window-1;               // right pointer
				
                for(int i=left;i<=right;i++){           // iterate from left to right
				
                    dp[left][right] = Math.max(dp[left][right], (arr[left-1]*arr[i]*arr[right+1]) + dp[left][i-1] + dp[i+1][right]);
                                    
                }
            }
        }
        return dp[1][n];
    }
	
	 public int maxCoinsBottomUpDp(int[] nums) {

	        int T[][] = new int[nums.length][nums.length];

	        for (int len = 1; len <= nums.length; len++) {
	            for (int i = 0; i <= nums.length - len; i++) {
	                int j = i + len - 1;
	                for (int k = i; k <= j; k++) {
	                    //leftValue/rightValue is initially 1. If there is element on
	                    // left/right of k then left/right value will take that value.
	                    int leftValue = 1;
	                    int rightValue = 1;
	                    if (i != 0) {
	                        leftValue = nums[i-1];
	                    }
	                    if (j != nums.length -1) {
	                        rightValue = nums[j+1];
	                    }

	                    //before is initially 0. If k is i then before will
	                    //stay 0 otherwise it gets value T[i][k-1]
	                    //after is similarly 0 initially. if k is j then after will
	                    //stay 0 other will get value T[k+1][j]
	                    int before = 0;
	                    int after = 0;
	                    if (i != k) {
	                        before = T[i][k-1];
	                    }
	                    if (j != k) {
	                        after = T[k+1][j];
	                    }
	                    T[i][j] = Math.max(leftValue * nums[k] * rightValue + before + after,
	                            T[i][j]);
	                }
	            }
	        }
	        return T[0][nums.length - 1];
	    }
	public static void main(String[] args) {
		BurstBaloon obj = new BurstBaloon();
		obj.maxCoins(new int[] {3, 1, 5, 8});
	}
}

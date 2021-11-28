package com.yuva.leetcode.dp;

/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class StoneGameIII {

	public static String stoneGameIII(int[] stoneValue) {
//      So that who ever starts the game at that point will end-up having the score difference.
//          dp[i] is the difference in Alice's highest score over Bob's highest score if it's Alice's turn
//          or the difference in Bob's highest score over Alice's highest score if it's Bob's turn at i.
		int len = stoneValue.length;
		int[] dp = new int[len + 1];
//    Since we are always calculating the max score difference at each point, to get the max point diff one should know the value at the right.
//    So, Start the game from end.
		for (int i = len - 1; i >= 0; i--) {
//        Take a sum variable to accumulate the values at all 3 possible steps.
			int sum = 0;
//        Initialize the value -Inf.
			dp[i] = Integer.MIN_VALUE;
//        At every point consider taking all the possible steps.
			for (int j = i; j < Math.min(len, i + 3); j++) {
//            Try to jum to next step to calculate the best, value.
				sum += stoneValue[j];
//            Take the maximum points that can be made by a player by taking j steps.
//            Maximum points can have been made at j-1 step or,
//            At current steps. Since we are keeping the max point a player can have at each index.
//                  To get it current step, we have to reduce the value made at j+1, from current sum.
//            There are three option for Alice to choose.
//              Take A[i], diff = sum - dp[i+1]
//              Take A[i] + A[i+1], diff = sum - dp[i+2]
//              Take A[i] + A[i+1] + A[i+2], diff = sum - dp[i+3]
//            dp[i] equals the best outcome of these three solutions.
//            Ex: [1,2,3,-9]. Max at 3rd step (index=2) will be cur sum (1+2+3) - dp[3].
				dp[i] = Math.max(dp[i], sum - dp[j + 1]);
			}
		}
//    As the game is always starting from 0th index, take the point difference at 0th index.
		int diff = dp[0];
//    As alica always starts the game if the diff at 0 is greater than zero, Alica wins.
		if (diff > 0)
			return "Alice";
		if (diff < 0)
			return "Bob";
		return "Tie";
	}
	
	
	public static void main(String[] args) {
		int stones[] = {1,2,3,7};
		stoneGameIII(stones);
	}
}

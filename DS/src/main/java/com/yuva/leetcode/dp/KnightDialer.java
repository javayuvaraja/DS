package com.yuva.leetcode.dp;

/**
 * 935. Knight Dialer

The chess knight has a unique movement, it may move two squares vertically and one square horizontally, 
or two squares horizontally and one square vertically (with both forming the shape of an L). 
The possible movements of chess knight are shown in this diagaram:

A chess knight can move as indicated in the chess diagram below:


We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).


Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps 
to dial a number of length n. All jumps should be valid knight jumps.

As the answer may be very large, return the answer modulo 109 + 7.

Example 1:
Input: n = 1
Output: 10
Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.

Example 2:
Input: n = 2
Output: 20
Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]

Example 3:
Input: n = 3131
Output: 136006598
Explanation: Please take care of the mod.

 * @author Yuvaraja Kanagarajan
 *
 */
public class KnightDialer {

	public int knightDialer(int n) {
        int MOD = 1000000007;
        int paths[][] = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, 
        		{}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}}; // Previous moves of knight-> For instance, 
        							//if a knight is at 0, it reached from either 4 or 6. Similarly if it is at 1, it is reached from 7 or 9  & so on
        double dp[][] = new double[n + 1][10]; // rows -> no of steps taken to reach row i      cols-> no of digits
        for (int j = 0; j < 10; j++)
            dp[1][j] = 1; //populate the base case for n =1
        for (int i = 2; i < n + 1; i++) { // no of steps taken by knight to reach i
            for (int j = 0; j < 10; j++) { // no of digits
                for (int p : paths[j]) { // Previous move of knight in order to reach digit j
                    dp[i][j] += dp[i - 1][p]; // cumulatively add from the previous knight move.
                    						  // For instance., F(2, 0) -> F(1,4) +  F(1,6) F(2,6) -> F(1,0) + F(1,1) + F(1,7)
                }
                dp[i][j] %= MOD;
            }
        }
        double sum = 0d;
        for (int j = 0; j < 10; j++)
            sum += dp[n][j];
        return (int) (sum % MOD);
    }
}

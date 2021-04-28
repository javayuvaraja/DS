package com.yuva.leetcode.dp;

/**
 * Leetcode 70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?

 * @author Yuvaraja Kanagarajan
 *
 */
public class ClimbingStairs {

	public int climbStairs(int n) {
        if (n <=2) {
            return n==1?1:2;
        }
        int result[] = new int[n];
        result[0] =1;
        result[1] =2;
        for(int i=2; i < n; i++) {
            result[i] = result[i-1]+result[i-2];
        }
        return result[n-1];
    }
}

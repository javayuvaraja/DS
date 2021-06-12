package com.yuva.leetcode.stack;

import java.util.Stack;

/**
 * 
 * 739. Daily Temperatures
 * 
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * Given a list of daily temperatures T, return a list such that, for each day in the input, 
 * tells you how many days you would have to wait until a warmer temperature. 
 * If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. 
Each temperature will be an integer in the range [30, 100].


 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class DailyTemperatures {
	
	 /*
	  * Find next greater element in the array
	  */
	 public int[] dailyTemperatures(int[] temperatures) {
		 int []result =  new int [temperatures.length];
		 Stack<Integer> stack = new Stack<>();
		 for (int i = 0; i < temperatures.length; i++) {
			 while (!stack.isEmpty() && 
					 temperatures[stack.peek()] < temperatures[i]) { // current temp is warmer than peek then pop from stack
				 result[stack.peek()] = i - stack.pop(); 
			 }
			 stack.push(i);
		 }
		 return result;
	 }
	 
	 public static void main(String[] args) {
		DailyTemperatures obj = new DailyTemperatures();
		int T[]= {73, 74, 75, 71, 69, 72, 76, 73};
		for (int temp : obj.dailyTemperatures(T)) {
			System.out.print( temp+ " ");
		}
	}
}

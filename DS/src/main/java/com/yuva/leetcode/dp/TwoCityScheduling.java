package com.yuva.leetcode.dp;

import java.util.PriorityQueue;

/**
Leetcode 1029. Two City Scheduling

A company is planning to interview 2n people. 
Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying 
the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

Example 1:
Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.
The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

Example 2:
Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859

Example 3:
Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086

 * @author Yuvaraja Kanagarajan
 *
 */
public class TwoCityScheduling {

	public static int twoCitySchedCost(int[][] costs) {
		int N = costs.length / 2;
		int[][] dp = new int[N + 1][N + 1];
		
		for (int personToA = 1; personToA <= N; personToA++) {
			dp[personToA][0] = dp[personToA - 1][0] + costs[personToA - 1][0];
		}
		for (int personToB = 1; personToB <= N; personToB++) {
			dp[0][personToB] = dp[0][personToB - 1] + costs[personToB - 1][1];
		}
		for (int personToA = 1; personToA <= N; personToA++) {
			for (int personToB = 1; personToB <= N; personToB++) {
				//dp[1][1] = min (dp[0][1]+ cost to firstcity, dp[1][0]+ cost to second city);
				dp[personToA][personToB] = 
                        Math.min(dp[personToA - 1][personToB] + costs[personToA + personToB - 1][0], 
						         dp[personToA][personToB - 1] + costs[personToA + personToB - 1][1]);
			}
		}
		return dp[N][N];
	}
	
	
	/*
	 * Logic : Find the cost diff between the city A to City B
	 *        1. Use max heap to store based on the diff between city A to city B (Cost to City B - Cost to City A)
	 *        2. Calculate the result, fetch first n/2 from city A and last n/2 from city B
	 */
	public static int twoCitySchedCost1(int[][] costs) {
		
		PriorityQueue<int[]> profitHeap = new PriorityQueue<int[]>((a, b)-> a[1]-a[0] > b[1]-b[0] ? -1 : 1);
		
		// Adding to the queue
		for (int []cost : costs) {
			profitHeap.add(cost);
		}
		
		int index = 0;
		int totalCost = 0;
		while (!profitHeap.isEmpty()) {
			int []cost = profitHeap.poll();
			if (index >= costs.length/2) {
				totalCost = totalCost + cost[1];
			} else {
				totalCost = totalCost + cost[0];
			}
			index++;
		}
		return totalCost;
	}
	
	
	public static void main(String[] args) {
		int costs[][]= {{10,20},{30,200},{400,50},{30,20}};
		System.out.println(twoCitySchedCost(costs));
		System.out.println(twoCitySchedCost1(costs));
	}
}

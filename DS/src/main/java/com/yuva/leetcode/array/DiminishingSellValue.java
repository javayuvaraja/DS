package com.yuva.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1648. Sell Diminishing-Valued Colored Balls
 * 
 * Medium
 * 
 * You have an inventory of different colored balls, and there is a customer
 * that wants orders balls of any color.
 * 
 * The customer weirdly values the colored balls. Each colored ball's value is
 * the number of balls of that color you currently have in your inventory. For
 * example, if you own 6 yellow balls, the customer would pay 6 for the first
 * yellow ball. After the transaction, there are only 5 yellow balls left, so
 * the next yellow ball is then valued at 5 (i.e., the value of the balls
 * decreases as you sell more to the customer).
 * 
 * You are given an integer array, inventory, where inventory[i] represents the
 * number of balls of the ith color that you initially own. You are also given
 * an integer orders, which represents the total number of balls that the
 * customer wants. You can sell the balls in any order.
 * 
 * Return the maximum total value that you can attain after selling orders
 * colored balls. As the answer may be too large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: inventory = [2,5], orders = 4 Output: 14 Explanation: Sell the 1st
 * color 1 time (2) and the 2nd color 3 times (5 + 4 + 3). The maximum total
 * value is 2 + 5 + 4 + 3 = 14. Example 2:
 * 
 * Input: inventory = [3,5], orders = 6 Output: 19 Explanation: Sell the 1st
 * color 2 times (3 + 2) and the 2nd color 4 times (5 + 4 + 3 + 2). The maximum
 * total value is 3 + 2 + 5 + 4 + 3 + 2 = 19.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class DiminishingSellValue {

	/**
	 * Sum of n consecutive numbers = n / 2 (first number + last number) 
	 * n = lastnumber - firstnumber + 1
	 * 
	 * @param inventory
	 * @param orders
	 * @return
	 */
	public int maxProfit(int[] inventory, int orders) {
		/*
		 * 1 3 5 5 9 9 9 original sorted inventory 1 3 5 5 5 5 5 profit gain after
		 * selling all 9-value balls: (9 + 8 + 7 + 6) * 3 -> (9 + 6) * (9 - 6 + 1) / 2 *
		 * 3 1 3 3 3 3 3 3 (5 + 4) * (5 - 4 + 1) / 2 * 5 -> (curValue + nextValue + 1) *
		 * (curValue - nextValue) / 2 * numSameColor 1 1 1 1 1 1 1 0 0 0 0 0 0 0
		 * 
		 * need to handle the edge case that orders left is less than the number of
		 * items to buy
		 */
		int mod = 1000000007;
		Arrays.sort(inventory);
		int curIndex = inventory.length - 1;
		int curValue = inventory[curIndex];
		long profit = 0;
		while (orders > 0) {
			while (curIndex >= 0 && inventory[curIndex] == curValue) {
				curIndex--;
			}
			// if all colors of balls are the same value, nextValue is 0
			int nextValue = curIndex < 0 ? 0 : inventory[curIndex];
			// number of colors of balls with same value
			int numSameColor = inventory.length - 1 - curIndex;
			// number of items to buy
			int nums = (curValue - nextValue) * numSameColor;
			if (orders >= nums) {
				// buy all items
				profit += (long) (curValue + nextValue + 1) * (curValue - nextValue) / 2 * numSameColor;
			} else {
				// orders left is less than the number of items to buy
				int numFullRow = orders / numSameColor;
				int remainder = orders % numSameColor;
				profit += (long) (curValue + curValue - numFullRow + 1) * numFullRow / 2 * numSameColor;
				profit += (long) (curValue - numFullRow) * remainder;
			}
			orders -= nums;
			profit = profit % mod;
			curValue = nextValue;
		}
		return (int) profit;
	}

	public int maxProfit1(int[] inventory, int orders) {
		int mod = 1000000007;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int num : inventory) {
			pq.offer(num);
		}

		int cur = pq.poll();
		int count = 1; // When pq poll the next element, +1 to count.
		long res = 0;
		while (orders > 0) {
			int next = pq.isEmpty() ? 0 : pq.peek();
			// If the number for [next + 1, cur] less than orders, add them ALL.
			if ((cur - next) * count <= orders) {
				// Add all the sum, and don't forget cast!
				long num = (1L * (next + 1 + cur) * (cur - next) * count / 2) % mod;
				res = (res + num) % mod;
				orders -= (cur - next) * count;

			} else {
				// If the number for [next + 1, cur] greater than orders, only add partially.
				// Calculate the new next where the add stops.
				next = cur - orders / count;
				long num = (1L * (next + 1 + cur) * (cur - next) * count / 2) % mod;
				res = (res + num) % mod;
				// For the last number to add (new next), and don't forget cast! I forget here
				// in contest!
				res = (res + 1L * next * (orders % count)) % mod;
				orders = 0;
			}

			if (!pq.isEmpty())
				cur = pq.poll();
			count++;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		int[] inventory = new int[] {4,6,6,2,2,3};
		DiminishingSellValue obj = new DiminishingSellValue();
		obj.maxProfit(inventory, 25);
	}
}

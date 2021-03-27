package com.yuva.leetcode.general;

import java.util.HashMap;

/**
 * Leetcode 170. Two Sum III - Data structure design
	Question:
	Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.
	
	Implement the TwoSum class:
	
	TwoSum() Initializes the TwoSum object, with an empty array initially.
	void add(int number) Adds number to the data structure.
	boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class TwoSumIII {

	HashMap<Integer, Integer> map;

	/** Initialize your data structure here. */
	public TwoSumIII() {
		map = new HashMap<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		map.put(number, map.getOrDefault(number, 0) + 1);
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		for (int i : map.keySet()) {
			int target = value - i;
			int counter = target == i ? 2 : 1;
			if (map.getOrDefault(target, 0) >= counter) {
				return true;
			}
		}
		return false;
	}
}

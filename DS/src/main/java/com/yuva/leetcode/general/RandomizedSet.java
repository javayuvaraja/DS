package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. R
eturns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. 
Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements 
(it's guaranteed that at least one element exists when this method is called). 
Each element must have the same probability of being returned.

 * @author Yuvaraja Kanagarajan
 *
 */
class RandomizedSet {

	List<Integer> numsList;
	Map<Integer, Integer> numMap;
	Random random;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		numsList = new ArrayList<>();
		numMap = new HashMap<>();
		random = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (numMap.containsKey(val)) {
			return false;
		}
		numMap.put(val, numsList.size());
		numsList.add(val);
		return true;

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (numMap.containsKey(val)) {
			int index = numMap.get(val);
			if (index < numsList.size() - 1) { // not the last one than swap the last one with this val
				int lastElement = numsList.get(numsList.size() - 1);
				numsList.set(index, lastElement);
				numMap.put(lastElement, index);
			}
			numsList.remove(numsList.size() - 1);
			numMap.remove(val);
			return true;
		}
		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return numsList.get(random.nextInt(numsList.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */

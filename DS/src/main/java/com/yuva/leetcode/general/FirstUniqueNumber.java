package com.yuva.leetcode.general;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 	You have a queue of integers, you need to retrieve the first unique integer in the queue.

	Implement the FirstUnique class:
	
	1. FirstUnique(int[] nums) -  Initializes the object with the numbers in the queue.
	2. int showFirstUnique()  - returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
	3. void add(int value) - insert value to the queue.
	
 * @author Yuvaraja Kanagarajan
 *
 */
public class FirstUniqueNumber {

	Set<Integer> all = new HashSet<>();
    Set<Integer> uniqueSet = new LinkedHashSet<>();
    public FirstUniqueNumber(int[] nums) {
        for(int n : nums) {
           add(n);
        }
    }
    
    public int showFirstUnique() {
        return uniqueSet.stream().findFirst().orElse(-1);
    }
    
    public void add(int value) {
        if(all.add(value)) {
            uniqueSet.add(value);
        } else {
            uniqueSet.remove(value);
        }
    }
}

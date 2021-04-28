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
	
	Input: 
["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
[[[2,3,5]],[],[5],[],[2],[],[3],[]]
Output: 
[null,2,null,2,null,3,null,-1]
Explanation: 
FirstUnique firstUnique = new FirstUnique([2,3,5]);
firstUnique.showFirstUnique(); // return 2
firstUnique.add(5);            // the queue is now [2,3,5,5]
firstUnique.showFirstUnique(); // return 2
firstUnique.add(2);            // the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique(); // return 3
firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique(); // return -1

Input: 
["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
Output: 
[null,-1,null,null,null,null,null,17]
Explanation: 
FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
firstUnique.showFirstUnique(); // return -1
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
firstUnique.showFirstUnique(); // return 17	
 * @author Yuvaraja Kanagarajan
 *
 */
public class FirstUniqueNumber {

	Set<Integer> numMap = new HashSet<>();
    Set<Integer> queue = new LinkedHashSet<>();
    public FirstUniqueNumber(int[] nums) {
        for(int n : nums) {
           add(n);
        }
    }
    
    public int showFirstUnique() {
        //return queue.stream().findFirst().orElse(-1);
    	if (queue.isEmpty()) {
    		return -1;
    	}
    	
    	return queue.iterator().next();
    		
    }
    
    public void add(int value) {
        if(numMap.add(value)) {
            queue.add(value);
        } else {
            queue.remove(value);
        }
    }
}

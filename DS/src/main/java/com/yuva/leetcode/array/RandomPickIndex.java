package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 398. Random Pick Index

Given an integer array nums with possible duplicates, randomly output the index of a given target number. 
You can assume that the given target number must exist in the array.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the array nums.
int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should have an equal probability of returning.
 

Example 1:

Input
["Solution", "pick", "pick", "pick"]
[[[1, 2, 3, 3, 3]], [3], [1], [3]]
Output
[null, 4, 0, 2]

Explanation
Solution solution = new Solution([1, 2, 3, 3, 3]);
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class RandomPickIndex {

	Map<Integer, List<Integer>> indexMap = new HashMap<>();
    Random random;
    int nums[];
    public RandomPickIndex(int[] nums) {
    	this.nums = nums;
        random = new Random();
        for (int i=0; i <nums.length ; i++) {
            indexMap.putIfAbsent(nums[i], new ArrayList<Integer>());
            List<Integer> indexList =  indexMap.get(nums[i]);
            indexList.add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indexList = indexMap.get(target);
        if (indexList.size()==0) {
            return -1;
        }
 
        int index = random.nextInt(indexList.size());
        return indexList.get(index);
    }
    
    public int pickReservoirSampling(int target) {
        random = new Random();
        int count = 0;
        int result = 0;
        
        for (int i=0; i < nums.length; i++) {
        	if (nums[i]== target) {
        		count++;
        	}
        	if (random.nextInt(count) == 0) {
        		result =i;
        	}
        }
        return result;
       
    }
    
    public static void main(String[] args) {
		int arr[]= {1, 2, 3, 3, 3};
		RandomPickIndex obj = new RandomPickIndex(arr);
		System.out.println(obj.pick(3));
		System.out.println(obj.pick(3));
		
		
	}
    
    
}

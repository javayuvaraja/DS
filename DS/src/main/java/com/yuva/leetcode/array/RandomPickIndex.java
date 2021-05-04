package com.yuva.leetcode.array;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {

	Map<Integer, List<Integer>> indexMap = new HashMap<>();
    Random random;
    public RandomPickIndex(int[] nums) {
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
    
    public static void main(String[] args) {
		int arr[]= {1, 2, 3, 3, 3};
		RandomPickIndex obj = new RandomPickIndex(arr);
		System.out.println(obj.pick(3));
		System.out.println(obj.pick(3));
		
		
	}
    
    
}

package com.yuva.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubsetCombination {

	/*
	 * First add empty list to the result : {}
	 * Then iterate by size of the result size 
	 *  {}
	 *  size :1,  {} add 1 it will become  {1} , result : {},  {1}
	 *  size :2   {2}, {1,2} result : {}, {1}, {2}, {1,2}
	 *  size : 4   {3}, {1,3}, {2,3}, {1, 2, 3} , result :  {}, {1}, {2}, {1,2}, {3}, {1,3}, {2,3}, {1, 2, 3}                        
	 */
	public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack1(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack1(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	} 
}

package com.yuva.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class PermutatationIntegerArray {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		permute(nums, new boolean[nums.length], resultList, new ArrayList<Integer>());
		return resultList;

	}

	private void permute(int arr[], boolean[] isUsed, 
			List<List<Integer>> resultList, List<Integer> currList) {
		
		if (currList.size() == arr.length) {
			resultList.add(new ArrayList<Integer>(currList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (isUsed[i]) {
				continue;
			}
			isUsed[i] = true;
			currList.add(arr[i]);
			permute(arr, isUsed, resultList, currList);
			isUsed[i] = false;
			currList.remove(currList.size() - 1);
		}
	}
}

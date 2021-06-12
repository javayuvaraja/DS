package com.yuva.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
315. Count of Smaller Numbers After Self

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

 * @author Yuvaraja Kanagarajan
 *
 */
public class CountofSmallerNumberAfterSelf {

	class Item {
		public Item(int val, int index) {
			super();
			this.val = val;
			this.index = index;
		}
		int val;
		int index;
		
	}
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result =  new ArrayList<Integer>();
		Item[] items = new Item[nums.length];
		
		for (int i=0; i < nums.length; i++) {
			items[i] = new Item (nums[i], i);
		}
		
		int []count = new int[nums.length];
		
		sort(items, 0, nums.length-1, count);
		for (int temp: count) {
			result.add(temp);
		}
		
		return result;
    }
	
	private void sort(Item[] items, int start, int end, int[] count) {
		if (start < end) {
			int mid = (start+end)/2;
			sort(items, start, mid, count);
			sort(items, mid+1, end, count);
			merge(items, start, mid, end, count);
		}
	}
	
	private void merge(Item []items, int start, int mid, int end, int []count) {
		Item[] sorted = new Item[end- start+1];
		int k=0;
		int i = start;
		int j= mid+1;
		
		int rightCounter = 0;
		while (i <= mid && j <= end) {
			if (items[j].val < items[i].val) { // left is greater than the right, so increment the counter value
				rightCounter++;
				sorted[k++] = items[j++];
			} else {
				count[items[i].index] += rightCounter;
				sorted[k++] = items[i++];
			}
		}
		
		while (i <= mid) {
			count[items[i].index] += rightCounter;
			sorted[k++] = items[i++];
		}
		
		while (j <= end) {
			sorted[k++] = items[j++];
		}
		System.arraycopy(sorted, 0, items, start, end- start+1);
	}
	
	public static void main(String[] args) {
		int []nums = {5,2,6,1};  //Output: [2,1,1,0]
		CountofSmallerNumberAfterSelf obj = new CountofSmallerNumberAfterSelf();
		List<Integer> result = obj.countSmaller(nums);
		System.out.println(result);
	}
}

package com.yuva.leetcode.heap;

import java.util.*;

/**
 Example of Min Heap:

            5                      13
         /      \               /       \  
       10        15           16         31 
      /                      /  \        /  \
    30                     41    51    100   41
 
 * 
 * @author Yuvaraja Kanagarajan
 *
 */

public class KthLargestElementFromStream {

	/*
	 * Using Min Heap DS
	 * 
	 */

	static PriorityQueue<Integer> minHeap;
	static List<Integer> getAllKthNumber(int arr[], int k) {
		List<Integer> list = new ArrayList<>();
		for (int val : arr) {
			if (minHeap.size() < k) {
				minHeap.add(val);
			} else {
				if (val > minHeap.peek()) { // check whether top element is lesser than the current value, 
					minHeap.poll();
					minHeap.add(val);
				}
			}
			if (minHeap.size() >= k)
				list.add(minHeap.peek());
			else
				list.add(-1);
		}
		return list;
	}

	// Driver Code
	public static void main(String[] args) {
		minHeap = new PriorityQueue<>();
		int k = 4;
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		List<Integer> res = getAllKthNumber(arr, k);
		for (int x : res)
			System.out.print(x + " ");
	}

}
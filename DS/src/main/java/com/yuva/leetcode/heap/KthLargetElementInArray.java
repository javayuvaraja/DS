package com.yuva.leetcode.heap;

import java.util.PriorityQueue;
/**

215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 * @author Yuvaraja Kanagarajan
 *
 */
public class KthLargetElementInArray {

	 public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	        
	        for (int val : nums) {
	            if (minHeap.size() < k) {
	                minHeap.add(val);
	            } else {
	               if (val > minHeap.peek()) {
	                   minHeap.poll();
	                   minHeap.add(val);
	               } 
	            }
	        }        
	        return minHeap.size()>=k? minHeap.poll(): -1;
	    }
	 
		public int findKthLargest1(int[] nums, int k) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();

			for (int val : nums) {
				minHeap.add(val);
				if (minHeap.size() > k) {
					minHeap.poll();
				}
			}
			return minHeap.peek();
		}
}

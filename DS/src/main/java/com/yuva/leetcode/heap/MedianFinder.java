package com.yuva.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
	private boolean evenCount = true;

	public MedianFinder() {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max heap
		minHeap = new PriorityQueue<>(); // min heap
	}
	public double findMedian() {
	    if (evenCount) { // if total size is even then pick from max and min heap
	        return (maxHeap.peek() + minHeap.peek()) / 2.0;
	    }
	    else {
	        return maxHeap.peek();
	    }
	}

	public void addNum(int num) {
	    if (evenCount) { // if already even count then add to the min heap
	        minHeap.offer(num);
	        maxHeap.offer(minHeap.poll());
	    } else {
	        maxHeap.offer(num);
	        minHeap.offer(maxHeap.poll());
	    }
	    evenCount = !evenCount;
	}
}

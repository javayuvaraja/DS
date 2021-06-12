package com.yuva.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
295. Find Median from Data Stream
Hard

The median is the middle value in an ordered integer list. If the size of the list is even, 
there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 
Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation

MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 


 * @author Yuvaraja Kanagarajan
 *
 */
public class MedianFromDataStream {

	private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
	private boolean evenCount = true;

	public MedianFromDataStream() {
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

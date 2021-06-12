package com.yuva.leetcode.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
Bloomberg Interview Question
 
Given a list of meetings for a given day in a conference center, return a list
of time slots during which the most number of concurrent meetings are held.
Each meeting has a start time and end time and occupies a single room in a
conference center.

Input:
(100,300) // meeting 1, 1:00 am to 3:00 am
(145,215) // meeting 2
(200,230) // meeting 3
(215,300) // meeting 4
(215,400) // meeting 5
(500,600) // meeting 6
(600,700) // meeting 7

Output:
(215,230) // 4 concurrent meetings: 1,3,4,5
 *  * @author Yuvaraja Kanagarajan
 *
 */
public class ConcurrentMeetingRooms {
	public int[] findMaxConcurrentMeetings(int[][] intervals) {
		// Sorting based on the start time
		int start = 0;
		int end = 1;
		Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[start]));
		// Adding to the end time to the heap
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int maxLength =0;
		int maxStart = 0;
		int maxEnd = 0;
		heap.add(intervals[0][end]);
		for (int i=1; i < intervals.length; i++) {
			int currInterval[] = intervals[i];
			// remove the meeting which are ended before this. Because those wont be concurrent meeting
			while(!heap.isEmpty() && currInterval[start] >= heap.peek()) {
				heap.poll();
			}
			heap.offer(currInterval[end]); // add the curr meeting end time
			if (heap.size()> maxLength) {
				maxLength = heap.size();
				maxStart = currInterval[start]; // current meeting start will be the latest time
				maxEnd = heap.peek(); // the heap peek which is earliest meeting which will complete soon
			}
		}

		return new int[] {maxStart, maxEnd};
	}
	
	public static void main(String[] args) {
		//int [][]intervals =  new int[][] {{0, 30},{5,10},{15, 20}, {10, 15}, {20, 45}};
		int [][]intervals = new int[][] {{100,300}, {145,215}, {200, 230}, {215, 300}, {215, 400}, {400, 500}, {500, 600}};	
		ConcurrentMeetingRooms obj = new ConcurrentMeetingRooms();
		int[] maxMeetings = obj.findMaxConcurrentMeetings(intervals);
		System.out.println(maxMeetings[0] + " " + maxMeetings[1]);
		
	}
}

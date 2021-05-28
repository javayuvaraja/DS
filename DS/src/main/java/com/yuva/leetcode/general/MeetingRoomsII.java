package com.yuva.leetcode.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 253. Meeting Rooms II .
 * Given an array of meeting time intervals consisting of start and 
 * end times [[s1,e1],[s2,e2],...] (si < ei), 
 * Find the minimum number of conference rooms required. 
 * Example 1: Input: [[0, 30],[5,10],[15, 20]] 
 * Output: 2 Example 2: Input: [[7,10],[2,4]] Output: 1
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
		// Sorting based on the start time
		int start = 0;
		int end = 1;
		Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[start]));
		// Adding to the end time to the heap
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int count = 0;
		
		for (int[] interval : intervals) {
			if (heap.isEmpty()) {
				count++;
				heap.offer(interval[end]);
			} else {
				if (interval[start] >= heap.peek()) {
					heap.poll();
				} else {
					count++;
				}

				heap.offer(interval[end]);
			}
		}

		return count;
	}
	
	
	public int minMeetingRooms1(int[][] intervals) {
		// Sorting based on the start time
		int start = 0;
		int end = 1;
		Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[end]));
		int endIndex = 0;
		int required = 1;
		for (int i =1; i < intervals.length; i++) {
			if (!(intervals[i][start] >= intervals[endIndex][end])) {
				required++;
			} else {
				endIndex++;
			}
		}

		return required;
	}
	
	public static void main(String[] args) {
		int [][]intervals =  new int[][] {{0, 30},{5,10},{15, 20}, {10, 15}, {20, 45}};
		MeetingRoomsII obj = new MeetingRoomsII();
		System.out.println(obj.minMeetingRooms(intervals));
		System.out.println(obj.minMeetingRooms1(intervals));
		
	}
}

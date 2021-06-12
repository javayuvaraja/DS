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
 * Freq : Amazon 26 Bloomberg 20 Google 12 Microsoft 10 Facebook 9 ByteDance 8 Yandex 5 Uber 4 
 *        eBay 4 Twitter 3 Oracle 3  Adobe 3 Walmart Labs 3 Visa 2 tiktok 2
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
	
	/**
	 * 1. Sort by start time
	 * 2. Sort by end time
	 * 
	 * When new meeting comes checks the whether any rooms avaiable based on the end time
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i] < ends[endsItr]) { // checking the end time index is greater than the current time, if increase the meeting room.
                rooms++;
            }  else {
                endsItr++;
            }
        }
        return rooms;
    }
	
	public static void main(String[] args) {
		//int [][]intervals =  new int[][] {{0, 30},{5,10},{15, 20}, {10, 15}, {20, 45}};

		int [][]intervals = new int[][] {{2,15},{36,45},{9,29},{16,23},{4,9}};
		MeetingRoomsII obj = new MeetingRoomsII();
		System.out.println(obj.minMeetingRooms(intervals));
		//System.out.println(obj.minMeetingRooms(intervals));
		
	}
}

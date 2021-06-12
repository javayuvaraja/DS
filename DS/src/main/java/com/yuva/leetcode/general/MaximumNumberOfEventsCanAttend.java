package com.yuva.leetcode.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
1353. Maximum Number of Events That Can Be Attended

Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.

1 <= events.length <= 100000
events[i].length == 2
1 <= startDayi <= endDayi <= 100000

 * @author Yuvaraja Kanagarajan
 *
 */
public class MaximumNumberOfEventsCanAttend {
	
	public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort events increasing by start time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int eventsCount = 0, index = 0, n = events.length;
        for (int d = 1; d <= 100000; d++) {
            while (index < n && events[index][0] == d) { // Add all the new events that starts on day `d`
                minHeap.add(events[index++][1]);
            }
            while (!minHeap.isEmpty() && minHeap.peek() < d) { // Remove events that are already closed
                minHeap.poll();
            }
            
            if (!minHeap.isEmpty()) { // Use day `d` to attend to the event that closes earlier
                eventsCount++;
                minHeap.poll();
            }
        }
        return eventsCount;
    }
	
	public static void main(String[] args) {

		int [][]intervals = new int[][] {{2,15},{36,45},{9,29},{16,23},{4,9}};
		MaximumNumberOfEventsCanAttend obj = new MaximumNumberOfEventsCanAttend();
		System.out.println(obj.maxEvents(intervals));
		//System.out.println(obj.minMeetingRooms(intervals));
		
	}
}

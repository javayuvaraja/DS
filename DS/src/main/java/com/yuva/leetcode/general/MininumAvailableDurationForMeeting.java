package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
1229. Meeting Scheduler

Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, 
return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. 
That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 

Constraints: 
 * @author Yuvaraja Kanagarajan
 *
 */
public class MininumAvailableDurationForMeeting {
	
	//Logic : Two pointer concept. Get max start and min end. Check within that meeting can be arrange. 
	// Move the pointer based on the min end 
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        Arrays.sort(slots1, (a,b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a,b) -> a[0] - b[0]);
        int start = 0;
        int end = 1;
        while(i < slots1.length && j < slots2.length){
            int maxStart = Math.max(slots1[i][start], slots2[j][start]);
            int minEnd = Math.min(slots1[i][end], slots2[j][end]);
            if(minEnd - maxStart >= duration){
                result.add(maxStart);
                result.add(maxStart+duration);
                return result;
            }
           // increment indexes of whatever interval is ending first, sometimes it could be both
            if(slots1[i][end] == minEnd) i++;
            if(slots2[j][end] == minEnd) j++;
        }
        
        return result;
    }
	
	
	// Logic Priority Queue. 
	// 1. Put both slots1 and slots2 into PriorityQueue/heap (first filter slots shorter than duration, sort by starting time;
	// Pop out the slots one by one, comparing every consective two to check if having duration time in common.
	public List<Integer> minAvailableDuration1(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] s : slots1) 
            if (s[1] - s[0] >= duration) 
                pq.offer(s);
        for (int[] s : slots2) 
            if (s[1] - s[0] >= duration) 
                pq.offer(s);
        while (pq.size() > 1)
            if (pq.poll()[1] >= pq.peek()[0] + duration)
                return Arrays.asList(pq.peek()[0], pq.peek()[0] + duration);
        return Arrays.asList();
    }
}

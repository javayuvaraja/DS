package com.yuva.leetcode.general;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode 252 – Meeting Rooms (Java) Category: Given an array of meeting time
 * intervals consisting of start and end times [s1, e1], [s2, e2], ... ,
 * determine if a person could attend all meetings.
 * 
 * For example, Given [ [0, 30], [5, 10], [15, 20] ], return false.
 *  
 * @author Yuvaraja Kanagarajan
 *
 */
public class MeetingRooms {

	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		
		
		Arrays.sort(intervals, Comparator.comparing((Interval interval) -> interval.start));
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i-1].end) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		MeetingRooms obj = new MeetingRooms();
		Interval []intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		System.out.println(obj.canAttendMeetings(intervals));
		
	}
}

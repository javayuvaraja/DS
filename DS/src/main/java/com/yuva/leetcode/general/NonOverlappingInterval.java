package com.yuva.leetcode.general;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {

	public int eraseOverlapIntervals(Interval[] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(i -> i.end));
		int nonOverlapping = 1;
		int prevEnd = intervals[0].end;
		for (Interval curr : intervals) {
			if (prevEnd <= curr.start) {
				prevEnd = curr.end;
				nonOverlapping++;
			}
		}
		return intervals.length - nonOverlapping;
	}
}

package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
           Given an array of intervals where intervals[i] = [starting, end], merge all overlapping intervals, 
           and return an array of the non-overlapping intervals that cover all the intervals in the input.
           
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * @author Yuvaraja Kanagarajan
 *
 */
public class MergeInterval {

	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		int start = 0;
		int end = 1;
		Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));

		List<int[]> result = new ArrayList<>();
		int prevInterval[] = intervals[0];
		result.add(prevInterval);
		for (int i = 1; i < intervals.length; i++) {
			int[] currInterval = intervals[i];
			if (prevInterval[end] >= currInterval[start]) {
				prevInterval[end] = Math.max(currInterval[end], prevInterval[end]);
			} else {
				prevInterval = currInterval;
				result.add(prevInterval);
			}
		}
		return result.toArray(new int[result.size()][]);

	}
}

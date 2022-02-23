package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yuva.leetcode.general.Interval;

/**
Leetcode 759.Employee Free Time

Given a list schedule of employees, which represents the working time for each employee.
Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
Return the list of finite intervals representing common, positive-length free time for all employees, 
also in sorted order.

Example 1:
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.

Example 2:
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]

 * @author Yuvaraja Kanagarajan
 *
 */
public class EmployeeFreeTime {

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		if (schedule == null || schedule.size() == 0) {
			return null;
		}
		List<Interval> result = new ArrayList<Interval>();
		List<Interval> intervalList = new ArrayList<>();
		for (List<Interval> interval : schedule) {
			intervalList.addAll(interval);
		}
		// sorting by start time
		Collections.sort(intervalList, (a,b)->(a.start-b.start));
		int prevEnd = intervalList.get(0).end;
		for (int i=1; i < intervalList.size(); i++) {
			Interval curr = intervalList.get(i);
			// curr start is greater than prev end means, inbetween interval is free time.
			if (curr.start > prevEnd) {
				result.add(new Interval (prevEnd, curr.start));
				prevEnd = curr.end;
			} else {
				prevEnd = Math.max(prevEnd, curr.end);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		//schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
	}
}

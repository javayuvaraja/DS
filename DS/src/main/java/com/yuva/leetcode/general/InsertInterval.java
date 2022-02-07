package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] 
represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals 
still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * @author Yuvaraja Kanagarajan
 *
 */
public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newIntervals) {
	     
        List<Interval> intervalList = new ArrayList<>();
        for (int i=0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            intervalList.add (new Interval (start, end));
        }
        List<Interval> result = new ArrayList<>();
        Interval newInterval = new Interval(newIntervals[0], newIntervals[1]);
        Collections.sort(intervalList, (a,b)-> a.start  - b.start);
        for (int i=0; i < intervalList.size(); i++)  {
            Interval currInterval = intervalList.get(i);
            if (newInterval==null || currInterval.end < newInterval.start) {
                result.add(currInterval);    
            } else if (currInterval.start > newInterval.end) {
                result.add(newInterval);
                result.add(currInterval);
                newInterval= null;
            } else {
                newInterval.start = Math.min(currInterval.start, newInterval.start);
                newInterval.end = Math.max(currInterval.end, newInterval.end);
            }
        }
        if (newInterval!=null) {
            result.add(newInterval);
        }
        int [][]resultArr = new int[result.size()][2];
        for (int i=0; i < result.size(); i++) {
            Interval temp = result.get(i);
            resultArr[i][0] = temp.start;
            resultArr[i][1] = temp.end;
            
        }
        return resultArr;
            
    }
    
    class Interval {
        public int start;
        public int end;
        Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

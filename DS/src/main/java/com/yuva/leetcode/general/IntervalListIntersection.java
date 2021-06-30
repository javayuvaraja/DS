package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.List;

/**
986. Interval List Intersections

You are given two lists of closed intervals, firstList and secondList, 
where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. 
Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.
A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are 
either empty or represented as a closed interval. 
For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Input: firstList = [[0,2],[5,10],[13,23],[24,25]], 
      secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class IntervalListIntersection {

	/**
	 * Logic : Sort the intervals based on the start time
	 
	 */
	public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new Interval[] {};
        }
        
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();
        while (i < m && j < n) {
            Interval a = A[i];
            Interval b = B[j];

            // find the overlap... 
            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end, b.end);
            
            if (endMin >= startMax) {
                res.add(new Interval(startMax, endMin));
            }
            
            //update the pointer with smaller end value...
            if (a.end == endMin) { i++; }
            if (b.end == endMin) { j++; }
        }
        return res.toArray(new Interval[0]);
    }
}

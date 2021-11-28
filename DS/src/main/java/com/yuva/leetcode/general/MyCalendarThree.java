package com.yuva.leetcode.general;

import java.util.TreeMap;

public class MyCalendarThree {

	private TreeMap<Integer, Integer> timeline = new TreeMap<>();
	
	public int book(int start, int end) {
        
		timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        
        int count = 0, res = 0;
        for (int c : timeline.values()) {
            count += c;
            res = Math.max(res, count);
        }
        
        return res;
    }
}

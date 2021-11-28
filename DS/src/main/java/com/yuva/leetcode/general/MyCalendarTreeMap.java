package com.yuva.leetcode.general;

import java.util.TreeMap;

class MyCalendarTreeMap {
    TreeMap<Integer, Integer> calenderMap;
    public MyCalendarTreeMap() {
         calenderMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer left = calenderMap.floorKey(start);
        Integer right = calenderMap.ceilingKey(start);
        if(left!=null && calenderMap.get(left) > start) {
            return false;
        }
        if(right!=null && right < end) {
            return false;
        }
        calenderMap.put(start, end);
        return true;
    }
}

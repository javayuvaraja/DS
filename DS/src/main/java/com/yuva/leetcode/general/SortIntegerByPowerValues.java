package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortIntegerByPowerValues {
	
	
	Map<Integer,Integer> map; // Store steps for each value to reach 1. So that it can be reused.

    public int getKth(int low, int high, int k) {
        map = new HashMap<>();
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)-> b[1]!=a[1] ?a[1]-b[1]:a[0]-b[0]);
        for (int i=low;i<=high;i++) {
        	int level = findLevel(i);
            pq.add(new int[]{i,level});
        }
        
        while (!pq.isEmpty() &&  k > 1) { 
            pq.poll();
            k--;
        }
        return pq.poll()[0];
    }

    private int findLevel(int num ){
	    int level = 0;
	    while(num!=1){
	        if(num%2==0) {
	        	num/=2;
	        }
	        else {
	        	num=3*num+1;
	        }
	        level++;
	    }
	    return level;
	}
    
    private int levelItil(int num ){
	    if (num == 1) {
	    	return 0;
	    }
	    
	    if (map.containsKey(num)) {
	    	return map.get(num);
	    }
	    
	    if (num%2==0) {
	    	map.put(num, levelItil(num/2)+1);
	    } else {
	    	map.put(num, levelItil(3*num+1)+1);
	    }
	    
	    return map.get(num);
	}
	
	public static void main(String[] args) {
		 int lo = 12, hi = 15, k = 2;
	}
}

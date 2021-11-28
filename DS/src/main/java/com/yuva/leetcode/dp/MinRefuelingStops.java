package com.yuva.leetcode.dp;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinRefuelingStops {

	public int minRefuelStops(int target, int startFuel, int[][] s) {
        long[] dp = new long[s.length + 1];
        dp[0] = startFuel; // from this how long can travel without refuel
        for (int i = 0; i < s.length; ++i)
            for (int stop = i; stop >= 0 && dp[stop] >= s[i][0]; --stop)
                dp[stop + 1] = Math.max(dp[stop + 1], dp[stop] + s[i][1]);
        
        for (int t = 0; t <= s.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }
	
	
	public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder()); // Picking the more gas from gas station
        long distCanCover= startFuel;
        int idx=0, res=0;
        while (true){
            while(idx<stations.length && distCanCover>=stations[idx][0]){
                pq.add(stations[idx][1]);
                idx++;
            }
            if (distCanCover>=target) return res;
            if (pq.isEmpty()) return -1;
            distCanCover+=pq.poll();
            res++;
        }
    }
}

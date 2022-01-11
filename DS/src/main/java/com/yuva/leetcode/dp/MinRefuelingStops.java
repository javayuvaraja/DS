package com.yuva.leetcode.dp;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 871. Minimum Number of Refueling Stops

A car travels from a starting position to a destination which is target miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array stations 
where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of 
the starting position and has fueli liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. 
It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, 
transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination. 
If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. 
If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

 

Example 1:

Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.
Example 2:

Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can not reach the target (or even the first gas station).
Example 3:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.
 * @author Yuvaraja Kanagarajan
 *
 */
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
        int station=0, stops=0;
        while (true){
            while(station < stations.length && 
            		distCanCover >= stations[station][0]){
                pq.add(stations[station][1]);
                station++;
            }
            if (distCanCover >= target) return stops;
            if (pq.isEmpty()) return -1;
            distCanCover+=pq.poll();
            stops++;
        }
    }
	
	public static void main(String[] args) {
		int target = 100; 
		int startFuel = 10; 
		
		int	stations[][] = new int[][]{{10,60},{20,30},{30,30},{60,40}};
		MinRefuelingStops obj = new MinRefuelingStops();
		obj.minRefuelStops1(target, startFuel, stations);
	}
}

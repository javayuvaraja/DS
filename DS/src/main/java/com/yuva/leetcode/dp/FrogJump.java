package com.yuva.leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {

	public static boolean canCross(int[] stones) {
        if (stones.length == 0) {
        	return true;
        }
        
        // Storing from this stone how much steps can able to jump
        // Choosing set for removing the duplicates
        HashMap<Integer, HashSet<Integer>> stoneMap = new HashMap<Integer, HashSet<Integer>>(stones.length);
        stoneMap.put(0, new HashSet<Integer>());
        stoneMap.get(0).add(1); // initially only one jump
        
        for (int i = 1; i < stones.length; i++) {
        	stoneMap.put(stones[i], new HashSet<Integer>() );
        }
        
        for (int i = 0; i < stones.length - 1; i++) {
        	int stone = stones[i];
        	for (int step : stoneMap.get(stone)) {
        		int reach = step + stone;
        		// if reached at the end return
        		if (reach == stones[stones.length - 1]) {
        			return true;
        		}
        		
        		// Checking whether stone is available with this jump
        		if (stoneMap.containsKey(reach)) {
        			HashSet<Integer> set = stoneMap.get(reach);
        			set.add(step);
        		    if (step - 1 > 0) set.add(step - 1);
        		    set.add(step + 1);
        		}
        	}
        }
        
        return false;
    } 
	
	public static void main(String[] args) {
		int stones[]= {0,1,3,5,6,8,12,17};
		System.out.println(canCross(stones));
	}
}

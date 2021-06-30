package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeUserVisitWebsite {
	class Pair {
		int time;
		String website;
		Pair (int time, String website) {
			this.time = time;
			this.website = website;
		}
	}
	public List<String> mostVisitedPattern(String[] usernames, int[] timestamps, String[] websites) {
		List<String> result = new ArrayList<String>();
		Map<String, List<Pair>> userVisitMap = new HashMap<>();
		int n = usernames.length;
		
		for (int i=0; i <n; i++) {
			userVisitMap.putIfAbsent(usernames[i], new ArrayList<AnalyzeUserVisitWebsite.Pair>());
			userVisitMap.get(usernames[i]).add(new Pair(timestamps[i], websites[i]));
		}
	}
}

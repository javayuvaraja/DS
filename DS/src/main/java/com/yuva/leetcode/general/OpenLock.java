package com.yuva.leetcode.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
	 public int openLock(String[] deadends, String target) {
		 Queue<String> queue = new LinkedList<>();
		 int level = 0;
		 Set<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));
	     Set<String> visited = new HashSet<>();
		 queue.add("0000");
		 visited.add("0000");
		 
		 while (queue.isEmpty()) {
			 int queueSize = queue.size();
			 while (queueSize>0) {
				 String currStr = queue.poll();
				 if(deadEndSet.contains(currStr)) {
					 queueSize--;
					 continue;
				 }
			 }
		 }
	     return level;
	 }
}



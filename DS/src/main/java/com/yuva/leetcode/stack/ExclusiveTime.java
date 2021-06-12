package com.yuva.leetcode.stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTime {

	public int[]exclusiveTime(int n, List<String> logs) {
		int result[]= new int[n];
		Stack<Integer> stack = new Stack<>();
		int prev=0;
		
		String[] log = logs.get(0).split(":");
		stack.push(Integer.parseInt(log[0]));
		prev = Integer.valueOf(log[2]);
		
		for (int i=1; i < logs.size(); i++) {
			log = logs.get(i).split(":");
			int process = Integer.valueOf(log[0]);
			int time = Integer.valueOf(log[2]);
			
			if (log[1].equals("start")) {  // another process came, so calculate the exclusive time of the prev process
				if (!stack.isEmpty()) {
					result[stack.peek()] += time - prev;
				}
				prev = time;
				stack.push(process); // pushing the process
			} else {  // process end
				result[stack.pop()] += time - prev +1; // exclusive
				prev = time+1;
			}
		}
		return result;
	}
}

package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumSemester {

	 public int minimumSemesters(int n, int[][] relations) {
		 int[] indegrees = new int[n+1];
		 Map<Integer, List<Integer>> adjMap = new HashMap<>();
		 for (int[] courses : relations) {
			 indegrees[courses[1]]++;
			 if (!adjMap.containsKey(courses[0])) {
				 adjMap.put(courses[0], new ArrayList<Integer>());
			 }
			 adjMap.get(courses[0]).add(courses[1]);
		 }
		 
		 Queue<Integer> queue = new LinkedList<>();
		 for (int i = 1; i <= n; i++) {
			 if (indegrees[i] == 0) {
				 queue.add(i);
			 }
		 }
		 
		 int semester = 0;
		 int completed =0;
		 while (!queue.isEmpty()) {
			 int size = queue.size();
			 for (int i=0; i < size;i++) {
				int course = queue.poll();
				completed++;
				List<Integer> dependencies = adjMap.get(course);
				if (dependencies != null && dependencies.size() > 0) {
					for (int dependency : dependencies) {
						indegrees[dependency]--;
						if (indegrees[dependency] == 0) {
							queue.add(dependency);
						}
					}
				}				
			}
			semester++;
		 }
		 return completed == n ? semester : -1;			
	 }
	 
	public static void main(String[] args) {
		int n= 3;
		int courses[][] = {{1,3},{2,3}};
		MinimumSemester obj = new MinimumSemester();
		obj.minimumSemesters(n, courses);
	}
}	

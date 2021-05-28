package com.yuva.leetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * @author Yuvaraja Kanagarajan
 *
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean [][]courses= new boolean[numCourses][numCourses] ;
		int []dependencies = new int[numCourses];
		
		for (int i=0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int preRequiste = prerequisites[i][1];
			
			if (!courses[preRequiste][course]) {
				dependencies[course]++;
			}
			courses[preRequiste][course] = true;
			
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i < dependencies.length; i++) {
			if (dependencies[i]==0) {
				queue.offer(i);
			}
		}
		int completedCourseCount = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			completedCourseCount++;
			for (int i=0; i < numCourses ; i++) {
				if (courses[course][i]) {
					dependencies[i]--;
					if (dependencies[i]==0) {
						queue.offer(i);
					}
				}
			}
		}
		
		return completedCourseCount == numCourses;
	}
	
	 public boolean canFinish1(int numCourses, int[][] prerequisites) {
	        List<Integer>[] neighbours = new LinkedList[numCourses];
	        Queue<Integer> queue = new LinkedList<>();
	        int[] indegree = new int[numCourses];
	        int count = 0;
	        for (int i = 0; i < numCourses; i++) {
	        	neighbours[i] = new LinkedList<>();
	        }
	        for (int[] pair : prerequisites) {
	            neighbours[pair[1]].add(pair[0]);
	            indegree[pair[0]]++;
	        }
	        for (int i = 0; i < indegree.length; i++)
	            if (indegree[i] == 0) queue.offer(i);
	        while (!queue.isEmpty()) {
	            int course = queue.poll();
	            count++;
	            for (int adj : neighbours[course])
	                if (--indegree[adj] == 0) queue.offer(adj);
	        }
	        return count == numCourses;
	    }
}

package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode 210. Course Schedule II
 * 
 * There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

 * @author Yuvaraja Kanagarajan
 *
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegrees = new int[numCourses];
		int[] result = new int[numCourses];
		int count = 0;
		Map<Integer, List<Integer>> adjMap = new HashMap<>();
		for (int[] courses : prerequisites) {
			indegrees[courses[0]]++;
			if (!adjMap.containsKey(courses[1])) {
				adjMap.put(courses[1], new ArrayList<Integer>());
			}
			adjMap.get(courses[1]).add(courses[0]);
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegrees[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int course = queue.poll();
			List<Integer> dependencies = adjMap.get(course);
			if (dependencies != null && dependencies.size() > 0) {
				for (int dependency : dependencies) {
					indegrees[dependency]--;
					if (indegrees[dependency] == 0) {
						queue.add(dependency);
					}
				}
			}
			result[count++] = course;
		}
		if (count != numCourses) {
			return new int[0];
		}
		return result;
	}
}

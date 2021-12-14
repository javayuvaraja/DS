package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchdeuleMiddle {

	public static void findAdvisoryMeetingCourse(String[][] preReqCourses) {

		Set<String> totalCourse = new HashSet<>();
		Map<String, Set<String>> map = new HashMap<>();

		for (String[] course : preReqCourses) {
			totalCourse.add(course[0]);
			totalCourse.add(course[1]);
			map.put(course[1], map.getOrDefault(course[1], new HashSet<>()));
			map.get(course[1]).add(course[0]);
		}

		Queue<String> queue = new LinkedList<>(); // indegree 0 queue
		List<String> order = new ArrayList<>(); // maintains the topological order

		for (String course : totalCourse) {
			if (!map.containsKey(course)) {
				queue.offer(course);
				order.add(course);
			}
		}

		while (!queue.isEmpty()) {
			String course = queue.poll();

			for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
				if (entry.getValue().contains(course)) {
					entry.getValue().remove(course);
					if (entry.getValue().size() == 0) {
						queue.offer(entry.getKey());
						order.add(entry.getKey());
					}
				}
			}

		}

		for (String s : order) {
			System.out.println(s); // this outputs complete order
		}
		System.out.println("Middle Elements");
		if (order.size() % 2 == 0) {
			System.out.println(order.get(order.size() / 2) + "  " + order.get(order.size() / 2 + 1));
		} else {
			System.out.println(order.get(order.size() / 2));
		}

	}
}

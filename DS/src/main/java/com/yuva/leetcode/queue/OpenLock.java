package com.yuva.leetcode.queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

	public int openLock(String[] deadends, String target) {

		Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add("0000");
		visited.add("0000");
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String pattern = queue.poll();
				if (deadSet.contains(pattern)) {
					continue;
				}
				if (target.equals(pattern)) {
					return level;
				}
				for (int j = 0; j < 4; j++) {
					char ch = pattern.charAt(j);
					String str1 = pattern.substring(0, j) + (ch == '9' ? 0 : ch - '0' + 1) + pattern.substring(j + 1);
					String str2 = pattern.substring(0, j) + (ch == '0' ? 9 : ch - '0' - 1) + pattern.substring(j + 1);

					if (!visited.contains(str1) && !deadSet.contains(str1)) {
						queue.offer(str1);
						visited.add(str1);
					}

					if (!visited.contains(str2) && !deadSet.contains(str2)) {
						queue.offer(str2);
						visited.add(str2);
					}
				}

			}
			level++;
		}
		return -1;
	}

	public static void main(String[] args) {
		String deadends[] = new String[] { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";
		OpenLock obj = new OpenLock();
		System.out.println(obj.openLock(deadends, target));
	}
}

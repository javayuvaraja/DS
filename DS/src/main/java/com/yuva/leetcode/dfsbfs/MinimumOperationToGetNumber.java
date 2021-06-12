package com.yuva.leetcode.dfsbfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**

Bloomberg Interview Question

Given an int n. You can use only 2 operations:

multiply by 2
integer division by 3 (e.g. 10 / 3 = 3)
Find the minimum number of steps required to generate n from 1.

Example 1:

Input: 10
Output: 6
Explanation: 1 * 2 * 2 * 2 * 2 / 3 * 2
6 steps required, as we have used 5 multiplications by 2, and one division by 3.
Example 2:

Input: 3
Output: 7
Explanation: 1 * 2 * 2 * 2 * 2 * 2 / 3 / 3
7 steps required, as we have used 5 multiplications by 2 and 2 divisions by 3.

 * @author Yuvaraja Kanagarajan
 *
 */
public class MinimumOperationToGetNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		System.out.println(getMinOperations(target));
	}

	private static int getMinOperations(int target) {
		if (target == 1)
			return 0;
		Set<Integer> visited = new HashSet<>();
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		visited.add(1);
		int level = 0;
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int curr = queue.remove();
				if (curr == target)
					return level;
				int multiply = curr * 2;
				int divide = curr / 3;
				if (visited.add(multiply))
					queue.add(multiply);

				if (visited.add(divide))
					queue.add(divide);
			}
		}
		return -1;
	}
}

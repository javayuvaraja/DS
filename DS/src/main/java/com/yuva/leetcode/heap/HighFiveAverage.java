package com.yuva.leetcode.heap;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 1086. High Five

Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents 
one score from a student with IDi, calculate each student's top five average.

Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents 
the student with IDj and their top five average. Sort result by IDj in increasing order.

A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 
using integer division.

Example 1:

Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
Example 2:

Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
Output: [[1,100],[7,100]]

 * @author Yuvaraja Kanagarajan
 *
 */
public class HighFiveAverage {
	public int[][] highFive(int[][] items) {
		TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

		for (int[] item : items) {
			int id = item[0];
			int score = item[1];
			if (map.containsKey(id)) {
				PriorityQueue<Integer> heap = map.get(id);
				heap.offer(score);
				if (heap.size() > 5) {
					heap.poll();
				}
			} else {
				PriorityQueue<Integer> heap = new PriorityQueue<>(5);
				heap.offer(score);
				map.put(id, heap);
			}
		}

		int[][] result = new int[map.size()][2];
		int index = 0;
		for (Integer id : map.keySet()) {
			PriorityQueue<Integer> heap = map.get(id);
			int size = heap.size();
			int sum = 0;
			while (!heap.isEmpty()) {
				sum += heap.poll();
			}
			int avg = sum / size;
			result[index][0] = id;
			result[index][1] = avg;

			index++;

		}

		return result;
	}
}
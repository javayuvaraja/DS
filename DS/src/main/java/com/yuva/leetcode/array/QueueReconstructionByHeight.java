package com.yuva.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
406. Queue Reconstruction by Height

You are given an array of people, people, which are the attributes of some people in a 
queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly 
ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. 
The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes 
of the jth person in the queue (queue[0] is the person at the front of the queue).

 

Example 1:
Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.

 * @author Yuvaraja Kanagarajan
 *
 */
public class QueueReconstructionByHeight {
	
	/**
	 * 
	 * Logic : Sort the array based on the height (reverse), if height are same then sort based on the front people (ascend)
	 *         Insert the element in the result based on the front people in front, so insert it the index.
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		List<int[]> list = new LinkedList<>();
		for (int[] p : people) {
			list.add(p[1], p);// p[1] is number of people in front, it is for index
		}
		return list.toArray(new int[list.size()][]);
	}
	
	public static void main(String[] args) {
		int [][]people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		QueueReconstructionByHeight obj = new QueueReconstructionByHeight();
		int [][]result = obj.reconstructQueue(people);
		
		for (int []person : result) {
			System.out.println(person[0] + " " + person[1]);
		}
	}
}

package com.yuva.leetcode.graph;

/**
 * https://leetcode.com/problems/number-of-provinces
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class NumberOfProvince {
	public int findCircleNum(int[][] M) {
		boolean visited[] = new boolean[M.length];  //visited[i] means if ith person is visited in this algorithm
		int count =0;
		for (int i = 0; i < M.length; i++) {
			if (!visited[i]) {
				dfs(M, i, visited);
				count++;
			}
		}
		return count;
	}
	
	private void dfs (int [][]M, int person, boolean []visited) {
		for (int other = 0; other < M.length; other ++) {
			if (M[person][other]==1 && !visited[other] ) {
				//We found an unvisited person in the current friend cycle 
				visited[other] =true;
				dfs(M, other, visited);//Start DFS on this new found person
			}
		}
	}
	
}

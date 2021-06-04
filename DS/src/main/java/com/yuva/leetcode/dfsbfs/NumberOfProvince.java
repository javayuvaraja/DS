package com.yuva.leetcode.dfsbfs;

/**
Leetcode 547. Number of Provinces

There are n cities. Some of them are connected, while some are not. 
If city a is connected directly with city b, and city b is connected directly with city c, 
then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city 
and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class NumberOfProvince {

	public int findCircleNum(int[][] isConnected) {
		boolean[] visited = new boolean[isConnected.length]; // visited[i] means if ith person is visited in this
																// algorithm
		int count = 0;
		for (int i = 0; i < isConnected.length; i++) {
			if (!visited[i]) {
				dfs(isConnected, visited, i);
				count++;
			}
		}
		return count;
	}

	private void dfs(int[][] graph, boolean[] visited, int person) {
		for (int other = 0; other < graph.length; other++) {
			if (graph[person][other] == 1 && !visited[other]) {
				// We found an unvisited person in the current friend cycle
				visited[other] = true;
				dfs(graph, visited, other); // Start DFS on this new found person
			}
		}
	}

	public int findCircleNum1(int[][] M) {
		int m = M.length, cnt = 0;
		int[] root = new int[m];
		// creating the self set
		for (int i = 0; i < m; i++) {
			root[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				if (M[i][j] == 1) {
					unionFind(root, i, j);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (i == root[i]) { // checking only parent of set
				cnt++;
			}
		}
		return cnt;
	}

	void unionFind(int[] root, int v1, int v2) {
		while (root[v1] != v1) {
			v1 = root[v1]; // find v1's root
		}
		while (root[v2] != v2) {
			v2 = root[v2]; // find v2's root
		}
		if (root[v1] != root[v2]) {
			root[v2] = v1; // unite the 2 subtrees
		}
	}
}

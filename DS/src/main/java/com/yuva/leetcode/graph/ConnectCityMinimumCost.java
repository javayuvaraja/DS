package com.yuva.leetcode.graph;

import java.util.Arrays;


public class ConnectCityMinimumCost {

	int[] parent;
	int notVisited;

	private void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px != py) {
			parent[px] = py;
			notVisited--;
		}
	}

	private int find(int x) {
		if (parent[x] == x) {
			return parent[x];
		}
		parent[x] = find(parent[x]); // path compression
		return parent[x];
	}

	/**
		Sort edges to non-decreasing order
		Pick the smallest edge that does not form a cycle
		Repeat until MST is formed and every node is connected.
	 * @param N
	 * @param connections
	 * @return
	 */
	
	public int minimumCost(int N, int[][] connections) {
		parent = new int[N + 1];
		notVisited = N;
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		Arrays.sort(connections, (a, b) -> (a[2] - b[2]));  // Sorting by edge value.

		int res = 0;

		for (int[] c : connections) {
			int x = c[0], y = c[1];
			if (find(x) != find(y)) {
				res += c[2];
				union(x, y);
			}
		}

		return notVisited == 1 ? res : -1;
	}
}

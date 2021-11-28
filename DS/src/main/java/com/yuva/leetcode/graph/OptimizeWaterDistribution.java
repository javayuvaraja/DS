package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing), 
or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes,
 where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together 
 using a pipe. Connections are bidirectional.

Return the minimum total cost to supply water to all houses.

nput: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation: 
The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses 
to it with cost 2 so the total cost is 3.
 * @author Yuvaraja Kanagarajan
 *
 */
public class OptimizeWaterDistribution {

	/**
	 * Logic :
	  
1. To find the answer to this question we have to have a connected graph (to connect all the houses together).
2. we're treating making a well in a house as piping it to a made-up house 0
3. We sort, so if the cost of making a well is lower than connecting it to another house, 
   we make the well, or vice versa. Even by making the well, we're connecting it to the graph (Through house0)!
4. We're going to find if these two houses(x and y) are connected, therefore a part of the final connected graph. 
   If not (if (x != y)), then connect them. Union-find helps find their traces. 
   Being connected means through some house(s) we can find a path between them. 
   Being connected is the basis of having a connected graph!
   
   
	 * @param n
	 * @param wells
	 * @param pipes
	 * @return
	 */
	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		UnionFind uf = new UnionFind(n + 1);

		// Adding the wells to the edge list.
		// Cost from hidden well, assumed zero.
		List<int[]> edges = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			edges.add(new int[] { 0, i + 1, wells[i] });
		}

		for (int[] pipe : pipes) {
			edges.add(pipe);
		}

		// sort the edges based on the weight

		Collections.sort(edges, (a, b) -> a[2] - b[2]);

		int result = 0;

		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];

			if (uf.findSet(x) == uf.findSet(y)) { // already connected so no additional cost
				continue;
			}

			uf.union(x, y);
			result += edge[2];
		}
		return result;
	}

	class UnionFind {
		int[] parent;

		UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public int findSet(int x) {
			if (x == parent[x]) {
				return x;
			}

			parent[x] = findSet(parent[x]);
			return parent[x];
		}

		public void union(int a, int b) {
			int parentA = findSet(a);
			int parentB = findSet(b);
			if (parentA == parentB) {
				return;
			}

			parent[parentA] = parentB;
		}

	}
}

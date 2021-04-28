package com.yuva.leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 *
 *   0          3
     |          |
     1 --- 2    4
 * 
 * @author Yuvaraja Kanagarajan
 *
 * Logic : Union Find algorithm
 * 
 * 1. First create the self pointing union (island)
 * 2. Iterate all the edges
 * 3. If the parent of both is not the same then point one of the vertice as parent to another
 * 
 * Find root logic
 * 1. Iterate while parent is not the same as the vertice
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ConnectedComponentDSFS {

	public int countComponents(int n, int [][]edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		buildGraph(graph, n, edges);
		
		boolean []visited = new boolean[n];
		int count = 0;
		for (int i =0; i < n; i++) {
			if (!visited[i]) {
				count++;
				dfs(graph, i, visited);
			}
		}
		
		return count;
	}
	
	private void dfs(Map<Integer, List<Integer>> graph, int vertice, boolean []visited) {
		visited[vertice] = true;
		
		for (Integer i : graph.get(vertice)) {
			if (!visited[i]) {
				dfs(graph, i, visited);
			}
		}
	}
	
	public void buildGraph(Map<Integer, List<Integer>> graph, int n, int[][] edges) {
		for (int i=0; i < n; i++) {
			graph.putIfAbsent(i, new LinkedList<Integer>());
		}

		// Building the adjacency list graph
		for (int i=0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}
	}
}

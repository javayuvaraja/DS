package com.yuva.leetcode.graph;

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
 */
public class ConnectedComponent {

	public int countComponents(int n, int[][]edges) {
		int count = n;
		int root[] = new int[n];
		
		for (int i=0; i < n; i++) {
			root[i] =i;
		}
		
		for (int i =0; i < edges.length; i++) {
			int source = edges[i][0];
			int dest = edges[i][1];
			
			int sourceParent = getParent(source, root); 
			int destParent = getParent(dest, root);
			
			if (sourceParent!=destParent) {
				count--;
				root[sourceParent] =  destParent;
			}
		}
		return count;
 	}
	
	public int getParent (int vertice, int []root) {
		while (root[vertice] != vertice) {
			root[vertice] = root[root[vertice]];
			vertice = root[vertice];
		}
		return vertice;
	}
	
	public static void main(String[] args) {
		int edges[][]= {{0, 1}, {1, 2},  {3, 4}};
		int n =5;
		ConnectedComponent connectedComponent = new ConnectedComponent();
		int count = connectedComponent.countComponents(n, edges);
		System.out.println(count);
	}
	
}

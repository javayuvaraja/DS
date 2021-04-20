package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ConnectedComponentBFS {

	public int countComponents(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : connections) {
            List<Integer> neighbors1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> neighbors2 = graph.getOrDefault(edge[1], new ArrayList<>());
            neighbors1.add(edge[1]);
            neighbors2.add(edge[0]);
            graph.put(edge[0], neighbors1);
            graph.put(edge[1], neighbors2);
        }
        
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
        	components += bfs(node, graph, visited);
        }
        return components; // Need (components-1) cables to connect components together
    }
    int bfs(int src, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (visited[src]) {
        	return 0;
        }
        visited[src] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        return 1;
    }
    
    public static void main(String[] args) {
		int edges[][]= {{0, 1}, {1, 2},  {3, 4}};
		int n =5;
		ConnectedComponentBFS connectedComponent = new ConnectedComponentBFS();
		int count = connectedComponent.countComponents(n, edges);
		System.out.println(count);
	}
}

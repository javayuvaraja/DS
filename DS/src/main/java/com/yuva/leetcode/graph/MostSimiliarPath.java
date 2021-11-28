package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MostSimiliarPath {

	public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
		Map<Integer, List<Integer>> graph = buildGraph(n, roads);

        int targetPathLen = targetPath.length;
        int[][] result = new int[targetPathLen][n];
        int[][] prev = new int[targetPathLen][n];
        for (int[] row : result) {
            Arrays.fill(row, targetPathLen);
        }

        for (int vertex = 0; vertex < n; vertex++) {
            result[0][vertex] = !names[vertex].equals(targetPath[0]) ? 1 : 0;
        }

        for (int i = 1; i < targetPathLen; i++) {
            for (int vertex = 0; vertex < n; vertex++) {
                for (int u : graph.get(vertex)) {
                    if (result[i - 1][u] < result[i][vertex]) {
                        result[i][vertex] = result[i - 1][u];
                        prev[i][vertex] = u;
                    }
                }
                result[i][vertex] += (!names[vertex].equals(targetPath[i]) ? 1 : 0);
            }
        }
        
        List<Integer> path = new LinkedList<>();
        path.add(0);
        int minDist = targetPathLen;
        
        for (int v = 0; v < n; v++) {
            if (result[targetPathLen - 1][v] < minDist) {
                minDist = result[targetPathLen - 1][v];
                path.set(0, v);
            }
        }

        for (int i = targetPathLen - 1; i > 0; i--) {
            path.add(0, prev[i][path.get(0)]);
        }
        return path;
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int[] road : roads) {
        	graph.get(road[0]).add(road[1]);
        	graph.get(road[1]).add(road[0]);
        	
        }
        return graph;
    }
    
    public static void main(String[] args) {
    	int n = 5;
    	int roads[][] = {{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}};
    	String names[] = {"ATL","PEK","LAX","DXB","HND"};
    	String targetPath[] = {"ATL","DXB","HND","LAX"};
		MostSimiliarPath obj = new MostSimiliarPath();
		obj.mostSimilar(5, roads, names, targetPath).forEach(e-> System.out.print(e+ " "));;
	}
}

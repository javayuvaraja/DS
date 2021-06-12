package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
797. All Paths From Source to Target

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, 
find all possible paths from node 0 to node n - 1, and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class AllPathsFromSourceToTarget {

	/*
	 * Logic : 1.Get the start and add to the queue
	 *   2. Iterate all the neighbor and add the path to the existing list.
	 */
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(0));
		
		int target = graph.length-1;
		while (!queue.isEmpty()) {
			List<Integer> currPath = queue.poll();
			int lastVisistedNode = currPath.get(currPath.size()-1);
			if (lastVisistedNode == target) {
				result.add(new ArrayList<Integer>(currPath)); 
			} else {
				int []connections= graph[lastVisistedNode];
				for (int neighbor: connections) {
					List<Integer> path = new ArrayList<>(currPath);
					path.add(neighbor);
					queue.add(path);
				}
			}
		}
		return result;
    }
	
	
	public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currList = new ArrayList<>();
		int start = 0;
		int target = graph.length-1;
		currList.add(start);
		dfs(result, start, target, currList, graph);
		return result;
	}
	
	private void dfs (List<List<Integer>> result,  int start, int target, 
			List<Integer> currList, int[][]graph) {
		// if no neighbors
		if (graph[start].length == 0 || start == target) {
			if (start == target) {
				result.add(new ArrayList<Integer>(currList));
			}
			return;
		}
		
		for (int neighbor: graph[start]) {
			currList.add(neighbor);
			dfs(result, neighbor, target, currList, graph);
			currList.remove(currList.size()-1);
		}
	}
}

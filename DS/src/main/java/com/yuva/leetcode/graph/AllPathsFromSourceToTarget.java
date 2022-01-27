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
	
	/**
	 * public void printAllPaths(int s, int d)
    {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        // add source to path[]
        pathList.add(s);

        // Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList)
    {

        if (u.equals(d)) {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            return;
        }

        // Mark the current node
        isVisited[u] = true;

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }
	 */
	
	private void dfs(int[][] graph, int source, int target, boolean visited[],
			List<Integer> curr, List<List<Integer>> answer) {
		if (source == target) {
			answer.add(new ArrayList<>(curr));
			return;
		}
		visited[source] = true;

		for (int child : graph[source]) {
			if (!visited[source]) {
				curr.add(child);
				dfs(graph, child, target, visited, curr, answer);
				curr.remove(curr.size() - 1);
			}
		}
	}
}

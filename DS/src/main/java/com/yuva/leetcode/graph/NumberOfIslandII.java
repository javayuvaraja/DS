package com.yuva.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 305. Number of Islands II

You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. 
Initially, all the cells of grid are water cells (i.e., all the cells are 0's).

We may perform an add land operation which turns the water at position into a land. 
You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.

Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

 

Example 1:


Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1,1,2,3]
Explanation:
Initially, the 2d grid is filled with water.
- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
 * @author Yuvaraja Kanagarajan
 *
 */
public class NumberOfIslandII {

	int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	/*
	 * Logic : This is a basic union-find problem. Given a graph with points being added, we can at least solve:
			   The idea is simple. To represent a list of islands, we use trees. i.e., a list of roots. 
			   This helps us find the identifier of an island faster. 
			   If roots[c] = p means the parent of node c is p, we can climb up the parent chain to find out the identifier of an island,
			    i.e., which island this point belongs to:

				Do root[root[roots[c]]]... until root[c] == c;
				To transform the two dimension problem into the classic UF, perform a linear mapping:

		int id = n * x + y;
		Initially assume every cell are in non-island set {-1}. When point A is added, we create a new root, i.e., a new island. 
		Then, check if any of its 4 neighbors belong to the same island. If not, union the neighbor by setting the root to be the same. 
		Remember to skip non-island cells.
	 */
	
	public List<Integer> numIslands2(int rowLen, int colLen, int[][] positions) {
	    List<Integer> result = new ArrayList<>();
	    if(rowLen <= 0 || colLen <= 0) return result;

	    int count = 0;                      // number of islands
	    int[] roots = new int[rowLen * colLen];       // one island = one tree
	    Arrays.fill(roots, -1);            

	    for(int[] p : positions) {
	        int root = colLen * p[0] + p[1];     // assume new point is isolated island
	        roots[root] = root;             // add new island
	        count++;

	        for(int[] dir : dirs) {
	            int newRow = p[0] + dir[0]; 
	            int newCol = p[1] + dir[1];
	            int neighbor = colLen * newRow + newCol;
	            if(newRow < 0 || newRow >= rowLen || 
	            		newCol < 0 || newCol >= colLen || 
	            		roots[neighbor] == -1) continue;
	            
	            int rootNb = findIsland(roots, neighbor);
	            
	            if(root != rootNb) {        // if neighbor is in another island
	                roots[root] = rootNb;   // union two islands 
	                root = rootNb;          // current tree root = joined tree root
	                count--;               
	            }
	        }

	        result.add(count);
	    }
	    return result;
	}

	public int findIsland(int[] roots, int id) {
	    while(id != roots[id]) id = roots[id];
	    return id;
	}
}

package com.yuva.leetcode.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstaclesElimination {

	/**
	 * Logic :
	  
	 1. we are trying to find the shortest path, use BFS here to exit immediately when a path reaches the bottom right most cell.
	 2. Use a set to keep track of already visited paths. We only need to keep track of the row, column, and the eliminate obstacle usage count. 
	 3. We don't need to keep track of the steps because remember we are using BFS for the shortest path. That means there is no value storing a 4th piece of the data, the current steps. This will reduce the amount of repeat work.

m = rows
n = columns
k = allowed elimination usages

	 * @param grid
	 * @param k
	 * @return
	 */
	public int shortestPath(int[][] grid, int k) {
        int step = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] visited = new int[rowLen][colLen]; // min obstacles elimination from (0,0) to (x, y)
        for (int i = 0; i < rowLen; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == rowLen - 1 && cur[1] == colLen - 1) { // reached the bottom right cell
                    return step;
                }
                for (int[] dir : dirs) {
                    int newRow = dir[0] + cur[0];
                    int newCol = dir[1] + cur[1];
                    if (newRow < 0 || newRow >= rowLen || newCol < 0 || newCol >= colLen) {
                        continue;
                    }
                    int obstacleCount = grid[newRow][newCol] + cur[2];
                    
                    if (obstacleCount >= visited[newRow][newCol] || obstacleCount > k) {
                        continue;
                    }
                    
                    visited[newRow][newCol] = obstacleCount;
                    q.offer(new int[]{newRow, newCol, obstacleCount});
                }
            }
            ++step;
        }
        return -1;  
    }
}

package com.yuva.leetcode.heap;

import java.util.PriorityQueue;

/**
778. Swim in Rising Water

On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. 
You can swim from a square to another 4-directionally adjacent square if and only if the elevation of 
both squares individually are at most t. You can swim infinite distance in zero time. 
Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

 * @author Yuvaraja Kanagarajan
 *
 */
public class SwimInWater {

	int row =0;
	int col = 1;
	int val = 2;
	
	// BFS With Priority Queue
	public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[val] - b[val]);
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        visited[0][0] = true;
        pq.offer(new int[]{0, 0, grid[0][0]});
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int currRow = info[row];
            int currCol = info[col];
            int max = info[val];
            for(int[] dir : dirs){
                int newRow = dir[0] + currRow;
                int newCol = dir[1] + currCol;
                
                if(newRow < 0 || newRow >= n || 
                   newCol < 0 || newCol >= n)  {
                	continue;
                }
                
                if(!visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    int newmax = Math.max(max, grid[newRow][newCol]); // from curr position to next position how long have to wait 
                    if(newRow == n - 1 && newCol == n - 1)  { // reached destination
                    	return newmax;
                    }
                    pq.offer(new int[]{newRow, newCol, newmax}); // nearest path
                }
            }
        }
        
        return 0;
    }
	
	public static void main(String[] args) {
		int grid[][] = {
				  			{0,1,2,3,4},
				  			{24,23,22,21,5},
				  			{12,13,14,15,16},
				  			{11,17,18,19,20},
				  			{10,9,8,7,6}
				  		};
		
		SwimInWater obj = new SwimInWater();
		obj.swimInWater(grid);
	}
}

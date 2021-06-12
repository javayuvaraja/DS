package com.yuva.leetcode.dfsbfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 827. Making A Large Island

You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.
An island is a 4-directionally connected group of 1s.

Example 1:
Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4. 
 * @author Yuvaraja Kanagarajan
 *
 */
public class LargestIsland {

	public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>(); //Key: color, Val: size of island painted of that color
        map.put(0, 0); //We won't paint island 0, hence make its size 0, we will use this value later   
        int n = grid.length; 
        int colorIndex = 2; //0 and 1 is already used in grid, hence we start colorIndex from 2 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, colorIndex);
                    map.put(colorIndex, size);
                    colorIndex++;
                }
            }
        }
    
        //If there is no island 0 from grid, res should be the size of islands of first color
        //If there is no island 1 from grid, res should be 0 
        int res = map.getOrDefault(2, 0); 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    //We use a set to avoid repeatly adding islands with the same color
                    Set<Integer> set = new HashSet<>();
                    //If current island is at the boundary, we add 0 to the set, whose value is 0 in the map
                    set.add(i > 0 ? grid[i - 1][j] : 0);
                    set.add(i < n - 1 ? grid[i + 1][j] : 0);
                    set.add(j > 0 ? grid[i][j - 1] : 0);
                    set.add(j < n - 1 ? grid[i][j + 1] : 0);
                    
                    int newSize = 1; //We need to count current island as well, hence we init newSize with 1
                    for (int color : set) {
                    	newSize += map.get(color);
                    }
                    res = Math.max(res, newSize);
                }
            }
        }
        return res;
    }
    
    //Helper method to paint current island and all its connected neighbors
    //Return the size of all painted islands at the end
    private int dfs(int[][] grid, int row, int col, int color) {
        if (row < 0 || col < 0 
        		|| row >= grid.length || col >= grid[0].length 
        		|| grid[row][col] != 1) {
        	return 0;
        }
        
        grid[row][col] = color;
        
        return 1 + dfs(grid, row + 1, col, color) + 
        		   dfs(grid, row - 1, col, color) + 
        		   dfs(grid, row, col + 1, color) + 
        		   dfs(grid, row, col - 1, color);
    }
}

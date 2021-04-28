package com.yuva.leetcode.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
https://leetcode.com/problems/walls-and-gates/ 

Given a maze with cells being: gates, walls or empty spaces.

Example:

Input:
_ W G _
_ _ _ W
_ W _ W
G W _ _

Output:
3 W G 1
2 2 1 W
1 W 2 W
G W 3 4

Fill the empty spaces with the number of steps to the closest gate. Allowed steps: UP, RIGHT, LEFT & DOWN

 * @author Yuvaraja Kanagarajan
 *
 */
public class GatesAndWalls {

	/**
	 * Logic : 1. Find all the gates and store it to queue.
	 * Then use BFS to populate the next level empty spaces
	 */
	static char[][] solve(char[][] grid){
	    int rowLen= grid.length;
	    int colLen = grid[0].length;

	    Queue<int[]> q = new LinkedList<>();
	    
	    // Store all the gate points to the queue
	    for(int i=0;i<rowLen;i++){
	        for(int j=0;j<colLen;j++){
	            if(grid[i][j]=='G')
	                q.add(new int[]{i,j});
	        }
	    }
	    
	    int level=0;
	    int []dirX = {0,0,1,-1};
		int []dirY = {1,-1,0,0};
		
	    while(!q.isEmpty()){

	        level++;

	        int n = q.size();

	        for(int i=0;i<n;i++){

	            int [] point = q.poll();

	            for(int j=0;j<dirX.length-1;j++){

	            	int newRow = point[0] + dirX[j];
	                int newCol = point[1] + dirX[j];

	                if(newRow>=0 && newCol>=0 && newRow < rowLen && newCol < colLen){

	                    if(grid[newRow][newCol]=='_'){

	                        grid[newRow][newCol] =(char) (48+level);
	                        q.add(new int[]{newRow,newCol});
	                    }

	                }
	            }
	        }
	    }
	    return grid;
	}
}

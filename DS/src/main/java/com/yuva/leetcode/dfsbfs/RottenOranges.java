package com.yuva.leetcode.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    int dirs[][] = new int [][] {{-1,0}, {0, 1}, {0, -1}, {1, 0}}; 
    public int orangesRotting(int[][] grid) {
        Queue<Position> queue = new LinkedList<>();
        // adding the rotten oranges to the queue
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j]==2) {
                    queue.offer (new Position(i, j));
                }
            }
        }
        
        int cycleCount=0;
        while (!queue.isEmpty()) {
            int size =  queue.size();
            boolean isRotten = false;
            System.out.println("size : " + size + " count : "  +cycleCount);
            for (int i=0; i < size; i++) {
            	Position currPosition = queue.poll();
            	int row = currPosition.row;
                int col = currPosition.col;
                for (int dir[] : dirs) {
                    int currRow = row+ dir[0];
                    int currCol = col+ dir[1];
                    if (currRow>=0 && currRow < grid.length &&
                        currCol>=0 && currCol < grid[0].length &&
                        grid[currRow][currCol]==1) {
                        System.out.println("Rotening :" + currRow + ", "+currCol);
                        grid[currRow][currCol]=2;
                        queue.offer (new Position(currRow, currCol));    
                        isRotten = true;
                    }
                }
            }
            if (isRotten) {
            	cycleCount++;
            }
        }
        
        // check any fresh oranges are there        
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    return -1;
                }
            }
        }
        
        return cycleCount;
    }
    
    
    class Position {
        int row;
        int col;
        Position (int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public String toString() {
        	return row+","+col;
        }
    }
    
    public static void main(String[] args) {
    	int [][]grid = {{2,1,1},{1,1,0},{0,1,1}};
    	RottenOranges obj = new RottenOranges();
    	System.out.println(obj.orangesRotting(grid));
	}
}

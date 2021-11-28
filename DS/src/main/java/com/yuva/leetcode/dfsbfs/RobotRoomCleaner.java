package com.yuva.leetcode.dfsbfs;

import java.util.HashSet;
import java.util.Set;
/**
489. Robot Room Cleaner

Given a robot cleaner in a room modeled as a grid.


Each cell in the grid can be empty or blocked.

The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

Design an algorithm to clean the entire room using only the 4 given APIs shown below.

interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}
Example:

Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Notes:
 * @author Yuvaraja Kanagarajan
 *
 */
public class RobotRoomCleaner {
	
	private static final int[][] DIRS = {{-1, 0}, // up (prevRow)
												{0, 1}, // right (RightCol)
												{1, 0}, // left
												{0, -1}}; // down

		public void cleanRoom(Robot robot) { 
			clean(robot, 0, 0, 0, new HashSet<>());
		}

		private void clean(Robot robot, int x, int y, int curDirection, Set<String> cleaned) {
			robot.clean();
			cleaned.add(x + " " + y);

			for (int i = 0; i < 4; i++) {
				int nx = x + DIRS[curDirection][0];
				int ny = y + DIRS[curDirection][1];
				if (!cleaned.contains(nx + " " + ny) && robot.move()) {
					clean(robot, nx, ny, curDirection, cleaned);
					goBack(robot);
				}
				robot.turnRight();
				curDirection = (curDirection + 1) % 4;
			}

		}

		private void goBack(Robot robot) {
			robot.turnRight();
			robot.turnRight();
			robot.move();
			robot.turnRight();
			robot.turnRight();
		}

}

interface Robot {
	// Returns true if the cell in front is open and robot moves into the cell.
	// Returns false if the cell in front is blocked and robot stays in the current
	// cell.
	public boolean move();

	// Robot will stay in the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	public void turnLeft();

	public void turnRight();

	// Clean the current cell.
	public void clean();
}
	 

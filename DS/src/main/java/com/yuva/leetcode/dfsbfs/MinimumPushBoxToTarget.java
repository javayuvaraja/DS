package com.yuva.leetcode.dfsbfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumPushBoxToTarget {
	int[][] moves = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	int boxX = 0, boxY=1, storeKeeperX = 2, storeKeeperY=3;
	int X=0, Y=1;
	public int minPushBox(char[][] grid) {
		int[] box = null, target = null, storekeeper = null;
		int n = grid.length, m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'B') {
					box = new int[] { i, j };
				} else if (grid[i][j] == 'T') {
					target = new int[] { i, j };
				} else if (grid[i][j] == 'S') {
					storekeeper = new int[] { i, j };
				}
			}
		}
	
		Queue<String> q = new LinkedList<>(); // stores the position of box and store keeper
		Map<String, Integer> distanceMap = new HashMap<>();
		String start = encode(box[0], box[1], storekeeper[0], storekeeper[1]);
		distanceMap.put(start, 0);
		q.offer(start);
		int result = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			String currItem = q.poll();
			int[] locationArr = decode(currItem);
			if (distanceMap.get(currItem) >= result)
				continue;
			if (locationArr[boxX] == target[0] && locationArr[boxY] == target[1]) {
				result = Math.min(result, distanceMap.get(currItem));
				continue;
			}
			int[] boxLocation = new int[] { locationArr[boxX], locationArr[boxY] };
			int[] storeKeeperLocation = new int[] { locationArr[storeKeeperX], locationArr[storeKeeperY] };
			// move the storekeeper for 1 step
			for (int[] move : moves) {
				int nsx = storeKeeperLocation[X] + move[X];
				int nsy = storeKeeperLocation[Y] + move[Y];
				if (nsx < 0 || nsx >= n || nsy < 0 || nsy >= m || grid[nsx][nsy] == '#')
					continue;
				
				// if it meet the box, then the box move in the same direction
				if (nsx == boxLocation[X] && nsy == boxLocation[Y]) {
					int nbx = boxLocation[0] + move[0];
					int nby = boxLocation[1] + move[1];
					if (nbx < 0 || nbx >= n || nby < 0 || nby >= m || grid[nbx][nby] == '#')
						continue;
					//int v = encode(nbx, nby, nsx, nsy);
					String pos = encode(nbx, nby, nsx, nsy);
					if (distanceMap.containsKey(pos) && distanceMap.get(pos) <= distanceMap.get(currItem) + 1)
						continue;
					distanceMap.put(pos, distanceMap.get(currItem) + 1);
					q.offer(pos);
				} else { // if the storekeeper doesn't meet the box, the position of the box do not
							// change
					//int v = encode(b[0], b[1], nsx, nsy);
					String pos = encode(boxLocation[0], boxLocation[1], nsx, nsy);
					if (distanceMap.containsKey(pos) && distanceMap.get(pos) <= distanceMap.get(currItem))
						continue;
					distanceMap.put(pos, distanceMap.get(currItem));
					q.offer(pos);
				}
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	String encode(int bx, int by, int sx, int sy) {
		return bx+"-"+by+"-"+sx+"-"+sy;
	}
	
	int []decode(String str) {
		int[] ret = new int[4];
		String temp[] = str.split("-");
		ret[0] = Integer.parseInt(temp[0]);
		ret[1]= Integer.parseInt(temp[1]);
		ret[2] = Integer.parseInt(temp[2]);
		ret[3] = Integer.parseInt(temp[3]);
		return ret;
		
	}
	
	public static void main(String[] args) {
		char [][]grid ={{'#','#','#','#','#','#'},
            {'#','T','#','#','#','#'},
            {'#','.','.','B','.','#'},
            {'#','.','#','#','.','#'},
            {'#','.','.','.','S','#'},
            {'#','#','#','#','#','#'}} ;
		MinimumPushBoxToTarget obj = new MinimumPushBoxToTarget();
		obj.minPushBox(grid);
	}
}

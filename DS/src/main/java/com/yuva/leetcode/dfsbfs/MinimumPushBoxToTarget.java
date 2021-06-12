package com.yuva.leetcode.dfsbfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumPushBoxToTarget {
	int[][] moves = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

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
		Map<String, Integer> dis = new HashMap<>();
		String start = encode(box[0], box[1], storekeeper[0], storekeeper[1]);
		dis.put(start, 0);
		q.offer(start);
		int result = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			String currPos = q.poll();
			int[] du = decode(currPos);
			if (dis.get(currPos) >= result)
				continue;
			if (du[0] == target[0] && du[1] == target[1]) {
				result = Math.min(result, dis.get(currPos));
				continue;
			}
			int[] boxLocation = new int[] { du[0], du[1] };
			int[] storeKeeperLocation = new int[] { du[2], du[3] };
			// move the storekeeper for 1 step
			for (int[] move : moves) {
				int nsx = storeKeeperLocation[0] + move[0];
				int nsy = storeKeeperLocation[1] + move[1];
				if (nsx < 0 || nsx >= n || nsy < 0 || nsy >= m || grid[nsx][nsy] == '#')
					continue;
				// if it meet the box, then the box move in the same direction
				if (nsx == boxLocation[0] && nsy == boxLocation[1]) {
					int nbx = boxLocation[0] + move[0];
					int nby = boxLocation[1] + move[1];
					if (nbx < 0 || nbx >= n || nby < 0 || nby >= m || grid[nbx][nby] == '#')
						continue;
					//int v = encode(nbx, nby, nsx, nsy);
					String pos = encode(nbx, nby, nsx, nsy);
					if (dis.containsKey(pos) && dis.get(pos) <= dis.get(currPos) + 1)
						continue;
					dis.put(pos, dis.get(currPos) + 1);
					q.offer(pos);
				} else { // if the storekeeper doesn't meet the box, the position of the box do not
							// change
					//int v = encode(b[0], b[1], nsx, nsy);
					String pos = encode(boxLocation[0], boxLocation[1], nsx, nsy);
					if (dis.containsKey(pos) && dis.get(pos) <= dis.get(currPos))
						continue;
					dis.put(pos, dis.get(currPos));
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

package com.yuva.leetcode.graph;

/**
 * https://leetcode.com/problems/number-of-provinces
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class NumberOfProvince {
	public int findCircleNum(int[][] M) {
		boolean visited[] = new boolean[M.length];  //visited[i] means if ith person is visited in this algorithm
		int count =0;
		for (int i = 0; i < M.length; i++) {
			if (!visited[i]) {
				dfs(M, i, visited);
				count++;
			}
		}
		return count;
	}
	
	private void dfs (int [][]M, int person, boolean []visited) {
		for (int other = 0; other < M.length; other ++) {
			if (M[person][other]==1 && !visited[other] ) {
				//We found an unvisited person in the current friend cycle 
				visited[other] =true;
				dfs(M, other, visited);//Start DFS on this new found person
			}
		}
	}
	
	public int findCircleNum1(int[][] M) {
        int n = M.length;
        DisjointSet uf = new DisjointSet();
        for (int i=0; i < n; i++) {
        	uf.makeSet(i);;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count;
    }
	
	public static void main(String[] args) {
		/*
		 * int arr[][]= new int[][]{ {1,0,0}, {0,1,0}, {0,0,1} };
		 */
		int arr[][] = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
		NumberOfProvince obj =new NumberOfProvince();
		System.out.println(obj.findCircleNum1(arr));
	}
	
}

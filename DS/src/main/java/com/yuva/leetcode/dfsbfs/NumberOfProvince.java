package com.yuva.leetcode.dfsbfs;

public class NumberOfProvince {

	  public int findCircleNum(int[][] isConnected) {
	        boolean[] visited = new boolean[isConnected.length]; //visited[i] means if ith person is visited in this algorithm
	        int count = 0;
	        for(int i = 0; i < isConnected.length; i++) {
	            if(!visited[i]) {
	                dfs(isConnected, visited, i);
	                count++;
	            }
	        }
	        return count;
	    }
	    private void dfs(int[][] M, boolean[] visited, int person) {
	        for(int other = 0; other < M.length; other++) {
	            if(M[person][other] == 1 && !visited[other]) {
	                //We found an unvisited person in the current friend cycle 
	                visited[other] = true;
	                dfs(M, visited, other); //Start DFS on this new found person
	            }
	        }
	    }
	    
	    public int findCircleNum1(int[][] M) {
	        int m = M.length, cnt = 0;
	        int[] root = new int[m]; 
	        // creating the self set
	        for (int i = 0; i < m; i++) {
	        	root[i] = i; 
	        }
	        for (int i = 0; i < m; i++)  {
	            for (int j = i + 1; j < m; j++) {
	                if (M[i][j] == 1) {
	                	unionFind(root, i, j);
	                }
	    		}
			}	

	        for (int i = 0; i < m; i++) {
	            if (i == root[i])  {
	            	cnt++;
	            }
	        }
	        return cnt;
	    }
	    
	    void unionFind (int[] root, int v1, int v2) {
	        while (root[v1] != v1) {
	        	v1 = root[v1]; //find v1's root
	        }
	        while (root[v2] != v2) {
	        	v2 = root[v2]; //find v2's root
	        }
	        if (root[v1] != root[v2]) {
	        	root[v2] = v1; //unite the 2 subtrees 
	        }
	    }
}

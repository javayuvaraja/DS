package com.yuva.leetcode.general;

public class ZumaGame {
	
	int MAXCOUNT = 6;  
	public int findMinStep(String board, String hand) {
		int []freq = new int[26];
		for (Character ch : hand.toCharArray()) {
			freq[ch-'A']++;
		}
		int rs = dfs(board + "#", freq);  // append a "#" to avoid special process 
										//while j==board.length, make the code shorter.
	    return rs == MAXCOUNT ? -1 : rs;
	}
	
	
	private int dfs(String str, int[] freq) {
	    str = removeConsecutive(str);     
	    if (str.equals("#")) { // if all the characters removed then return 0
	    	return 0;
	    }
	    int required = MAXCOUNT;
	    int ballsNeeded = 0;
	    for (int start = 0, end = 1 ; end < str.length(); end++) {
	        if (str.charAt(end) == str.charAt(start)) {
	        	continue;
	        }
	        ballsNeeded = 3 - (end - start);     //balls need to remove current consecutive balls.
	        if (freq[str.charAt(start) - 'A'] >= ballsNeeded) {
	            freq[str.charAt(start) - 'A'] -= ballsNeeded;
	            required = Math.min(required, ballsNeeded + 
	            		                      dfs(str.substring(0, start) + str.substring(end), freq));
	            freq[str.charAt(start) - 'A'] += ballsNeeded;
	        }
	        start = end;
	    }
	    return required;
	}
	
	/**
	 * Removing the consecutive string more than 3
	 * @param board
	 * @return
	 */
	private String removeConsecutive(String board) {
		for (int i=0, j=1; j < board.length(); j++) {
			if (board.charAt(j) == board.charAt(i)) {
				continue;
			}
			if (j-i>=3) {
				return removeConsecutive(board.substring(0, i)+board.substring(j));
			} else {
				i=j;
			}
		}
		return board;
	}
	public static void main(String[] args) {
		
	}
}

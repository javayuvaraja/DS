package com.yuva.leetcode.general;

/**
 * 
488. Zuma Game

Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). 
You also have several balls in your hand.

Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). 
Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.

Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.

Example 1:
Input: board = "WRRBBW", hand = "RB"
Output: -1
Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW

Example 2:
Input: board = "WWRRBBWW", hand = "WRBRW"
Output: 2
Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty

Example 3:
Input: board = "G", hand = "GGGGG"
Output: 2
Explanation: G -> G[G] -> GG[G] -> empty 
Example 4:

 * @author Yuvaraja Kanagarajan
 *
 */
public class ZumaGame {
	
	int MAXCOUNT = 6;  
	public int findMinStep(String board, String hand) {
		int []freq = new int[26];
		for (Character ch : hand.toCharArray()) { // hand balls frequency
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
			if (j-i>=3) { // if more than 3 consecutive then remove the those portions
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

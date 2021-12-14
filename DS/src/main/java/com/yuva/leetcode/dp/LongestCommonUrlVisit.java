package com.yuva.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Karat
 * @author Yuvaraja Kanagarajan
 *
 */
public class LongestCommonUrlVisit {

	public static void main(String[] args) {
	    String[] user1 = {"hi", "bye", "hello", "leetcode", "start", "end"};
        String[] user2 = {"hi", "stop", "leetcode", "start", "end", "bye"};
		  //List<String> repeatingStrings = repeatPattern(user1, user2);
		  List<String> repeatingStrings1 = repeatPattern1(user1, user2);
		  System.out.println(repeatingStrings1);
			/*
			 * for(String str : repeatingStrings) { System.out.println(str); }
			 */
	}
	
	 private static List<String> repeatPattern(String[] user1, String[] user2) {
	        int[][] dp = new int[user1.length+1][user2.length+1];
	        for(int i = 1; i <= user1.length; i++) {
	            for(int j = 1; j <= user2.length; j++) {
	                if(user1[i-1] == user2[j-1]) {
	                    dp[i][j] = dp[i-1][j-1] + 1;
	                } else {
	                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
	                }
	            }
	        }
	  
	        int row = dp.length-1; 
	        int col = dp[0].length-1;
	        
	        List<String> result = new ArrayList<>();
	        
	        while (row > 0 && col > 0) {
	        	if (dp[row-1][col-1] + 1 == dp[row][col]) {
	        		result.add(user1[row-1]);
	        		row--;
	        		col--;
	        	} else {
	        		if (dp[row-1][col] == dp[row][col]) {
	        			row--;
	        		} else {
	        			col--;
	        		}
	        	}
	        }
	        Collections.reverse(result);
	        return result;
	 }
	 
	 
	 
	 private static List<String> repeatPattern1(String[] user1, String[] user2) {
			int[][] dp = new int[user1.length + 1][user2.length + 1];
			int max = 0, maxUser1 = 0;
			for (int i = 1; i <= user1.length; i++) {
				for (int j = 1; j <= user2.length; j++) {
					if (user1[i - 1] == user2[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = 0;
					}
				}
			}
			// don't need second loop over dp, to shorten the code move this in first loop
			for (int i = 1; i <= user1.length; i++) {
				for (int j = 1; j <= user2.length; j++) {
					if (max < dp[i][j]) {
						max = dp[i][j];
						maxUser1 = i;
					}
				}
			}

			return Arrays.asList(user1).subList(maxUser1 - max, maxUser1);
		}
	}

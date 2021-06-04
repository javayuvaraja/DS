package com.yuva.leetcode.dfsbfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**

784. Letter Case Permutation

Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

Example 1:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:
Input: s = "3z4"
Output: ["3z4","3Z4"]

 * @author Yuvaraja Kanagarajan
 *
 */
public class LettercasePermutation {

	/**
	 *  abc
		abc Abc 0
		abc aBc Abc ABc 1
		abc abC aBc aBC Abc AbC ABc ABC 2
	 * @param S
	 * @return
	 */
	public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
            	continue;            
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        
        return new LinkedList<>(queue);
    }
}

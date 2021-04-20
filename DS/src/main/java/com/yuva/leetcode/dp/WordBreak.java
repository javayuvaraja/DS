package com.yuva.leetcode.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 Leetcode 39. Word Break

Given a string s and a dictionary of strings wordDict, return true 
if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 
 * @author Yuvaraja Kanagarajan
 *
 */

public class WordBreak {

	public boolean wordBreak(String str, List<String> wordDict) {
		int strLength = str.length();
		boolean result[][] = new boolean [strLength][strLength];
		// Converting list to set for improving the performance. 
		// checking word exists in list is o(n) but in set it is o(1)
		Set<String> wordSet = wordDict.stream().collect(Collectors.toSet());
		
		for (int length=1; length <=strLength; length++) {
			for (int start = 0; start < strLength-length+1; start++) {
				int end = start+length-1;
				String temp =  str.substring(start,end+1);
				if (wordSet.contains(temp)) {
					result[start][end] = true;
					continue;
				}
				// spliting the string into two parts and check
				for (int k=start+1; k <= end ; k++) {
					if (result[start][k-1] && result [k][end]) {
						result[start][end] = true;
						break;
					}
				}
			}
		}
		
		return result[0][strLength-1];
    }
	
	
	Map<String, Boolean> stringMap = new HashMap<>();
	public boolean wordBreak1(String s, List<String> wordDict) {
        if (s.length()==0) {
            return true;
        }
        
        if (stringMap.containsKey(s)) {
            return stringMap.get(s);
        }
        if (wordDict.contains(s)){
            stringMap.put(s, true);
            return true;
        }
        stringMap.put(s,false);
        for(int i=1; i <= s.length();i++) {
            if( wordDict.contains (s.substring(0,i)) &&
                wordBreak(s.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }
}

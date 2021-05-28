package com.yuva.leetcode.general;

/**
387. First Unique Character in a String

Given a string s, return the first non-repeating character in it and return its index. 
If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

 * @author Yuvaraja Kanagarajan
 *
 */
public class FirstUniqueCharacter {
	public int firstUniqChar(String str) {
        int freqMap[] = new int[26];
        for(int i = 0; i < str.length(); i ++)
            freqMap [str.charAt(i) - 'a'] ++;
        for(int i = 0; i < str.length(); i ++)
            if(freqMap [str.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}

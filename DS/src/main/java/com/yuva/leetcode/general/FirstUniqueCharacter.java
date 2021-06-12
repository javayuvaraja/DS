package com.yuva.leetcode.general;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
	
	public int firstUniqChar1(String str) {
        if (str==null ) {
            return -1;
        }
        Set<Character> visited = new HashSet<>();
        Map<Character, Integer> indexMap = new LinkedHashMap<>();
        int index = 0;
        for (Character ch: str.toCharArray()){
            if (visited.contains(ch)) {
                indexMap.remove(ch);    
            } else {
                indexMap.put(ch, index);
                visited.add(ch);
            }
            index++;
        }
        
        return indexMap.size()==0 ? -1 : indexMap.entrySet().iterator().next().getValue();
    }
}

package com.yuva.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***

Leetcode 1163. Last Substring in Lexicographical Order

Given a string s, return the last substring of s in lexicographical order.

 

Example 1:

Input: s = "abab"
Output: "bab"
Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
Example 2:

Input: s = "leetcode"
Output: "tcode"
 * @author Yuvaraja Kanagarajan
 *
 */
public class LexicographicalMaxString {

	
	public String lastSubstring(String s) {
        int length = s.length();
        int i = 0, j = 1, k = 0;
        while(j + k < length) {
            if (s.charAt(i+k) == s.charAt(j+k)){
                k++;
                continue;
            }
            if (s.charAt(i+k) > s.charAt(j+k)){
                j++;
            } else {
                i = j;
                j = i + 1;
            }
            k = 0;
        }
        
        return s.substring(i);
    }
	
	
	static String findMaxString(String str) {
		char maxchar = 'a';
		Map<Character, List<Integer>> charMap = new HashMap<>();

		// We store all the indexes of maximum
		// characters we have in the string
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= maxchar) {
				List<Integer> list= charMap.getOrDefault(str.charAt(i), new ArrayList<Integer>());
				list.add(i);
				charMap.put(str.charAt(i), list);
				maxchar = str.charAt(i);                      
			}
		}
		String maxstring = "";

		// We form a substring from that maximum
		// character index till end and check if
		// its greater that max string
		List<Integer> maxCharList = charMap.get(maxchar);
		for (int i = 0; i < maxCharList.size(); i++) {
			if (str.substring(maxCharList.get(i), str.length()).compareTo(maxstring) > 0) {
				maxstring = str.substring(maxCharList.get(i), str.length());
			}
		}
		return maxstring;
	}

	// Driver code
	public static void main(String[] args) {
		String str = "leetcodetze";
		System.out.println(findMaxString(str));
	}
}

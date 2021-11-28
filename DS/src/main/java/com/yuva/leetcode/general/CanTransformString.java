package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
1153. String Transforms Into Another String

Given two strings str1 and str2 of the same length, 
determine whether you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in 
str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2.

 

Example 1:

Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.

Example 2:
Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.

 * @author Yuvaraja Kanagarajan
 *
 */
public class CanTransformString {
	
	/**
	 * Logic :

a. one element can not map to two different elements --> immediate false
b. there can not be more than one cycle, because that means there is a chain that connects two cycles , thus hinting at existence of one letter from str1 being mapped to two letters of str2
c. now if a cycle is present, we can either break it or not.
d. We can have multiple characters map to the same value, we can just transform them to each other and then turn them to the mapped value
	example : "abcde" "fffff" . We can map a to b , c - b, d - b, e -b and turn all of them to f. note , the question is about whether we can transform two strings, not the number of optimal steps of doing so.
e. If there is a cycle, to break it , we must have some extra chars in the value set, since number of cycle can be only 1, we just need the value set to have a buffer of 1 char
f. We can not break a cycle if value set has 26 chars
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
           if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        return new HashSet<Character>(map.values()).size() < 26;
    }
	
	public static void main(String[] args) {
		String str1="ab";
		String str2 ="ba";
		CanTransformString obj = new CanTransformString();
		System.out.println(obj.canConvert(str1, str2));
	}
}

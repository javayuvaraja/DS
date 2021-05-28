package com.yuva.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
1347. Minimum Number of Steps to Make Two Strings Anagram

Given two equal-size strings s and t. In one step you can choose any character of t 
and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.


Example 1:
Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

Example 2:
Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.

 * @author Yuvaraja Kanagarajan
 *
 */
public class MinimumStepsTwoStringAnagram {

	public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - 'a']; // count the occurrences of chars in s.
            --count[t.charAt(i) - 'a']; // compute the difference between s and t.
        }
        return Arrays.stream(count).filter(i -> i > 0).sum(); // sum the positive values.
    }
	
	public int minSteps1(String s, String t) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (Character ch : s.toCharArray()) {
			charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
		}

		for (Character ch : t.toCharArray()) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) - 1);
				if (charMap.get(ch) == 0) {
					charMap.remove(ch);
				}
			}
		}

		int steps = 0;
		for (Character ch : charMap.keySet()) {
			steps = steps + charMap.get(ch);
		}

		return steps;

	}
}

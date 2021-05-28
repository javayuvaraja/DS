package com.yuva.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
Given a string, Check if characters of the given string can be rearranged to form a palindrome. 
For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”, 
but characters of “geeksforgeeks” cannot be rearranged to form a palindrome. 
 * @author Yuvaraja Kanagarajan
 *
 */
public class CheckRearrangePalindrome {

	static boolean canFormPalindrome(String str) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (Character ch : str.toCharArray()) {
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}

		int oddCount = 0;
		for (Character ch : freqMap.keySet()) {
			if (freqMap.get(ch) % 2 == 1) {
				oddCount++;
			}
		}

		return oddCount <= 1;
	}

	public static void main(String[] args) {
		// String str = "geeksogeeks";
		String str[] = { "geeksogeeks", "geeksoskeeg", "geeksforgeeks" };
		for (String temp : str) {
			System.out.println(temp + " : " + canFormPalindrome(temp));
		}
	}
}

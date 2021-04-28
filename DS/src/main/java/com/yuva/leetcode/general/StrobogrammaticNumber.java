package com.yuva.leetcode.general;

import java.util.HashMap;

/**
 * Leetcode 246. Strobogrammatic Number
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class StrobogrammaticNumber {

	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> dict = new HashMap<>();
		dict.put('0', '0');
		dict.put('1', '1');
		dict.put('8', '8');
		dict.put('6', '9');
		dict.put('9', '6');
		int start = 0;
		int end = num.length() - 1;
		while (start <= end) {
			char front = num.charAt(start);
			char back = num.charAt(end);
			if (dict.containsKey(front) && dict.containsKey(back) 
					&& dict.get(front) == back) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;

	}

}

package com.yuva.leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent. 
Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

 * @author Yuvaraja Kanagarajan
 *
 */
public class LetterCombinationPhoneNumber {

	private static Map<Character, String> charMap = new HashMap<>();
	static {
		charMap.put('2', "abc");
		charMap.put('3', "def");
		charMap.put('4', "ghi");
		charMap.put('5', "jkl");
		charMap.put('6', "mno");
		charMap.put('7', "pqrs");
		charMap.put('8', "tuv");
		charMap.put('9', "wxyz");

	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

		if (digits == null || digits.length() == 0) {
			return result;
		}
		generateCombinations(digits, new StringBuffer(), 0, result);
		return result;
	}

	private void generateCombinations(String digits, StringBuffer buff, int index, List<String> result) {
		if (index == digits.length()) {
			result.add(buff.toString());
			return;
		}

		String temp = charMap.get(digits.charAt(index));
		for (int j = 0; j < temp.length(); j++) {
			buff.append(temp.charAt(j));
			generateCombinations(digits, buff, index + 1, result);
			buff.setLength(buff.length() - 1);
		}

	}
}

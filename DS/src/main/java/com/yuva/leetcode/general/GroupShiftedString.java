package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249. Group Shifted Strings Given a string.
 * We can "shift" each of its letter to its successive letter, for example: 
 * "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only
 * lowercase alphabets, group all strings that belong to the same shifting
 * sequence.
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return: 
 * [ ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ] Note: For the
 * return value, each inner list's elements must follow the lexicographic order.
 * 
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class GroupShiftedString {

	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> table = new HashMap<>();
		for (String s : strings) {
			String key = getHashKey(s);
			List<String> list = table.getOrDefault(key, new ArrayList<>());
			table.putIfAbsent(key, list);
			list.add(s);
		}
		
		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<String, List<String>> e : table.entrySet()) {
			List<String> l = (List<String>) e.getValue();
			Collections.sort(l);
			result.add(l);
		}
		return result;
	}

	private String getHashKey(String s) {
	    char[] chars = s.toCharArray();
	    String key = "";
	    for(int i = 1; i < chars.length; i++) {
	        int diff = chars[i] - chars[i-1];
	        key += diff < 0 ? diff + 26 : diff;
	        key += ",";
	    }
	    return key;
	}
	
	public static void main(String[] args) {
		String str[]= {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		GroupShiftedString obj = new GroupShiftedString();
		List<List<String>> result = obj.groupStrings(str);
		System.out.println(result);
	}
}

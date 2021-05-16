package com.yuva.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string, find the deepest string nested inside a '()', '[]' or '{}'.
 * 
 * e.g. "abc(def)ghi" => ["def"] "abc(def[ghi]jkl)mno" => ["ghi"]
 * "abc(def)ghi[jkl]mno" => ["def", "jkl"] "abc" => []
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class MaxDepthString {

	public ArrayList<String> maxDepthString(String input) {
		ArrayList<ArrayList<String>> allLevels = new ArrayList<>();
		int level = 0;
		String curLevelString = "";
		for (Character ch : input.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				if (level == allLevels.size()) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(curLevelString);
					allLevels.add(temp);
				} else {
					allLevels.get(level).add(curLevelString);
				}
				curLevelString = "";
				level++;
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (level == allLevels.size()) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(curLevelString);
					allLevels.add(temp);
				} else {
					allLevels.get(level).add(curLevelString);
				}
				curLevelString = "";
				level--;
			} else {
				curLevelString += ch;
			}
		}

		if (allLevels.isEmpty()) {
			return new ArrayList<String>();
		}

		return allLevels.get(allLevels.size() - 1);
	}
	
	public static void main(String[] args) {
		String str = "abc(def)ghi[jkl]mno";
		MaxDepthString obj = new MaxDepthString();
		System.out.println(obj.maxDepthString(str));
	}
}

package com.yuva.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public static void main(String[] args) {
		//String str = "abc(def)ghi[jkl]mno";
		String str = "abc(def[ghi]jkl)mno";
		
		MaxDepthString obj = new MaxDepthString();
		System.out.println(obj.maxDepthString(str));
	}
	
	public List<String> maxDepthString(String str){
		
		StringBuffer buff = new StringBuffer();
		int level = 0;
		
		Map<Integer, List<String>> levelMap = new HashMap<>();
		for (Character ch : str.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				List<String> levelList = levelMap.getOrDefault(level, new ArrayList<String>());
				levelList.add(buff.toString());
				levelMap.put(level, levelList);
				level++;
				buff.setLength(0);
			}else if (ch == ')' || ch == '}' || ch == ']') {
				List<String> levelList = levelMap.getOrDefault(level, new ArrayList<String>());
				levelList.add(buff.toString());
				levelMap.put(level, levelList);
				level--;
				buff.setLength(0);
			} else {
				buff.append(ch);
			}
			
		}
		
		// If there is no brackets
		if (levelMap.size()<2) {
			return new ArrayList<String>();
		}
		return levelMap.get(levelMap.size()-1);
		
	}
}

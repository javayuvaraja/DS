package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

 * @author Yuvaraja Kanagarajan
 *
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, List<String>> groupMap = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char charArr[] = strs[i].toCharArray();
			Arrays.sort(charArr);
			String tempWord = new String(charArr);
			List<String> wordsList = groupMap.getOrDefault(tempWord, new ArrayList<String>());
			wordsList.add(strs[i]);
			groupMap.put(tempWord, wordsList);
		}
		return new ArrayList<List<String>>(groupMap.values());

	}
	
	
	public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            System.out.println(s+ " : " + keyStr);
            
            if (!map.containsKey(keyStr)) {
            	map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
	
	public static void main(String[] args) {
		GroupAnagrams obj = new GroupAnagrams();
		String strs[] = {"eaat","tea","tan","ate","nat","bat"};
		obj.groupAnagrams1(strs).stream().forEach(e-> System.out.println(e));
	}
}

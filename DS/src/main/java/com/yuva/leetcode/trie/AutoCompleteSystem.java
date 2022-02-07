package com.yuva.leetcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 642. Design Search Autocomplete System

Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').

You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.

Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same hot degree, 
use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Implement the AutocompleteSystem class:

AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
List<String> input(char c) This indicates that the user typed the character c.
Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.
 If there are fewer than 3 matches, return them all.
 * @author Yuvaraja Kanagarajan
 *
 */
public class AutoCompleteSystem {
	private class TrieNode {
		Map<Character, TrieNode> children;
		Map<String, Integer> counts;

		public TrieNode() {
			children = new HashMap<>();
			counts = new HashMap<>();
		}
	}

	private TrieNode root;
	private String prefix;

	public AutoCompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();
		prefix = "";
		for (int i = 0; i < sentences.length; i++) {
			addToTrie(sentences[i], times[i]);
		}
	}

	private void addToTrie(String sentence, int count) {
		TrieNode curr = root;
		for (char c : sentence.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				curr.children.put(c, new TrieNode());
			}
			curr = curr.children.get(c);
			curr.counts.put(sentence, curr.counts.getOrDefault(sentence, 0) + count);
		}
	}

	public List<String> input(char c) {
		if (c == '#') { // for ending search add/increment the count word to trie
			addToTrie(prefix, 1);
			prefix = "";
			return new ArrayList<>();
		}
		prefix += c;
		TrieNode curr = root;
		for (char ch : prefix.toCharArray()) {
			if (!curr.children.containsKey(ch)) {
				return new ArrayList<>();
			}
			curr = curr.children.get(ch);
		}
		Map<String, Integer> temp = curr.counts;
		PriorityQueue<String> minHeap = new PriorityQueue<>(
				(a, b) -> (temp.get(a) == temp.get(b) ? b.compareTo(a) : temp.get(a) - temp.get(b)));
		
		for (String key : temp.keySet()) {
			minHeap.offer(key);
			if (minHeap.size() > 3) {
				minHeap.poll();
			}
		}
		
		List<String> res = new ArrayList<>();
		while (minHeap.size() > 0) {
			res.add(0, minHeap.poll());
		}
		
		printResult(c, res);
		return res;
	}

	private void printResult(char c, List<String> res) {
		System.out.println("Search :" + c);
		for (String temp1 : res) {
			System.out.print(temp1 + " , ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		AutoCompleteSystem obj = new AutoCompleteSystem(new String[] {"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
		obj.input('i'); // return {"i love you", "island", "i love leetcode"}. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
		obj.input(' '); // return {"i love you", "i love leetcode"}. There are only two sentences that have prefix "i ".
		obj.input('a'); // return {}. There are no sentences that have prefix "i a".
		obj.input('#'); // return {}. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
	}
}

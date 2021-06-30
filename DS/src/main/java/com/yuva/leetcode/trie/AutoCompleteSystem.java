package com.yuva.leetcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
		if (c == '#') {
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
		obj.input('l'); // return {}. There are no sentences that have prefix "i a".
		obj.input('#'); // return {}. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
	}
}

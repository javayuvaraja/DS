 package com.yuva.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 839. Similar String Groups

Two strings X and Y are similar if we can swap two letters (in different positions) of X, 
so that it equals Y. Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), 
and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  
Notice that "tars" and "arts" are in the same group even though they are not similar.  
Formally, each group is such that a word is in the group if and only if it is similar to at least 
one other word in the group.

We are given a list strs of strings where every string in strs is an anagram of every other string in strs. 
How many groups are there?

 

Example 1:

Input: strs = ["tars","rats","arts","star"]
Output: 2
Example 2:

Input: strs = ["omv","ovm"]
Output: 1
 * @author Yuvaraja Kanagarajan
 *
 */
public class SimiliarStringGroup {
	
	public int numSimilarGroups(String[] words) {

		Map<String, Set<String>> graph = new HashMap<>();
		buildGraph(graph, words);

		if (graph.size() == 1) {
			return 1;
		}
		int connectedCount = 0;
		Set<String> visited = new HashSet<String>();
		for (String word : graph.keySet()) {
			if (!visited.contains(word)) {
				dfs(graph, visited, word);
				connectedCount++;
			}
		}
		return connectedCount;
	}

	private void dfs(Map<String, Set<String>> graph, Set<String> visited, String word) {
		visited.add(word);
		if (graph.get(word).size() == 0) { // not connected with any other words
			return;
		}
		for (String neighbour : graph.get(word)) {
			if (!visited.contains(neighbour)) {
				dfs(graph, visited, neighbour);
			}
		}
	}

	private void buildGraph(Map<String, Set<String>> graph, String[] words) {
		for (String word : words) {
			graph.put(word, new HashSet<String>());
		}

		int wordsCount = words.length;

		for (int i = 0; i < wordsCount-1; i++) {
			for (int j = i + 1; j < wordsCount; j++) {
				if (isSimilar(words[i], words[j])) {
					// undirected graph, adding the edge
					graph.get(words[i]).add(words[j]);
					graph.get(words[j]).add(words[i]);
				}
			}
		}
	}
	 
	 /**
	  * Checking whether both the string are similar means
	  * the difference should not be more than two. (One swap at different positions)
	  *
	  */
	 private boolean isSimilar(String word1, String word2) {
		 int diff = 0;
		 for (int i=0; i < word1.length();i++) {
			 if (word1.charAt(i) != word2.charAt(i)) {
				 diff++;
				 if (diff>2) {
					 return false;
				 }
			 }
		 }
		 return true;
	 }
}

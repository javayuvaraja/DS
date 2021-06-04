package com.yuva.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
Leetcode 737

Given two sentences words1, words2 (each represented as an array of strings), 
and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and 
             words2 = ["fine", "drama", "talent"] are similar, 
if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
Note that the similarity relation is transitive. 
For example, if “great” and “good” are similar, and “fine” and “good” are similar, 
then “great” and “fine” are similar.
Similarity is also symmetric. For example, “great” and “fine” being similar 
is the same as “fine” and “great” being similar.
Also, a word is always similar with itself. For example, 
the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, 
even though there are no specified similar word pairs.
Finally, sentences can only be similar if they have the same number of words. 
So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

 * @author Yuvaraja Kanagarajan
 *
 */
public class SentenceSimiliarityII {

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        // Build the graph of pairs
        HashMap<String, Set<String>> pairMap = new HashMap<>();
        for (String[] pair : pairs) {
            // Create keys(words in [][]pairs without duplication) and empty set 
            pairMap.putIfAbsent(pair[0], new HashSet<String>());
            pairMap.putIfAbsent(pair[1], new HashSet<String>());
            
            // Add the corresponding pairs to each other
            pairMap.get(pair[0]).add(pair[1]);
            pairMap.get(pair[1]).add(pair[0]);
        }
     
        // Iterate throught each word in both input strings and do DFS search
        for (int i = 0; i < words1.length; i++) {
            // If same, then we don't need to do DFS search
            if (words1[i].equals(words2[i])) {
            	continue;
            }
            
            // If they are not the same and no such strings in the pairs
            if (!pairMap.containsKey(words1[i]) || !pairMap.containsKey(words2[i])) {
            	return false;
            }
            // Do DFS search, initialize the set to prevent revisiting. 
            if (!dfs(words1[i], words2[i], pairMap, new HashSet<>())) {
            	return false;
            }
        }
        return true;
    }
        
    public boolean dfs(String source, String target, HashMap<String, Set<String>> pairMap, 
    		HashSet<String> visited) {
        if (pairMap.get(source).contains(target)) {
            return true;
        }
        // Mark as visited 
        visited.add(source);
        for (String neighbor : pairMap.get(source)) {
            // DFS other connected node, except the mirrowed string 
            if (!visited.contains(neighbor) &&
            	(neighbor.equals(target) || dfs(neighbor, target, pairMap, visited))) {
                return true;    
            }
        }
        // We've done dfs still can't find the target 
        return false;
    }
}

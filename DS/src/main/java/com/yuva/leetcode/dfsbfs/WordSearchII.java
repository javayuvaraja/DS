package com.yuva.leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;


public class WordSearchII {

	public List<String> findWords(char[][] board, String[] words) {
	    List<String> res = new ArrayList<>();
	    TrieNode root = buildTrie(words);
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            dfs (board, i, j, root, res);
	        }
	    }
	    return res;
	}

	public void dfs(char[][] board, int currRow, int currCol, TrieNode currNode, List<String> res) {
	    char ch = board[currRow][currCol];
	    // already visited or not valid char in the trie
	    if (ch == '#' || currNode.children[ch - 'a'] == null) {
	    	return;
	    }
	    currNode = currNode.children[ch - 'a'];
	    if (currNode.word != null) {   // found one, end of the word
	        res.add(currNode.word);
	        currNode.word = null;     // de-duplicate
	    }

	    board[currRow][currCol] = '#'; // marking the char visited
	    // Traversing all directions
	    if (currRow > 0)  dfs(board, currRow - 1, currCol ,currNode, res); 
	    if (currCol > 0) dfs(board, currRow, currCol - 1, currNode, res);
	    if (currRow < board.length - 1) dfs(board, currRow + 1, currCol, currNode, res); 
	    if (currCol < board[0].length - 1) dfs(board, currRow, currCol + 1, currNode, res); 
	    board[currRow][currCol] = ch; // re-marking 
	}

	public TrieNode buildTrie(String[] words) {
	    TrieNode root = new TrieNode();
	    for (String w : words) {
	        TrieNode p = root;
	        for (char c : w.toCharArray()) {
	            int i = c - 'a';
	            if (p.children[i] == null) {
	            	p.children[i] = new TrieNode();
	            }
	            p = p.children[i];
	       }
	       p.word = w;
	    }
	    return root;
	}

	class TrieNode {
	    TrieNode[] children = new TrieNode[26];
	    String word;
	}
}

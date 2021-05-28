package com.yuva.leetcode.trie;


public class WordDictionary {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }
    
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] charArr, int k, TrieNode node) {
        if (k == charArr.length) {
            return node.isWord;
        }
        if (charArr[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
            	TrieNode currNode = node.children[i];
                if (currNode != null && match(charArr, k + 1, currNode)) {
                    return true;
                }
            }
        } else {
        	TrieNode currNode = node.children[charArr[k] - 'a'];
            return currNode != null && match(charArr, k + 1, currNode);
        }
        return false;
    }
}

package com.yuva.leetcode.trie;

/**
211. Design Add and Search Words Data Structure

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 word may contain dots '.' where dots can be matched with any letter.

Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]
 * @author Yuvaraja Kanagarajan
 *
 */
public class TrieWordDictionary {

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

package com.yuva.leetcode.general;

import java.util.HashSet;

/**
 * 
 * Leetcode 266. Palindrome Permutation
 * Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: “code”
Output: false
Example 2:

Input: “aab”
Output: true
Example 3:

Input: “carerac”
Output: true

 * @author Yuvaraja Kanagarajan
 *
 */
public class PalindromPermutation {

	public boolean canPermutePalindrome(String s) {
        HashSet<Character> app = new HashSet<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (app.contains(c)) {
                app.remove(c);
            }    
            else {
                app.add(c);
            }
        }
        return app.size() <= 1;
    }
}

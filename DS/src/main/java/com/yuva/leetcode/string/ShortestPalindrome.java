package com.yuva.leetcode.string;

/**
214. Shortest Palindrome

You are given a string s. You can convert s to a palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: s = "abcd"
Output: "dcbabcd"

 * @author Yuvaraja Kanagarajan
 *
 */
public class ShortestPalindrome {

	/*
	 * Example: s = dedcba. Then r = abcded and I try these overlays (the part in (...) is the prefix I cut off, I just include it in the display for better understanding):

	  s          dedcba
	  r[0:]      abcded    Nope...
	  r[1:]   (a)bcded     Nope...
	  r[2:]  (ab)cded      Nope...
	  r[3:] (abc)ded       Yes! Return abc + dedcba
	 */
	public String shortestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        String reversed = sb.toString();
        for (int i = 0; i <= reversed.length(); i++) {
            if (str.startsWith(reversed.substring(i))) {
                return reversed.substring(0, i) + str;
            }
        }
        return reversed + str;
    }
}

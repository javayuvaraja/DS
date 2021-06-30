package com.yuva.leetcode.general;

/**
408. Valid Word Abbreviation
A string can be abbreviated by replacing any number of non-adjacent substrings with their lengths. 
For example, a string such as "substitution" could be abbreviated as (but not limited to):

"s10n" ("s ubstitutio n")
"sub4u4" ("sub stit u tion")
"12" ("substitution")
"su3i1u2on" ("su bst i t u ti on")
"substitution" (no substrings replaced)
Note that "s55n" ("s ubsti tutio n") is not a valid abbreviation of "substitution" because the replaced substrings are adjacent.

Given a string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

Example 1:
Input: word = "internationalization", abbr = "i12iz4n"
Output: true

Example 2:
Input: word = "apple", abbr = "a2e"
Output: false

 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidWordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null) return false;
        
        int i = 0, j = 0;
        
        while (i < word.length() && j < abbr.length()) {
            char c1 = word.charAt(i);
            char c2 = abbr.charAt(j);
            
            if (c1 == c2) {
                i++;
                j++;
            } else if (Character.isDigit(c2) && c2 != '0') {
                int skip = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    skip = skip * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                
              
                i += skip;
                
            } else {
                return false;
            }
        }
        
        
        return i== word.length() && j == abbr.length();
    }
}

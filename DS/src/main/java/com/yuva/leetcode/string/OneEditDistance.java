package com.yuva.leetcode.string;

/**
 * Leetcode 161
 * 
 * Given two strings  s  and  t , determine if they are both one edit distance apart.
 
   Possible cases:
   1. Insert a character into  s  to get  t 
   	  Ex : s = acd   t = abcd
   2. Delete a character from  s  to get  t
      Ex : s = abcd   t = acd
   3. Replace a character of  s  to get  t
	  Ex : s = abed   t = abcd
	  
   Logic :
   		1. If length difference is more than 1 return false.
   		2. Assume s is bigger string (if t is bigger then swap)
   		3. Compare each string character, when both are not matching
   			equal length: substring of remaining and check both are same. 
   			diff length : s.substring(index+1) , t.substring(index)
Note: 
 * @author Yuvaraja Kanagarajan
 *
 */
public class OneEditDistance {

	public static boolean isOneEditDistance(String s, String t) {
        if(t.length() > s.length()) {
        	return isOneEditDistance(t, s);
        }
        
        int m = s.length(); 
        int n = t.length();
        int diff = m-n;
        // checking the diff
        if(diff > 1) {
        	return false;
        }
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != t.charAt(i)) {
            	return s.substring(i + 1).equals(t.substring(i + 1)) ||  // both are same length 
            			t.substring(i).equals(s.substring(i + 1)); // both are diff length
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s = "abc";
		String t = "abcd";
		
		System.out.println(isOneEditDistance(s, t));
	}
}

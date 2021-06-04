package com.yuva.leetcode.dp;

/**
91. Decode Ways

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the 
reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 * @author Yuvaraja Kanagarajan
 *
 */
public class DecodeWays {

	public int numDecodings(String s) {
        int[] result = new int[s.length()+1];
        result[0] =1;
        result[1] =1;
        char charArr[] = s.toCharArray();
        if (charArr[0] == '0') {
            return 0;
        }
        for (int i =2; i <= s.length(); i++) {
            result[i]=0;
            if (charArr[i-1] > '0') {
                result[i] = result[i-1]; 
            }
            
            if (charArr[i-2] =='1' || 
               (charArr[i-2]=='2' && charArr[i-1] < '7')) {
                result[i] = result[i]+result[i-2];
            }
        }
        return result[s.length()];
    }
}

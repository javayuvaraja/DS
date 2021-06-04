package com.yuva.leetcode.array;

/**
Leetcode 821. Shortest Distance to a Character

Example 1:
Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 3.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance 
is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ShortestToCharIndex {

	public int[] shortestToChar(String str, char ch) {
        int n = str.length(), pos = -n, res[] = new int[n];
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ch) {
            	pos = i;
            }
            res[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; --i) {
            if (str.charAt(i) == ch)  {
            	pos = i;
            }
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }
}

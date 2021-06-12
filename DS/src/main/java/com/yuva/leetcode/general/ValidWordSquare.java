package com.yuva.leetcode.general;

import java.util.List;

/**
 * 422. Valid Word Square
Easy

226

139

Add to List

Share
Given an array of strings words, return true if it forms a valid word square.

A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).

Ex : 1
Input: words = ["abcd","bnrt","crmy","dtye"]
Output: true
Explanation:
The 1st row and 1st column both read "abcd".
The 2nd row and 2nd column both read "bnrt".
The 3rd row and 3rd column both read "crmy".
The 4th row and 4th column both read "dtye".
Therefore, it is a valid word square. 
 * @author Yuvaraja Kanagarajan
 *
 */

public class ValidWordSquare {

	public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0){
            return true;
        }
        int n = words.size();
        for(int row=0; row<n; row++){
            for(int col=0; col < words.get(row).length(); col++){
                if(col >= n || words.get(col).length() <= row || words.get(col).charAt(row) != words.get(row).charAt(col))
                    return false;
            }
        }
        return true;
    }
}

package com.yuva.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that 
 * are adjacent to each other are not the same.

   If possible, output any possible result.  If not possible, return the empty string.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReorganizeString {

	public String reorganizeString1(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int freqMax = 0;
        char maxFreqLetter = 0;
        char chArr[]= str.toCharArray();
        for (char ch: chArr) {
        	freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        	if (freqMap.get(ch) > freqMax) {
        		freqMax = freqMap.get(ch);
        		maxFreqLetter = ch;
        	}
        }
        
        if (freqMax > (str.length() + 1) / 2) {
            return ""; 
        }
        
        char[] res = new char[str.length()];
        int idx = 0;
        while (freqMax > 0) {
            res[idx] = maxFreqLetter;
            idx += 2;
            freqMax--;
        }
        freqMap.remove(maxFreqLetter);
        for(char ch: freqMap.keySet()) {
        	int frequency = freqMap.get(ch);
        	while (frequency>0) {
        		if (idx >= res.length) {
                    idx = 1;
                }
        		res[idx] = ch;
        		idx += 2;
        		frequency--;
        	}
        }
        return String.valueOf(res);
    }
	
	public static void main(String[] args) {
		ReorganizeString obj = new ReorganizeString();
		System.out.println(obj.reorganizeString1("aab"));
	}
	
}

package com.yuva.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordFilterPrefixSuffix {

	HashMap<String, List<Integer>> mapPrefix = new HashMap<>(); // hold prefix with the list of word index
    HashMap<String, List<Integer>> mapSuffix = new HashMap<>();
    private static final int MAX_WORD_LENGTH =10;
    
	public WordFilterPrefixSuffix(String[] words) {
		for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
			String currWord = words[wordIndex];
			for (int i = 0; i <= MAX_WORD_LENGTH && i <= currWord.length(); i++) {
				String prefix = currWord.substring(0, i);
				mapPrefix.putIfAbsent(prefix, new ArrayList<Integer>());
				mapPrefix.get(prefix).add(wordIndex);
			}
			for (int i = 0; i <= MAX_WORD_LENGTH && i <= currWord.length(); i++) {
				String suffix = currWord.substring(currWord.length() - i);
				mapSuffix.putIfAbsent(suffix, new ArrayList<Integer>());
				mapSuffix.get(suffix).add(wordIndex);
			}
		}
	}

    public int find(String prefix, String suffix) {
        if(!mapPrefix.containsKey(prefix) 
        		|| !mapSuffix.containsKey(suffix)) {
        	return -1;
        }
        
        List<Integer> prefixList = mapPrefix.get(prefix);
        List<Integer> suffixList = mapSuffix.get(suffix);
        int i = prefixList.size()-1, j = suffixList.size()-1;
        // Two pointer concept two map both the index are same
        while(i >= 0 && j >= 0){
            if(prefixList.get(i) < suffixList.get(j)) j--;
            else if(prefixList.get(i) > suffixList.get(j)) i--;
            else return prefixList.get(i);
        }
        return -1;
    }
}

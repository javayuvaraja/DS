package com.yuva.leetcode.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.equals(endWord)) {
			return 1;
		}
		Set<String> wordsSet = wordList.stream().collect(Collectors.toSet());
		Set<String> visitedWords = new HashSet<String>();
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		visitedWords.add(beginWord);
		int level  = 1;
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currWord = queue.poll();
				char []charArr = currWord.toCharArray();
				for (int j=0; j < charArr.length; j++) {
					char currChar = charArr[j];
					for (int ch='a'; ch <= 'z'; ch++) {
						charArr[j] = (char)ch;
						String newWord = new String(charArr);
						if (wordsSet.contains(newWord) && !visitedWords.contains(newWord)) {
							if (newWord.equals(endWord)) {
								return level;
							}
							queue.offer(newWord);
							visitedWords.add(newWord);
						}
						 charArr[j] = currChar;
 					}
				}
			}			
		}
		return 0;			
	}
}

package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GuessWord {
	public int match(String a, String b) {
		int matches = 0;
		for (int i = 0; i < a.length(); ++i)
			if (a.charAt(i) == b.charAt(i))
				matches++;
		return matches;
	}
	
	/**
	 * Logic : Guess a Random Word
	 * Randomly select the word from list.
	 * Check Guess
	 * Select only the same matched character
	 * @param wordlist
	 * @param master
	 */
	public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }
	
	
	/**
	 * 
	 * @param wordlist
	 * @param master
	 */
	public void findSecretWord1(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            HashMap<String, Integer> count = new HashMap<>();
            for (String w1 : wordlist)
                for (String w2 : wordlist)
                    if (match(w1, w2) == 0) // store nothing matched one
                        count.put(w1, count.getOrDefault(w1 , 0) + 1);
            String guess = "";
            int min0 = 100;
            for (String w : wordlist)
                if (count.getOrDefault(w, 0) < min0) { // get the not matched word with most of the words
                    guess = w;
                    min0 = count.getOrDefault(w, 0);
                }
            x = master.guess(guess); // choose that word as guess word
            List<String> wordlist2 = new ArrayList<String>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[0]);
        }
    }
	
	/**
	 * Solution 4: Count the Occurrence of Characters
		In the previous solution, we compaired each two words.
		This make the complexity O(N^2) for each turn.
		
		But actually we don't have to do that.
		We just need to count the occurrence for each character on each position.
		
		If we can guess the word that not in the wordlist,
		we can guess the word based on the most frequent character on the position.
		
		Here we have to guess a word from the list,
		we still can calculate a score of similarity for each word,
		and guess the word with highest score.
		
		Time complexity O(N)
		Space complexity O(N)
	 */
	 public void findSecretWord2(String[] wordlist, Master master) {
	        for (int t = 0, x = 0; t < 10 && x < 6; ++t) {
	            int count[][] = new int[6][26], best = 0;
	            for (String w : wordlist)
	                for (int i = 0; i < 6; ++i)
	                    count[i][w.charAt(i) - 'a']++;
	            String guess = wordlist[0];
	            for (String w: wordlist) { // which word has the maximum common character
	                int score = 0;
	                for (int i = 0; i < 6; ++i)
	                    score += count[i][w.charAt(i) - 'a'];
	                if (score > best) {
	                    guess = w;
	                    best = score;
	                }
	            }
	            x = master.guess(guess);
	            List<String> wordlist2 = new ArrayList<String>();
	            for (String w : wordlist)
	                if (match(guess, w) == x)
	                    wordlist2.add(w);
	            wordlist = wordlist2.toArray(new String[0]);
	        }
	    }
}

interface Master {
	public int guess(String word);
}

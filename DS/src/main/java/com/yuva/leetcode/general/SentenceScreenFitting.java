package com.yuva.leetcode.general;

/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class SentenceScreenFitting {

	public int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		int start = 0, l = s.length();
		for (int i = 0; i < rows; i++) {
			start += cols;
			if (s.charAt(start % l) == ' ') {
				start++;
			} else {
				while (start > 0 && s.charAt((start - 1) % l) != ' ') {
					start--;
				}
			}
		}

		return start / s.length();
	}
	
	
	public int wordsTyping1(String[] sentence, int rows, int cols) {
	    String s = String.join(" ", sentence) + " ";
	    int len = s.length(), count = 0;
	    int[] map = new int[len];
	    for (int i = 1; i < len; ++i) {
	        map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
	    }
	    for (int i = 0; i < rows; ++i) {
	        count += cols;
	        count += map[count % len];
	    }
	    return count / len;
	}
	
	public static void main(String[] args) {
		String sentence[] = new String[]{"a", "bcd", "e"}; 
		int rows = 3, cols = 6;
		SentenceScreenFitting obj = new SentenceScreenFitting();
		obj.wordsTyping1(sentence, rows, cols);
	}
}

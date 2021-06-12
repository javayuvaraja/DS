package com.yuva.leetcode.general;

/**
 * LeetCode 158. Read N Characters Given Read4 II - Call multiple times
 * 
 * Description Similar to Question [Read N Characters Given Read4], but the read
 * function may be called multiple times.
 * 
 * This question is different from 157. Read N Characters Given Read4, because
 * if the characters read by read4 is more than n, I must start from the unused
 * extra characters in the temp buffer next time. So the idea is to make temp
 * buffer an instance variable. Use a temp pointer and a temp count to keep
 * track of where and how many to read from temp buffer.
 * 
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReadNCharactersRead4II {

	private int tmpPtr = 0;
	private int tmpCnt = 0;
	private char[] temp = new char[4];

	public int read(char[] buf, int n) {
		int total = 0;
		while (total < n) {
			if (tmpPtr == 0) {  // all the prev read values returned so read it from the file
				tmpCnt = read4(temp); 
			}

			if (tmpCnt == 0) { // no more chars
				break;
			}
			
			while (total < n && tmpPtr < tmpCnt) { // add the last leftover and current reading also
				buf[total++] = temp[tmpPtr++];
			}
			if (tmpCnt == tmpPtr) { // if all the temp buffer read then reset it to zero
				tmpPtr = 0 ;
			}
		}
		return total;
	}

	public int read4(char[] tmp) {
		return 0;
	}
}

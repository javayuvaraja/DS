package com.yuva.leetcode.general;

/**
 * Read N Characters Given Read4 The API: int read4(char *buf) reads 4
 * characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function will only be called once for each test case.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReadNCharactersRead4 {

	public int read(char[] buf, int n) {
		boolean eof = false; // end of file flag
		int total = 0; // total bytes have read
		int maxBuffer = 4;
		char[] tmp = new char[maxBuffer]; // temp buffer

		while (!eof && total < n) {
			int retrieved = read4(tmp);

			// check if it's the end of the file
			eof = retrieved < maxBuffer;
			
			int remaining = n-total;
			// get the actual count
			retrieved = Math.min(retrieved, remaining);

			// copy from temp buffer to buf
			for (int i = 0; i < retrieved; i++)
				buf[total++] = tmp[i];
		}

		return total;
	}
	
	public int read4(char[] tmp) {
		return 0;
	}
}



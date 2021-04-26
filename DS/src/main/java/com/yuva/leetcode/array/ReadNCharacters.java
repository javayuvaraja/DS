 package com.yuva.leetcode.array;

/**
 * 
 * Description
	The API: int read4(char *buf) reads 4 characters at a time from a file.
	The return value is the actual number of characters read. 
	For example, it returns 3 if there is only 3 characters left in the file.
	By using the read4 API, implement the function int read(char *buf, int n) 
	that reads n characters from the file.

 * @author Yuvaraja Kanagarajan
 *
 */
public class ReadNCharacters {

	public int read(char[] buff, int n) {
		int bufferSize = 4;
		int totalBytesRead = 0;
		char[] tempBuff = new char[bufferSize];
		boolean isFileCompleted = false;
		
		while (!isFileCompleted && totalBytesRead < n) {
			int charCount = read4(tempBuff);
			isFileCompleted = charCount < bufferSize;
			charCount = Math.min(charCount, n-totalBytesRead); // read till user asked
			for (int i=0; i < charCount; i++) {
				buff[totalBytesRead++] = tempBuff[i]; 
			}
		}
		return totalBytesRead;
		
	}
	
	private int read4(char[] charBuff) {
		return 0;
	}
}

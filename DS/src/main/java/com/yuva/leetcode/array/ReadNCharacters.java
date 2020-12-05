package com.yuva.leetcode.array;

import java.util.stream.IntStream;

/**
 * 
 * Description
	The API: int read4(char *buf) reads 4 characters at a time from a file.
	The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
	By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 * @author Yuvaraja Kanagarajan
 *
 */
public class ReadNCharacters {

	public int read(char[] buff, int n) {
		int bufferSize =4;
		int totalBytesRead = 0;
		char []charBuff = new char[bufferSize];
		boolean isFileCompleted = false;
		while (totalBytesRead < n && !isFileCompleted) {
			int count = read4(charBuff);
			isFileCompleted= count < bufferSize;
			count = Math.min(count, totalBytesRead-n);
			
			IntStream.range(0, count).forEach(System.out.println(index));
		}
		return totalBytesRead;
		
	}
	
	public static void main(String[] args) {
		IntStream.range(0, 5).forEach(index-> System.out.println(index));
	}
	
	private int read4(char[] charBuff) {
		return 0;
	}
}

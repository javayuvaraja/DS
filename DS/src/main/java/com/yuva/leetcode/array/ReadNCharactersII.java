package com.yuva.leetcode.array;

/**
 * 
 * 	The API: int read4(char *buf) reads 4 characters at a time from a file.
	The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
	By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 *  
	Input: "filetestbuffer"	
	Output:		
		read(6)
		read(5)
		read(4)
		read(3)
		Output:
		6, buf = "filete"
		5, buf = "stbuf"
		3, buf = "fer"
		0, buf = ""
		
	Input: "abcdef"
	Output : 
		read(1)
		read(5)
		Output:
		1, buf = "a"
		5, buf = "bcdef"	
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReadNCharactersII {

	public static int buffSize = 4;
	private int currPtr = 0;
	private int currCnt = 0;
	private char[] temp = new char[buffSize];
	
	public int read(char[] buff, int n) {
		int totalBytesRead = 0;
		while (totalBytesRead < n) {
			// if last buff completely processed then read the content
			if (currPtr==0) {
				currCnt = read4(temp);
			}
			
			while (totalBytesRead < n && currPtr < currCnt) {
				buff[totalBytesRead++] = temp[currPtr++];
			}
			// curr read content processed so reset currPtr
			if (currPtr == currCnt) {
				currPtr = 0;
			}
			
			if (currCnt < buffSize ) { // end of file
				break;
			}			
		}
		return totalBytesRead;
	}
	
	private int read4(char[] buff) {
		return 0;
	}
}

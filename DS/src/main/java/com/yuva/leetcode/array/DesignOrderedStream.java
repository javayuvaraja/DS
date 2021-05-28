package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
1656. Design an Ordered Stream
There is a stream of n (idKey, value) pairs arriving in an arbitrary order, 
where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.

Design a stream that returns the values in increasing order of their IDs by returning a 
chunk (list) of values after each insertion. The concatenation of all the chunks should result in 
a list of the sorted values.

Implement the OrderedStream class:

OrderedStream(int n) Constructs the stream to take n values.
String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream, then returns the largest possible chunk of currently inserted values that appear next in the order.
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class DesignOrderedStream {
	
	String []values;
    int currIndex;
    public DesignOrderedStream(int n) {
        values =  new String[n];
        currIndex = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        
        values[idKey-1] = value;
        
        while (currIndex < values.length &&
              values[currIndex]!=null) {
            result.add(values[currIndex]);
            currIndex++;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	// Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
    	DesignOrderedStream os = new DesignOrderedStream(5);
    	os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
    	os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
    	os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
    	os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
    	os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
    	// Concatentating all the chunks returned:
    	// [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
	}
	
}

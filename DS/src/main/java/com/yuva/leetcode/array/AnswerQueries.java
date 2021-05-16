package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Facebook question

Imagine a length-N array of booleans, initially all false. Over time, some values are set to true, 
and at various points in time you would like to find the location of the nearest true to the right of given indices.
You will receive Q queries, each of which has a type and a value. SET queries have type = 1 and GET queries have type = 2.
When you receive a SET query, the value of the query denotes an index in the array that is set to true. Note that these indices start at 1. 
When you receive a GET query, you must return the smallest index that contains a true value that is greater than or equal to the given index, or -1 if no such index exists.
Signature

int[] answerQueries(ArrayList queries, int N)
Input
A list of Q queries, formatted as [type, index] where type is either 1 or 2, and index is < N
1 <= N <= 1,000,000,000
1 <= Q <= 500,000

Output
Return an array containing the results of all GET queries. The result of queries[i] is the smallest index that contains a true value that is greater than or equal to i, or -1 if no index satisfies those conditions.
Example
N = 5
Q = 5
queries = [[2, 3], [1, 2], [2, 1], [2, 3], [2, 2]]
output = [-1, 2, -1, 2]

The initial state of the array is [false, false, false, false, false].
The first query is GET 3, but no values in the array are true, so the answer is -1.
The second query is SET 2, so the value at index 2 is set to true.
The new state of the array is [false, true, false, false, false].
The third query is GET 1, and the index of the true value nearest to 1 (to the right) is 2.
The fourth query is GET 3, but no values to the right of index 3 are true.
The fifth query is GET 2, and the value at index 2 is true.

 * @author Yuvaraja Kanagarajan
 *
 */
public class AnswerQueries {
	class Query {
		int type;
		int index;
		
		Query (int type, int index) {
			this.type =type;
			this.index = index;
		}
	
	}
	
	public int[] answerQueries(ArrayList<Query> queries, int N){
	        TreeSet<Integer> set =   new TreeSet<>();
	        ArrayList<Integer> arr = new ArrayList<>();
	        for(Query q: queries){
	            if(q.type == 1){
	                set.add(q.index);
	            }else{
	                Integer val = set.ceiling(q.index); // fetching the next smallest greater number
	                if(val==null){
	                    arr.add(-1);
	                }else{
	                    arr.add(val);
	                }
	            }
	       }
	       int[] result = new int[arr.size()];
	       for(int i=0;i<arr.size();i++){
	            result[i] = arr.get(i);
	        }
	        return result;
	    }
}

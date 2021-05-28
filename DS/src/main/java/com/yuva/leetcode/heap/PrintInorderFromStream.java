package com.yuva.leetcode.heap;

/**
 * 
There is a continous stream of data in the form of:
Input: (1, "abcd"), (2, "efgh"), (4, "mnop"), (5, "qrst"), (3, "ijkl")

Write a program to output the data from the stream in realtime in order, so 1,2,3,4,5..
You cannot queue up the incoming data from the stream.
So for example if the first incoming bit of data is (1, "abcd"), and the second is (4, "mnop"), 
you cannot output (4, "mnop") until you get 2, 3.
 * @author Yuvaraja Kanagarajan
 *
 */
public class PrintInorderFromStream {

	/*
	 * Assuming input to be a list: (1, "abcd"), (2, "efgh"), (4, "mnop"), (5, "qrst"), (3, "ijkl")
	   We can maintain a minHeap which will maintain the right incoming sequence.
       As and when the sequence received till a point is correct we can stream the input i.e 
       poll the queue till that point.

		PriorityQueue<Integer> pq = new PriorityQueue();
		int prev = 0;    //To keep track of sequence and keep polling in sequence.
		while(incomingStream) {
       		pq.add(list);      //This is the incoming stream of list.
       		while(pq.peek().get(0) == prev+1) {        //When the right sequence arrive we can further check the condition to remove the element which are in sequence till this point
                if(pq.size() > 1){             // Makes sure there is atleast 1 element left in prioritty queue
                        pq.poll();          //  streams/ removes the elementt in sequence
                 }
                 prev++;
       		}
		}
	 * 
	 * 
	 */
}

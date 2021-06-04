package com.yuva.leetcode.array;

public class MovingAvgFromDataStream {
	int [] num;
    int index;
    int sum;
    int count;
	public MovingAvgFromDataStream(int size) {
		num = new int[size];
		index = 0;
		sum = 0;
		count = 0;
	}
	
	public double next(int val) {
        sum -= num[index];
        num[index++] = val;
        if(index == num.length) {
        	index = 0;
        }
        sum += val;
        count = count == num.length ? count : count + 1;
         return ((double) sum) / count;
    }
	
	public static void main(String[] args) {
		MovingAvgFromDataStream m = new MovingAvgFromDataStream(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5)); 
	
	}
}

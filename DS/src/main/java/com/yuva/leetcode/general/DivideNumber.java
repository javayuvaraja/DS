package com.yuva.leetcode.general;

public class DivideNumber {

	
	public int divide (int dividend, int divisor ) {
		if (dividend < divisor) {
			return 0;
		}
		
		int sum = divisor;
		int multiple = 1;
		
		while ((sum + sum)  <= dividend) {
			sum += sum;
			multiple += multiple;			
		}
		
		return multiple + divide(dividend-sum, divisor);
	}
	
	
	public static void main(String[] args) {
		int dividend = 102;
		int divisor =3;
		
		DivideNumber obj = new DivideNumber();
		System.out.println(obj.divide(dividend, divisor));
	}
}

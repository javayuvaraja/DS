package com.yuva.multithreading;

public class TestInterface implements i1, i2{

	@Override
	public void m1() {
		i1.super.m1();
	}

	
}


interface i1{
	public default void m1() {
		System.out.println("I1");
	}
}

interface i2{
	public default void m1() {
		System.out.println("I2");
	}
}

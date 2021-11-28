package com.yuva.java8;

public class RunnableLambda {

	/**
	
	Runnable implementation
	
	@FunctionalInterface
	public interface Runnable {
    	public abstract void run();
	}
	
	 */
	
	public static void main(String[] args) {
		Runnable runnable = ()->System.out.println(Thread.currentThread().getName() +  " Test Lambda");
		
		Thread t = new Thread(runnable);
		t.start();
	}
}

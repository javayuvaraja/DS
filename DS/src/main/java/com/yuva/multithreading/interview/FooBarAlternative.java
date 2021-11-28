package com.yuva.multithreading.interview;

import java.util.concurrent.Semaphore;

public class FooBarAlternative {

	private int n;
    Semaphore s = new Semaphore(0);
    Semaphore s2 = new Semaphore(1);

    public FooBarAlternative (int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            s2.acquire();

            printFoo.run();
            s.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            s.acquire();

            printBar.run();
            s2.release();

        }
    }
    
    public static void main(String[] args) throws InterruptedException {
		FooBarAlternative obj = new FooBarAlternative(10);
		obj.foo(new PrintFoo());
		obj.bar(new PrintBar());
	}
}


class PrintFoo implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " - Foo" );
	}
}


class PrintBar implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " - Bar" );
	}
}
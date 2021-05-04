package com.yuva.multithreading.interview;

import java.util.concurrent.Semaphore;

public class OddEvenPrinter {
    private Semaphore semEven = new Semaphore(0);
    private Semaphore semOdd = new Semaphore(1);
 
    void printEvenNum(int num) {
        try {
            semEven.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + num);
        semOdd.release();
    }
 
    void printOddNum(int num) {
        try {
            semOdd.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + num);
        semEven.release();
 
    }
    
    public static void main(String[] args) {
    	OddEvenPrinter sp = new OddEvenPrinter();
        Thread odd = new Thread(new Odd(sp, 10),"Odd");
        Thread even = new Thread(new Even(sp, 10),"Even");
        odd.start();
        even.start();
    }
}
 
class Even implements Runnable {
    private OddEvenPrinter sp;
    private int max;
 
    // standard constructor
    Even (OddEvenPrinter oep, int max) {
    	this.sp = oep;
    	this.max = max;
    }
    @Override
    public void run() {
        for (int i = 2; i <= max; i = i + 2) {
            sp.printEvenNum(i);
        }
    }
}
 
class Odd implements Runnable {
    private OddEvenPrinter sp;
    private int max;
 
    Odd (OddEvenPrinter oep, int max) {
    	this.sp = oep;
    	this.max = max;
    }
    // standard constructors 
    @Override
    public void run() {
        for (int i = 1; i <= max; i = i + 2) {
            sp.printOddNum(i);
        }
    }
}
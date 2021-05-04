package com.yuva.multithreading.interview;

/**
 * @author madhes
 *
 */
public class EvenOddPrinter {
	private volatile boolean isOdd = true;
	public synchronized void printOdd (int number) throws InterruptedException {
		while (!isOdd) {
			wait();
		}
		System.out.println(Thread.currentThread().getName() +" - "+ number);
		isOdd = false;
		notifyAll();
	}	
	
	public synchronized void printEven (int number) throws InterruptedException {
		while (isOdd) {
			wait();
		}
		System.out.println(Thread.currentThread().getName() +" - "+ number);
		isOdd = true;
		notifyAll();
	}
	
	public static void main(String... args) {
		EvenOddPrinter print = new EvenOddPrinter();
	    Thread t1 = new Thread(new TaskEvenOdd(print, 10, false),"Odd");
	    Thread t2 = new Thread(new TaskEvenOdd(print, 10, true),"Even");
	    t1.start();
	    t2.start();
	}
}

class TaskEvenOdd implements Runnable {
    private int max;
    private EvenOddPrinter print;
    private boolean isEvenNumber;
 
    public TaskEvenOdd(EvenOddPrinter print2, int max, boolean isEvenNumber) {
    	this.print = print2;
    	this.max = max;
    	this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                try {
					print.printEven(number);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            } else {
                try {
					print.printOdd(number);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            number += 2;
        }
    }
}

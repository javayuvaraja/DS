package com.yuva.multithreading.interview;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;


public class ZeroOddEven {
	public static void main(String[] args) {
		
		
	}
}

class ZeroOddEvenPrinterTask {

	private int n;
    Semaphore s0,s1,s2;
    
    public ZeroOddEvenPrinterTask(int n) {
        this.n = n;
        this.s0 = new Semaphore(1);
        this.s1 = new Semaphore(0);
        this.s2 = new Semaphore(0);    
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        
        for(int i = 0; i< n; i ++){
            s0.acquire();
            printNumber.accept(0);
            (i%2 == 0 ? s1 : s2).release();
        }
        
        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i<= n; i +=2){
            s2.acquire();
            printNumber.accept(i);
            s0.release();
        }
        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<= n; i +=2){
            s1.acquire();
            printNumber.accept(i);
            s0.release();
        }
        
    }
}



class ZeroEvenOddPrinterTask {
    private int n;
    private int sig;
    
    public ZeroEvenOddPrinterTask(int n) {
        this.n = n;
        this.sig = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for(int  i = 0; i < n; i ++){
            while(sig != 0){
                wait();
            }
            
            printNumber.accept(sig);
            sig = i %2 == 0 ? 1 : 2;
            notifyAll();
        }
        
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for(int  i = 2; i <= n; i +=2){
             while(sig != 2){
                wait();
            }
            
           printNumber.accept(i);
            sig = 0;
            notifyAll();
            }
       
        
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
         for(int  i = 1; i <= n; i +=2){
            while(sig != 1){
                wait();
            }
          
            printNumber.accept(i);
             sig = 0;
            notifyAll();
             }

    }
}
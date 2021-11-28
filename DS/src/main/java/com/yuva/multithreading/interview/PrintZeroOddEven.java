package com.yuva.multithreading.interview;

public class PrintZeroOddEven {

	
	
	public static void main(String[] args) {
		ZeroOddEvenPrinter obj = new ZeroOddEvenPrinter();

		Thread t1 = new Thread (new PrinterTask(obj, 5, 0), "ZeroThread");
		Thread t2 = new Thread (new PrinterTask(obj, 5, 1), "OddThread");
		Thread t3 = new Thread (new PrinterTask(obj, 5, 2), "EvenThread");
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	
}


class PrinterTask implements Runnable {
	private int max;
    private ZeroOddEvenPrinter printer;
    private int printerType;
 
    public PrinterTask(ZeroOddEvenPrinter printer, int max, int printerType) {
    	this.printer = printer;
    	this.max = max;
    	this.printerType = printerType;
    }

    @Override
    public void run() {
    	int number = printerType==2 ? 2 : 1;
    	
        while (number <= max) {
            if (printerType==0) {
                try {
                	printer.printZero(0);
                	number++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            
            else if (printerType == 1) {
                try {
					printer.printOdd(number);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                number+=2;
            } else if (printerType == 2) {
            	try {
					printer.printEven(number);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            	number+=2;
            }
            
        }
    }
}
class ZeroOddEvenPrinter {
	private volatile boolean isZero = true;
	private volatile boolean isOdd = true;
	private volatile boolean isEven = false;
	
	public synchronized void printZero (int number) throws InterruptedException {
		while (!isZero) {
			wait();
		}
		System.out.println(Thread.currentThread().getName() +" - "+ number);
		isZero = false;
		notifyAll();
	}
	
	public synchronized void printOdd (int number) throws InterruptedException {
		while (!isOdd || isZero) {
			wait();
		}
		System.out.println(Thread.currentThread().getName() +" - "+ number);
		isZero = true;
		isEven = true;
		isOdd = false;
		notifyAll();
	}	
	
	public synchronized void printEven (int number) throws InterruptedException {
		while (!isEven || isZero) {
			wait();
		}
		System.out.println(Thread.currentThread().getName() +" - "+ number);
		isOdd = true;
		isZero= true;
		isEven = false;
		notifyAll();
	}
}

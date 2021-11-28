package com.yuva.java8;

public class StopThread extends Thread {
	volatile boolean finished = false;

	public void stopMe() {
		finished = true;
	}

	public void run() {
		while (!finished) {
			// do dirty work
		}
	}
}


/*

while (!isInterrupted()) { 
  // doStuff
}

*/


/*
Shutdown Hook
--------------

Add a static volatile boolean keepRunning = true;
In run() you change to

for (int i = 0; i < N && keepRunning; ++i)
    writeBatch(pw, i);

In main() you add:

final Thread mainThread = Thread.currentThread();
Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
        keepRunning = false;
        mainThread.join();
    }
});


*/


/**
Uncaught Exception:
Thread.setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler)

*/
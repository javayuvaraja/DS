package com.yuva.multithreading.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author ykanagar
 *  	Similiar to object.wait, object.notify and object.notifyAll
		condition.wait();
		condition.signal();
		condition.signalAll();
	
 */
public class LockCondition {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	
	public void method1() throws InterruptedException {
		lock.lock();
		try {
			condition.await();   // suspend here
			// do something  // executes after the signal (resume)
		} finally {
			lock.unlock();
		}
		
		/*
		condition.await();
		condition.signal();
		condition.signalAll();
		*/
	}
	
	public void method2() {
		lock.lock();
		try {
			// do something
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}

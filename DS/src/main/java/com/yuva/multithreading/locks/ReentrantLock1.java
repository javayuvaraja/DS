package com.yuva.multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author ykanagar
 * 
 * Reentrant locks are
 *    1. Locks are explicit
 *    2. Locks allow locking and unlocking in any scopes and any order
 *    3. can tryLock and tryLock(timeout)
 *    
 *    Use unlock in finally
 *    
 *    Fair Lock : Equal chances for all the threads but slower
 *    UnFair Lock : Faster (more throughput), possible thread starvation
 *
 */
public class ReentrantLock1 {

	private static ReentrantLock lock = new ReentrantLock();
	//private static ReentrantLock lock = new ReentrantLock(true); // fair locks
	
	private static void accessResource() {
		lock.lock();
		lock.lock(); // can call any times, but that many times have to call unlock
		try {
			int number = lock.getHoldCount();
			// access the resource
		} finally {
			lock.unlock();
		}
		
		// the above code is same as
		/*synchronized (this) {
			// access the resource
		}*/
	}
	
	public static void tryLockTest () {
		boolean isLockAcquired = lock.tryLock(); // this doesnt honor the fairness
		//boolean isLockAcquired = lock.tryLock(5, TimeUnit.SECONDS); // try lock for 5 seconds, poll every seconds
		
		if (isLockAcquired) {
			try {
				// do something
			} finally {
				lock.unlock();
			}
		} else {
			//some other operation, not waiting for lock
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(()-> accessResource());
		t1.start();
		Thread t2 = new Thread(()-> accessResource());
		t2.start();
		Thread t3 = new Thread(()-> accessResource());
		t3.start();
		Thread t4 = new Thread(()-> accessResource());
		t4.start();
	}
}

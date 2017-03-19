package org.zeroturnaround.jf.homework7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccountLock {

  private final ReadWriteLock lock = new ReentrantReadWriteLock();

  /**
   * Multiple account donators can enter this lock section
   * @return Lock
   */
  public Lock writeLock() {
    return lock.readLock();
  }

  /**
   * Only one accounts reader can enter this lock section
   * and only if no donator threads are currently writing
   * @return Lock
   */
  public Lock readLock() {
    return lock.writeLock();
  }

}

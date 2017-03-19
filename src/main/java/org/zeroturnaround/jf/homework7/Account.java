package org.zeroturnaround.jf.homework7;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {

  private static final AtomicInteger COUNTER = new AtomicInteger(0);
  private final Object lock = new Object();

  private int id;
  private int balance;

  public Account(int initialBalance) {
    id = COUNTER.incrementAndGet();
    balance = initialBalance;
  }

  public int getBalance() {
    synchronized (lock) {
      return balance;
    }
  }

  public void transferTo(Account targetAccount) {
    synchronized (lock1(targetAccount)) {
      synchronized (lock2(targetAccount)) {
        balance--;
        targetAccount.balance++;
      }
    }
  }

  private Object lock1(Account targetAccount) {
    return id < targetAccount.id ? lock : targetAccount.lock;
  }

  private Object lock2(Account targetAccount) {
    return id < targetAccount.id ? targetAccount.lock : lock;
  }

}
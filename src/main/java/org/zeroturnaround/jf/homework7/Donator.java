package org.zeroturnaround.jf.homework7;

import java.util.List;

public class Donator implements Runnable {

  private final Account account;
  private final List<Account> targetAccounts;
  private volatile boolean isDone;
  private AccountLock accountLock;

  public Donator(Account account, List<Account> targetAccounts, AccountLock accountLock) {
    this.account = account;
    this.targetAccounts = targetAccounts;
    this.accountLock = accountLock;
  }

  @Override
  public void run() {
    targetAccounts.forEach(this::transferTo);
    isDone = true;
  }

  /**
   * Transfers 1 unit of money from {@link #account} to {@code targetAccount} in a thread-safe, deadlock-free manner.
   * Sleeps for 100ms after every transfer.
   */
  private void transferTo(Account targetAccount) {
    accountLock.writeLock().lock();
    account.transferTo(targetAccount);
    accountLock.writeLock().unlock();
    sleep(100);
  }

  private void sleep(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      throw new RuntimeInterruptedException(e);
    }
  }

  public boolean isDone() {
    return isDone;
  }
}

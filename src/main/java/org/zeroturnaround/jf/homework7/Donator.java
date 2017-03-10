package org.zeroturnaround.jf.homework7;

import java.util.List;

public class Donator implements Runnable {

  private final Account account;
  private final List<Account> targetAccounts;

  public Donator(Account account, List<Account> targetAccounts) {
    this.account = account;
    this.targetAccounts = targetAccounts;
  }

  @Override
  public void run() {
    targetAccounts.forEach(this::transferTo);
  }

  /**
   * Transfers 1 unit of money from {@link #account} to {@code targetAccount} in a thread-safe, deadlock-free manner.
   * Sleeps for 100ms after every transfer.
   */
  private void transferTo(Account targetAccount) {
    // FIXME
  }
}

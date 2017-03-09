package org.zeroturnaround.jf.homework7;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class BankSimulator {
  private static final PrintStream OUT = new PrintStream(new BufferedOutputStream(System.out));

  private final List<Account> accounts;
  private final List<Donator> donators;

  public BankSimulator(int n) {
    accounts = IntStream.range(0, n).mapToObj(i -> new Account(n)).collect(toList());
    donators = accounts.stream().map(a -> new Donator(a, targetAccountsFor(a))).collect(toList());
  }

  private List<Account> targetAccountsFor(Account account) {
    List<Account> targetAccounts = new ArrayList<>(accounts);
    targetAccounts.remove(account);
    Collections.shuffle(targetAccounts);
    return targetAccounts;
  }

  public void startTransfers() {
    donators.stream().map(Thread::new).forEach(Thread::start);
  }

  /**
   * Returns {@code false} when all transfers have completed ({@code true} otherwise) in a thread-safe, deadlock-free manner.
   */
  public boolean isRunning() {
    return true; // FIXME
  }

  /**
   * Returns balances of all {@link #accounts} in a thread-safe, deadlock-free manner.
   */
  List<Integer> getBalances() {
    return new ArrayList<>(); // FIXME
  }

  public void printInitialBalancesAndTotal() {
    printBalancesAndTotal();
    OUT.println();
  }

  public void printBalancesAndTotal() {
    List<Integer> balances = getBalances();

    OUT.print(balances.stream().map(this::pad).collect(joining(" ")));
    OUT.println(" " + pad(balances.stream().mapToInt(Integer::intValue).sum()));
  }

  private String pad(Integer value) {
    return String.format("%2d", value);
  }

  public void printFinalBalancesAndTotal() {
    OUT.println();
    printBalancesAndTotal();
    OUT.flush();
  }
}
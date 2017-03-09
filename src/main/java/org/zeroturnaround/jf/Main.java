package org.zeroturnaround.jf;

import org.zeroturnaround.jf.homework7.BankSimulator;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    if (args.length < 1) {
      System.err.println("Usage: java -jar target/jf-homework7.jar n");
      System.exit(0);
    }

    int n = Integer.parseInt(args[0]);

    BankSimulator simulator = new BankSimulator(n);

    simulator.printInitialBalancesAndTotal();
    simulator.startTransfers();

    while (simulator.isRunning()) {
      simulator.printBalancesAndTotal();
      Thread.sleep(100L);
    }

    simulator.printFinalBalancesAndTotal();
  }
}

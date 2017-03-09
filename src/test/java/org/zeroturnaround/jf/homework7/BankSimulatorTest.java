package org.zeroturnaround.jf.homework7;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import org.junit.Test;

public class BankSimulatorTest {

  public void transfersAreCorrectWith(int n) {
    BankSimulator simulator = new BankSimulator(n);

    assertThatInitialStateIsCorrect(simulator, n);

    simulator.startTransfers();

    assertThatSumIsConsistent(simulator, n);

    AtomicReference<RuntimeException> exception = new AtomicReference<>();

    Runnable atRandomTimeMomentsAssertThatSumIsConsistent = () -> {
      while (simulator.isRunning()) {
        if (exception.get() != null) {
          return;
        }

        try {
          assertThat(simulator.getBalances().stream().mapToInt(Integer::intValue).sum()).isEqualTo(n * n);
          Thread.sleep(50L);
        }
        catch (Throwable e) {
          exception.set(new RuntimeException(e));
        }
      }
    };

    IntStream.range(0, 50).forEach(i -> new Thread(atRandomTimeMomentsAssertThatSumIsConsistent).start());

    assertThatSumIsConsistent(simulator, n);

    while (simulator.isRunning()) {
      if (exception.get() != null) {
        throw exception.get();
      }

      assertThatSumIsConsistent(simulator, n);

      try {
        Thread.sleep(50L);
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void assertThatInitialStateIsCorrect(BankSimulator simulator, int n) {
    assertThat(simulator.getBalances()).isEqualTo(IntStream.range(0, n).mapToObj(i -> n).collect(toList()));
  }

  private void assertThatSumIsConsistent(BankSimulator simulator, int n) {
    assertThat(simulator.getBalances().stream().mapToInt(Integer::intValue).sum()).isEqualTo(n * n);
  }

  @Test
  public void transfersAreCorrentWith_n_1() {
    transfersAreCorrectWith(1);
  }

  @Test
  public void transfersAreCorrentWith_n_5() {
    transfersAreCorrectWith(5);
  }

  @Test
  public void transfersAreCorrentWith_n_10() {
    transfersAreCorrectWith(10);
  }

  @Test
  public void transfersAreCorrentWith_n_15() {
    transfersAreCorrectWith(15);
  }

  @Test
  public void transfersAreCorrentWith_n_25() {
    transfersAreCorrectWith(25);
  }

  @Test
  public void transfersAreCorrentWith_n_50() {
    transfersAreCorrectWith(50);
  }

  @Test
  public void transfersAreCorrentWith_n_100() {
    transfersAreCorrectWith(100);
  }
}

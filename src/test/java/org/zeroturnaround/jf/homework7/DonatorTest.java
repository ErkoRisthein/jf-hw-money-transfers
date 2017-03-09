package org.zeroturnaround.jf.homework7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class DonatorTest {

  @Test
  public void donatesOneUnitPerRunToTargetAccounts() {
    Account account1 = new Account(5);
    Account account2 = new Account(17);
    Account account3 = new Account(8);
    Donator donator = new Donator(account1, Arrays.asList(account2, account3));

    donator.run();

    assertThat(account1.getBalance()).isEqualTo(3);
    assertThat(account2.getBalance()).isEqualTo(18);
    assertThat(account3.getBalance()).isEqualTo(9);
  }
}

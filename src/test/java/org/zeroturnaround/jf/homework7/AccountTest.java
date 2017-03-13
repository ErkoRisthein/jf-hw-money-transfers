package org.zeroturnaround.jf.homework7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AccountTest {

  @Test
  public void setsInitialBalance() {
    Account account = new Account(5);

    assertThat(account.getBalance()).isEqualTo(5);
  }
}

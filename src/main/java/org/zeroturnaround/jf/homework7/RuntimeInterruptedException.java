package org.zeroturnaround.jf.homework7;

import java.util.Objects;

public class RuntimeInterruptedException extends RuntimeException {

  public RuntimeInterruptedException(InterruptedException cause) {
    super(Objects.requireNonNull(cause));
  }
}

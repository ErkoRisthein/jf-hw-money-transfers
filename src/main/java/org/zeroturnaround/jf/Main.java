package org.zeroturnaround.jf;

public class Main {

  public static void main(String[] args) {
    if (args.length < 1) {
      System.err.println("Usage: java -jar target/jf-homework7.jar n");
      System.exit(0);
    }

    int n = Integer.parseInt(args[0]);


  }
}

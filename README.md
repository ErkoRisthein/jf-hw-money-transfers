Java Fundamentals - Homework 7
===========
Description
-------------------

You are given a bank simulator program, which demonstrates concurrent transfers of money.
* The program creates **n** number of accounts each having **n** as its initial balance. **n** is taken from the program’s main arguments.
* The program creates a **donator thread per account** with a **source account** and a **list of target accounts** - a shuffled list of all accounts except the source one.
* Every donator thread transfers **1 unit of money** from the **source account** to **every recipient account** sleeping _100ms_ after each transfer. After those transfers the thread stops.
* Bank simulator prints all balances before starting the transfers, after the transfers have finished and during the transfers once per _100ms_. Printing is done in the main thread in parallel with transfers.
* Printing format: **balance<sub>1</sub> balance<sub>2</sub> balance<sub>3</sub> ... balance<sub>n</sub> total**

Some of the things mentioned above are not implemented correctly or not implemented at all. Your task is to implement them in a thread-safe, deadlock-free manner.

Run the tests to verify your solution.

Requirements
-----------------------
1) Implement `Donator#transferTo(targetAccount)`:
```java
/**
 * Transfers 1 unit of money from {@link #account} to {@code targetAccount} in a thread-safe, deadlock-free manner.
 */
private void transferTo(Account targetAccount) {
  // FIXME
}
```
2) Implement `BankSimulator#getBalances()`:
```java
/**
 * Returns balances of all {@link #accounts} in a thread-safe, deadlock-free manner.
 */
List<Integer> getBalances() {
  return new ArrayList<>(); // FIXME
}
```
3) Implement `BankSimulator#isRunning()`:
```java
/**
 * Returns {@code false} when all transfers have completed ({@code true} otherwise) in a thread-safe, deadlock-free manner.
 */
public boolean isRunning() {
  return true; // FIXME
}
```
4) Tests must pass.

5) Don’t use `exit()` or `halt()` to stop the program.

6) **Format the code consistently! Points will be deducted for inconsistent code style!!**

Various tips
-----------------------

1. Consider using `ReadWriteLock` in `Donator#transferTo` and `BankSimulator#getBalances` to stop all transfers while reading balances. Remember that read lock cannot be acquired while write lock is being held.
2. To implement the requirements you might need to modify existing code as well.
3. `BankSimulatorTest` is not a 100% guarantee that your code is thread-safe, but it gives you a good-enough confidence. Run it multiple times to be sure.
4. If you still want to build the application without fixing the tests, then you can do that by skipping them in the build by adding `-DskipTests` to the command:
```shell
./mvnw clean package -DskipTests
```

Sample output
-----------------------
```
java -jar target/jf-homework7.jar 20
20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 400

20 20 20 20 22 20 20 19 20 20 21 19 19 20 22 20 19 20 19 20 400
20 19 19 21 25 23 19 18 20 20 20 18 19 20 21 21 19 20 18 20 400
19 19 20 21 27 23 19 17 19 19 19 19 18 21 20 21 19 22 18 20 400
19 19 20 22 26 22 20 17 18 22 18 18 17 21 19 23 19 22 19 19 400
21 19 21 22 25 21 22 16 19 22 17 18 17 22 18 22 18 21 20 19 400
21 19 20 22 25 20 22 15 20 23 20 17 18 22 18 22 17 20 20 19 400
21 19 19 25 24 21 21 16 19 22 19 18 19 21 17 21 17 19 23 19 400
20 18 20 26 25 21 21 15 19 23 21 18 19 20 16 24 16 18 22 18 400
19 18 19 25 25 21 20 15 19 22 22 17 19 20 20 24 15 20 21 19 400
19 18 22 24 25 21 20 14 20 22 21 16 18 21 22 23 15 20 20 19 400
18 17 22 24 25 21 20 16 22 21 20 18 18 21 21 22 14 19 21 20 400
17 16 22 23 24 21 23 17 22 22 19 17 20 22 20 21 14 20 20 20 400
18 19 22 23 23 21 23 17 22 22 19 16 19 21 19 20 16 20 21 19 400
20 19 21 22 22 20 22 17 21 22 19 17 19 22 19 22 17 20 20 19 400
20 19 20 22 21 20 22 18 20 21 18 18 18 22 20 22 20 20 19 20 400
21 20 20 22 20 20 21 18 20 22 18 19 17 21 20 21 20 20 21 19 400
20 19 21 22 19 21 21 20 20 21 20 18 20 20 19 21 19 19 21 19 400
20 19 21 21 19 21 20 21 21 20 19 19 20 20 19 21 19 21 21 18 400
20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 400

20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 400
```

```
java -jar target/jf-homework7.jar 10
10 10 10 10 10 10 10 10 10 10 100

 9 11  9  9 10 11 11  9 11 10 100
 9 10 10 11 11 10 12  8 10  9 100
 9  9  9 13 12 10 11  8 10  9 100
 8  8 10 13 11 11 10  9 10 10 100
10  7 11 13 10 10  9  9 10 11 100
10  6 11 12 10  9 10 11  9 12 100
10  7 10 11 10 10  9 11 11 11 100
11  9 10 10  9 11  9 10 11 10 100
10 10 10 10 10 10 10 10 10 10 100

10 10 10 10 10 10 10 10 10 10 100
```

Submitting your assignment
--------------------------

For your convenience, we have set up the Maven project to ZIP up all files in your project folder so it is easy for you to attach it to an e-mail and send it our way. All you need to do is to execute the following command in your project folder:

```
./mvnw clean deploy
```

It will ask you for your full name, Student Book Number (also known as *matrikli number*) and a comment (optional).

Example:

```bash
./mvnw clean deploy

#...skipping building, testing and packaging output from Maven...

[INFO] --- maven-antrun-plugin:1.8:run (package homework ZIP) @ homework7 ---
[INFO] Executing tasks

main:
Your full name (e.g. John Smith):
Jane Smith
Your Student Book Number (matrikli number, e.g. B12345):
B12345
Comment:
Java IO
      [zip] Building zip: /Users/jane/workspace/jf-hw-money-transfers/target/jf-homework7-B12345.zip
   [delete] Deleting: /Users/jane/workspace/jf-hw-money-transfers/homework.properties
[INFO] Executed tasks
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 20.041 s
[INFO] Finished at: 2017-02-03T11:35:11+02:00
[INFO] Final Memory: 21M/283M
[INFO] ------------------------------------------------------------------------
```

After Maven has finished, you can find the generated ZIP file in *target* folder with name such as 
*jf-homework7-B12345.zip* (it contains your Student Book Number/matrikli number and homework number).

The only thing left to do now is to send the ZIP file as an attachment to an e-mail with subject **"Homework 7 - *your Student Book Number/maktrikli number*"** to *jf@zeroturnaround.com*.
Java Fundamentals - Homework 7
===========
Description
-------------------

Write a Java program which demonstrates concurrent transfers of money.

Requirements
-----------------------

1. Create **n** number of accounts with each having **n** as its initial balance. Take **n** from the program’s main arguments. 
2. Implement a method for transferring a given amount from one account to another. 
3. Implement a method for printing balances of all accounts as well as their sum. Output form (single line): **b<sub>1</sub> b<sub>2</sub> b<sub>3</sub> ... b<sub>n</sub> sum**.
4. For each (source) account create a donator thread with a list of recipients - a shuffled list of all accounts except the source one.
5. A donator thread must transfer 1 unit from source account to each recipient account sleeping 100ms after each transfer. After those transfers, the thread must stop.
6. Print all balances before starting the transfers, after the transfers have finished and during the transfers once per 100ms. 
7. Transfers must be thread safe and run concurrently if they have no accounts in common – lock on the source and target accounts but avoid deadlocks. 
8. Printing all balances must be thread safe. The sum of all accounts must stay consistent. Stop all transfers while printing the balances - use `ReadWriteLock.writeLock()` around printing the balances and a `ReadWriteLock.readLock()` around each transfer.
9. Create all donator threads before actually starting them.
10. Buffer program’s output `PrintStream out = new PrintStream(new BufferedOutputStream(System.out));`
11. After all donator threads are finished, print all balances and `flush()` the program’s output.
12. Don’t use `exit()` or `halt()` to stop the program.

Various tips
============

If you still want to build the application without fixing the tests, then you can do that by skipping them in the build by adding `-DskipTests` to the command:
```shell
./mvnw clean package -DskipTests
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
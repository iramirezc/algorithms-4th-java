# Exercises Chapter 1: Fundamentals

## 1.1 Basic Programming Model

### 1.1 Exercises

**1.1.1 Give the value of each of the following expressions:**

a. `(0 + 15) / 2`

> 7

b. `2.0e-6 * 100000000.1`

> 200.0000002

c. `true && false || true && true`

> true

**1.1.2 Give the type and value of each of the following expressions:**

a. `(1 + 2.236)/2`

> (double) 1.618

b. `1 + 2 + 3 + 4.0`

> (double) 10.0

c. `4.1 >= 4`

> (boolean) true

d. `1 + 2 + 3`

> (int) 6

**1.1.3 Write a program that takes three integer command-line arguments and prints `equal` if all three are equal, and `not equal` otherwise.**

> Solution -> [Exercise_1_1_3.java](./code/Exercise_1_1_3.java)

```java
public static void main(String[] args) throws Exception {
  if (args.length != 3) {
    throw new Exception("Must provide exactly 3 numbers");
  }

  int n1 = Integer.parseInt(args[0]);
  int n2 = Integer.parseInt(args[1]);
  int n3 = Integer.parseInt(args[2]);

  boolean result = n1 == n2 && n2 == n3;

  StdOut.println(result ? "equal" : "not equal");
}
```

**1.1.4 What (if anything) is wrong with each of the following statements?**

a. `if (a > b) then c = 0;`

> Syntax Error. `then` is not part of Java's syntax

b. `if a > b { c = 0; }`

> Syntax Error. `if` statement should have pharentesis `()`

c. `if (a > b) c = 0;`

> nothing is wrong.

d. `if (a > b) c = 0 else b = 0;`

> Syntax Error. Missing `;`

**1.1.5 Write a code fragment that prints `true` if the double variables `x` and `y` are both strictly between 0 and 1 and `false` otherwise.**

> Solution:

```java
boolean result = (x > 0 && x < 1) && (y > 0 && y < 1);
StdOut.println(result);
```

**1.1.6 What does the following program print?**

```java
int f = 0;
int g = 1;
for (int i = 0; i <= 15; i++) {
  StdOut.println(f);
  f = f + g; // 13
  g = f - g; // 8
}
```

> Prints the first 15th elements of the Fibonacci series:
>
> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610

**1.1.7 Give the value printed by each of the following code fragments:**

a)

```java
double t = 9.0;
while (Math.abs(t - 9.0/t) > 0.001)
  t = (9.0/t + t) / 2.0;
StdOut.printf("%.5f\n", t);
```

> 3.00009

b)

```java
int sum = 0;
for (int i = 1; i < 1000; i++)
  for (int j = 0; j < i; j++)
    sum++;
StdOut.println(sum);
```

> using the formula: `n (n + 1) / 2`
>
> (999 * 1000) / 2 = 499500

c)

```java
int sum = 0;
for (int i = 1; i < 1000; i *= 2)
  for (int j = 0; j < 1000; j++)
    sum++;
StdOut.println(sum);
```

> 10,000

**1.1.8 What do each of the following print?**

a. `System.out.println("b");`

> 'b\n'

b. `System.out.println("b" + "c");`

> 'bc\n'

c. `System.out.println((char) ('a' + 4));`

> Error: `'a' + 4` is a `String`, casting to `char` will cause an error.

**1.1.9 Write code fragment that puts the binary representation of a positive integer `n` into a String `s`.**

> Solution -> [Exercise_1_1_9.java](./code/Exercise_1_1_9.java)

```java
public static String toBinaryString(int n) {
  String s = "";

  for (int k = n; k > 0; k /= 2) {
    s = (k % 2) + s;
  }

  return s;
}
```

**1.1.10 What is wrong with the following code fragment?**

```java
int[] a;
for (int i = 0; i < 10; i++)
  a[i] = i * i;
```

> Size for array `a` is not initialized.

**1.1.11 Write a code fragment that prints the contents of a two-dimensional boolean array, using `*` to represent `true` and a `space` to represent `false`. Include row and column numbers.**

> Solution -> [Exercise_1_1_11.java](./code/Exercise_1_1_11.java)

```java
public static String printBoard(boolean[][] board) {
  String cols = " ";
  String s = "";

  for (int i = 0; i < board.length; i++) {
    s += (i + 1);
    for (int j = 0; j < board[i].length; j++) {
      if (i == 0)
        cols += (" " + (j + 1) + " ");
      s += board[i][j] ? " * " : "   ";
    }
    if (i == 0)
      cols += '\n';
    s += '\n';
  }

  return cols + s;
}
```

**1.1.12 What does the following code fragment print?**

```java
int[] a = new int[10];
for (int i = 0; i < 10; i++)
  a[i] = 9 - i;
for (int i = 0; i < 10; i++)
  a[i] = a[a[i]];
for (int i = 0; i < 10; i++)
  System.out.println(a[i]);
```

> 0, 1, 2, 3, 4, 4, 3, 2, 1, 0

**1.1.13 Write a code fragment to print the *transposition* (rows and columns changed) of a two-dimensional array with *m* rows and *n* columns.**

> Solution -> [Exercise_1_1_13.java](./code/Exercise_1_1_13.java)

```java
public static int[][] transpose(int[][] a) {
  int rows = a.length;
  int cols = a[0].length;
  int[][] transposed = new int[cols][rows];

  for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
      transposed[j][i] = a[i][j];
    }
  }

  return transposed;
}
```

**1.1.14 Write a static method `lg()` that takes an `int` value `n` as argument and returns the largest `int` not larger than the base-2 logarithm of `n`. Do NOT use `Math`.**

> Solution -> [Exercise_1_1_14.java](./code/Exercise_1_1_14.java)

```java
public static int lg(int n) {
  int exp = 0;
  int result = 1;
  int BASE = 2;

  while (result * BASE <= n) {
    result *= BASE;
    exp++;
  }

  return exp;
}
```

**1.1.15 Write a static method `histogram()` that takes an array `a[]` of `int` values and an integer `m` as arguments and returns and array of length `m` whose `ith` entry is the number of times the integer `i` apperead in the argument array. If the values in `a[]` are all between `0` and `m-1`, the sum of the values in the returned array should be equal to `a.length`.**

> Solution -> [Exercise_1_1_15.java](./code/Exercise_1_1_15.java)

```java
public static int[] histogram(int[] a, int m) {
  int[] h = new int[m];

  for (int i = 0; i < h.length; i++) {
    int sum = 0;
    for (int j = 0; j < a.length; j++) {
      if (a[j] == i)
        sum++;
    }
    h[i] = sum;
  }

  return h;
}
```

**1.1.16 Give the value of `exR1(6):`**

```java
public static String exR1(int n) {
  if (n <= 0) return "";
  return exR1(n - 3) + n + exR1(n - 2) + n;
}
```

> 311361142246

**1.1.17 Criticize the following recursive function:**

```java
public static String exR2(int n) {
  String s = exR2(n - 3) + n + exR2(n - 2) + n;
  if (n <= 0) return "";
  return s;
}
```

> Base case will never be reached. Infinite recursive call. Stack Overflow Error.

**1.1.18 Consider the following recursive function:**

```java
public static int mystery(int a, int b) {
  if (b == 0) return 0;
  if (b % 2 == 0) return mystery(a + a, b / 2);
  return mystery(a + a, b / 2) + a;
}
```

**What are the values of `mystery(2, 25)` and `mystery(3, 11)`?**

> `50` and `33`

**Given positive integers `a` and `b`, describe what value `mystery(a, b)` computes.**

> it returns the product of `a` times `b`

**Answer the same question, but replace the three `+` operators with `*` and replace `return 0` with `return 1`.**

```java
public static int mystery2(int a, int b) {
  if (b == 0) return 1;
  if (b % 2 == 0) return mystery2(a * a, b / 2);
  return mystery(a * a, b / 2) * a;
}
```

**What are the values of `mystery2(2, 25)` and `mystery2(3, 11)`?**

> `33554432` and `177147`

**Given positive integers `a` and `b`, describe what value `mystery2(a, b)` computes.**

> it returns the power of number base `a` to exponent `b`

**1.1.19 Run the following program on your computer:**

```java
public class Fibonacci {
  public static long fibonacci(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void main(String[] args) {
    for (int n = 0; n < 90; n++) {
      StdOut.println(n + " " + fibonacci(n));
    }
  }
}
```

**What is the largest value of `n` for which this program takes less than 1 hour to compute the value of `fibonacci(n)`?**

> 55?

**Develop a better implementation of `fibonacci(n)` that saves computed values in an array.**

> Solution -> [Exercise_1_1_19.java](./code/Exercise_1_1_19.java)

**1.1.20 Write a recursive static method that computes the value of `ln(n!)`.**

> // TODO

**1.1.21 Write a program that reads in lines from standard input with each line containing a name and two integers and then uses `printf()` to print a table with a column of the names, the integers, and the result of dividing the first by the second accurate to three decimal places. You could use a program like this to tabulate batting averages for baseball players or grades for students.**

> // TODO

**1.1.22 Write a version of `BinarySearch` that uses the recursive `indexOf` given on page 25 and *traces* the method calls. Each time the recursive method is called, print the argument values `lo` and `hi`, indented by the depth of the recursion. *Hint:* Add an argument to the recursive method that keeps track of the depth.**

> // TODO

**1.1.23 Add to the `BinarySearch` test client the ability to respond to a second argument: `+` to print numbers from standard input that *are NOT* in the whitelist, `-` to print numbers that *are* in the whitelist.**

> // TODO

**1.1.24 Give the sequence of values of `p` and `q` that are computed when Euclid's algorithm is used to compute the greatest common divisor of `105` and `24`.**

> // TODO

**Extend the code given on page 4 to develop a program `Euclid` that takes two integers from the command line and computes their greatest common divisor, printing out the two arguments for each call on the recursive method. Use your program to compute the greatest common divisor of `1111111` and `1234567`.**

> // TODO

**1.1.25 Use mathematical induction to prove that Euclid's algorithm computes the greatest common divisor of any pair of nonnegative integers `p` and `q`.**

> // TODO

### 1.1 Creative Problems

**1.1.26 Sorting...**

### 1.1 Experiments

## 1.2 Data Abstraction

## 1.3 Bags, Queues, and Stack

## 1.4 Analysis of Algorithms

## 1.5 Case Study: Union-Find
# Exercises Chapter 1: Fundamentals

[<- index](../index.md)

## 1.1 Basic Programming Model

### Exercises

---

**1.1.1 Give the value of each of the following expressions:**

> Solution -> [Exercise_1_1_1.java](./Exercise_1_1_1.java)
>
> Note: You should figure it out by yourself before running the code.

a. `(0 + 15) / 2`

> 7

b. `2.0e-6 * 100000000.1`

> 200.0000002

c. `true && false || true && true`

> true

**1.1.2 Give the type and value of each of the following expressions:**

> Solution -> [Exercise_1_1_2.java](./Exercise_1_1_2.java)
>
> Note: You should figure it out by yourself before running the code.

a. `(1 + 2.236)/2`

> (double) 1.618

b. `1 + 2 + 3 + 4.0`

> (double) 10.0

c. `4.1 >= 4`

> (boolean) true

d. `1 + 2 + 3`

> (int) 6

**1.1.3 Write a program that takes three integer command-line arguments and prints `equal` if all three are equal, and `not equal` otherwise.**

> Solution -> [Exercise_1_1_3.java](./Exercise_1_1_3.java)

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

> Solution -> [Exercise_1_1_9.java](./Exercise_1_1_9.java)

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

> Solution -> [Exercise_1_1_11.java](./Exercise_1_1_11.java)

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

> Solution -> [Exercise_1_1_13.java](./Exercise_1_1_13.java)

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

> Solution -> [Exercise_1_1_14.java](./Exercise_1_1_14.java)

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

> Solution -> [Exercise_1_1_15.java](./Exercise_1_1_15.java)

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

> 58 (see [results](./Exercise_1_1_19.md))

**Develop a better implementation of `fibonacci(n)` that saves computed values in an array.**

> Solution -> [Exercise_1_1_19.java](./Exercise_1_1_19.java)

```java
public static long betterFibonacci(int n, long[] fib) {
  if (fib[n] == -1)
    fib[n] = betterFibonacci(n - 1, fib) + betterFibonacci(n - 2, fib);

  return fib[n];
}
```

**1.1.20 Write a recursive static method that computes the value of `ln(n!)`.**

> Solution -> [Exercise_1_1_20.java](./Exercise_1_1_20.java)

```java
public static int factorial(int n) {
  if (n <= 1)
    return 1;
  return n * factorial(n - 1);
}

// I know this method is not recursive,
// I might come later to fix it.
// ln(3!) = ln(3) + ln(2) + ln(1)
public static int ln(int n) {
  int nFactorial = factorial(n);
  int exp = 0;
  double result = 1.0;

  while (result * Math.E <= nFactorial) {
    result *= Math.E;
    exp++;
  }

  return exp;
}
```

**1.1.21 Write a program that reads in lines from standard input with each line containing a name and two integers and then uses `printf()` to print a table with a column of the names, the integers, and the result of dividing the first by the second accurate to three decimal places. You could use a program like this to tabulate batting averages for baseball players or grades for students.**

> Solution -> [Exercise_1_1_21.java](./Exercise_1_1_21.java)

```java
public static void main(String[] args) {
  while (StdIn.hasNextLine()) {
    String [] line = StdIn.readLine().split("\\s+");
    String name = line[0];
    int n1 = Integer.parseInt(line[1]);
    int n2 = Integer.parseInt(line[2]);
    double n3 =  n1 / (double) n2;

    StdOut.printf("%-10s %5d %5d %-5s %3.3f\n", name, n1, n2, "", n3);
  }
}
```

**1.1.22 Write a version of `BinarySearch` that uses the recursive `indexOf` given on page 25 and *traces* the method calls. Each time the recursive method is called, print the argument values `lo` and `hi`, indented by the depth of the recursion. *Hint:* Add an argument to the recursive method that keeps track of the depth.**

> Solution -> [Exercise_1_1_22.java](./Exercise_1_1_22.java)

```java
public static int indexOf(int[] a, int target, int lo, int hi, int calls) {
  String format = "%" + calls + "s %d) -> lo: %-3d hi: %-3d\n";
  StdOut.printf(format, "", calls, lo, hi);

  if (lo > hi)
    return -1;
  int mid = lo + (hi - lo) / 2;
  if (a[mid] > target) {
    return indexOf(a, target, lo, mid - 1, ++calls);
  } else if (a[mid] < target) {
    return indexOf(a, target, mid + 1, hi, ++calls);
  } else {
    return mid;
  }
}
```

**1.1.23 Add to the `BinarySearch` test client the ability to respond to a second argument: `+` to print numbers from standard input that *are NOT* in the whitelist, `-` to print numbers that *are* in the whitelist.**

> Solution -> [Exercise_1_1_23.java](./Exercise_1_1_23.java)

```java
public static void main(String[] args) {
  In in = new In(args[0]);
  int[] whitelist = in.readAllInts();
  String sense = args[1];

  Arrays.sort(whitelist);

  while (!StdIn.isEmpty()) {
    int key = StdIn.readInt();
    int index = indexOf(whitelist, key);
    // not in the whitelist
    if (sense.equals("+") && index == -1) {
      StdOut.println(key);
      // in the whitelist
    } else if (sense.equals("-") && index != -1) {
      StdOut.println(key);
    }
  }
}
```

**1.1.24 Give the sequence of values of `p` and `q` that are computed when Euclid's algorithm is used to compute the greatest common divisor of `105` and `24`.**

> `9`
>
> `6`
>
> `3`
>
> `0`

**Extend the code given on page 4 to develop a program `Euclid` that takes two integers from the command line and computes their greatest common divisor, printing out the two arguments for each call on the recursive method. Use your program to compute the greatest common divisor of `1111111` and `1234567`.**

> Solution -> [Exercise_1_1_24.java](./Exercise_1_1_24.java)

```sh
p: 1111111 q: 1234567
p: 1234567 q: 1111111
p: 1111111 q: 123456
p: 123456 q: 7
p: 7 q: 4
p: 4 q: 3
p: 3 q: 1
p: 1 q: 0
gcd(1111111, 1234567) = 1
```

**1.1.25 Use mathematical induction to prove that Euclid's algorithm computes the greatest common divisor of any pair of nonnegative integers `p` and `q`.**

> // TODO

### Creative Problems

---

**1.1.26 *Sorting three numbers.* Suppose that the variables `a`, `b`, `c` and `t` are all of the same numeric primitive type. Show that the following code puts `a`, `b` and `c` in ascending order:**

```java
if (a > b) { t = a; a = b; b = t; }
if (a > c) { t = a; a = c; c = t; }
if (b > c) { t = b; b = c; c = t; }
```

> demonstration ->
>
> NOTE: not sure if this is the correct way to "show"

```java
int a = 3;
int b = 2;
int c = 1;
int t;

if (a > b) { t = a; a = b; b = t; }
//  3 > 2 ?  t = 3; a = 2; b = 3;
// new values: a = 2, b = 3, c = 1
if (a > c) { t = a; a = c; c = t; }
//  2 > 1 ?  t = 2, a = 1, c = 2
// new values: a = 1, b = 3, c = 2
if (b > c) { t = b; b = c; c = t; }
//  3 > 2 ?  t = 3, b = 2, c = 3
// new values = a = 1, b = 2, c = 3
```

**1.1.27 *Binomial distribution.* Estimate the number of recursive calls that would be used by the code:**

```java
public static double binomial(int n, int k, double p) {
  if ((n == 0) && (k == 0)) return 1.0;
  if ((n <  0) || (k  < 0)) return 0.0;
  return (1 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
}
```

**to compute `binomial(100, 50, 0.25)`.**

> Estimated total calls: // TODO

**Develop a better implementation that is based on saving computed values in an array.**

> // TODO

**1.1.28 *Remove duplicates.* Modify the test client in `BinarySearch` to remove any duplicate keys in the whitelist after the sort.**

> Solution -> [Exercise_1_1_28.java](./Exercise_1_1_28.java)

**1.1.29 *Equal keys.* Add to `BinarySearch` a static method `rank()` that takes a sorted array of `int` values (some of which may be equal) and a `key` as arguments and returns the number of elements that are smaller than the `key` and a similar method `count()` that returns the number of elements equal to the `key`. *Note*: if `i` and `j` are the values returned by `rank(a, key)` and `count(a, key)` respectively, then `a[i..i+j-1]` are the values in the array that are equal to the `key`.**

```java
// Not actual solution, just a demonstration.

int a    = [1, 2, 3, 4, 5, 5, 5, 6];
// indexes [0, 1, 2, 3, 4, 5, 6, 7]

int k = 5; /* key */

int i = BinarySearch.rank(a, k); /* 4 (less than k)*/
int j = BinarySearch.count(a, k); /* 3 (count of k) */

// a[i..(i+j-1)] are the values in the array equal to k
// a[4..(4+3-1)]
// a[4..6]
// a[4, 5, 6] = [5, 5, 5]
```

> Solution -> [Exercise_1_1_29.java](./Exercise_1_1_29.java)

**1.1.30 *Array exercise.* Write a code fragment that creates an `n-by-n` boolean array `a[][]` such that `a[i][j]` is `true` if `i` and `j` are relatively prime (have no common factors), and `false` otherwise.**

> Solution -> [Exercise_1_1_30.java](./Exercise_1_1_30.java)

**1.1.31 *Random connections.* Write a program that takes as command-line arguments an integer `n` and a double value `p` (between 0 and 1), plots `n` equally spaced dots fo size `0.05` on the circumference of a circle, and then, with probability `p` for each pair of points, draws a gray line connecting them.**

> Solution -> [Exercise_1_1_31.java](./Exercise_1_1_31.java)

**1.1.32 *Histogram.* Suppose that the standard input stream is a sequence of `double` values. Write a program that takes an integer `n` and two `double` values `lo` and `hi` from the command line and uses `StdDraw` to plot a histogram from the count of the numbers in the standard input stream that fall in each of the `n` intervals defined by dividing `(lo, hi)` into `n` equal-sized intervals.**

> // TODO

**1.1.33 *Matrix library.* Write a library `Matrix` that implements the following API:**

```java
public class Matrix {
  static double dot(double[] x, double[] y); // vector dot product
  static double[][] mult(double[][] a, double[][] b); // matrix-matrix product
  static double[][] transpose(double[][] a); // transpose
  static double[] mult(double[][] a, double[] x); // matrix-vector product
  static double[] mult(double[] y, double[][] a); // vector-vector product
}
```

> // TODO

**1.1.34 *Filtering.* Which of the following `require` saving all the values from standard input (in an array, say), and which could be implemented as a filter using only a fixed number of variables and arrays of fixed size (not dependent on `n`)? For each, the input comes from standard input and consists of `n` real numbers between `0` and `1`.**

- Print the maximum and minimum numbers.
> can be implemented as a filter. By having `max` and `min` variables and updating those when reading the values.
- Print the median of the numbers.
> requires saving all the values. We need to store all numbers from standard input and sort them, then we can select the median.
- Print the `k`th smallest value, for `k` less than `100`.
> can be implemented as filter. By having `min` and `minCount` variables.
- Print the sum of the squares of the numbers.
> can be implemented as a filter. By having only a `sum` variable to store the square of each number + `sum`.
- Print the average of the `n` numbers.
> can be implemented as a filter. By having `sum` and `count` variables.
- Print the percentage of numbers greater than the average.
> requires saving all the values. We need to store all numbers to get the average and then count all the numbers greater tha it.
- Print the `n` numbers in increasing order.
> requires saving all the values. We need to store all numbers and then sort them in increasing order.
- Print the `n` numbers in random order.
> requires saving all the values. We need to store all numbers and then print them in random order.

### Experiments

---

**1.1.35 *Dice simulation.* The following code computes the exact probability distribution for the sum of two dice:**

```java
int SIDES = 6;
int [] frequencies = new int[2 * SIDES + 1];
for (int i = 1; i <= SIDES; i++)
  for (int j = 1; j <= SIDES; j++)
    frequencies[i + j]++;

double[] probabilities = new double[2 * SIDES + 1];
for (int k = 2; k <= 2 * SIDES; k++)
  probabilities[k] = frequencies[k]/36.0;
```

The value `probabilites[k]` is the probability that the dice sum to `k`. Run experiments to validate this calculation simulating `n` dice throws, keeping track of the frequencies of occurence of each value when you compute the sum of two random integers between `1` and `6`. How large does `n` have to be before your empirical results match the exact results to three decimal places?

> // TODO

**1.1.36 *Empirical shuffle check.* Run computational experiments to check that our shuffling code on page 32 works as advertised. Write a program `ShuffleTest` that takes command-line arguments `m` and `n`, does `n` shuffles of an array of length `m` that is initialized with `a[i] = i` before each suffle, and prints an *m*-by-*m* table such that row `i` gives the number of times `i` wound up in position `j` for all `j`. All entries in the table should be close to `n/m`.**

> // TODO

**1.1.37 *Bad shuffling.* Suppose that you choose a random integer between `0` and `n-1` in our shuffling code instead of one between `i` and `n-1`. Show that the resulting order is *not* equally likely to be on of the `n!` possibilities. Run the test of the previous exercise for this version.**

> // TODO

**1.1.38 *Binary search versus brute-force search.* Write a program `BruteForceSearch` that uses the brute-force search method given on page 48 and compare its running time on your computer with that of `BinarySearch` for `largeW.txt` and `largeT.txt`.**

> // TODO

**1.1.39 *Random matches.* Write a `BinarySearch` client that takes an `int` value `trials` as command-line argument and runs the specified number of `trials` of the following experiment for `n = 10^3`, `10^4`, `10^5` and `10^6`: generate two arrays of `n` randomly generated positive six-digit `int` values, and find the number of values that appear in both arrays. For each value of `n`, print a table giving the average value of this quantity over all trials.**

> // TODO
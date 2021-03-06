import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * Exercise: 1.1.15
 * Description: Histogram.
 * Compilation: javac EX_1_1_15.java
 * Execution: java EX_1_1_15 <size>
 * Example(s):
 *
 * $ java EX_1_1_15 5
 * Array: [3, 3, 4, 0, 1]
 * Histogram: [1, 1, 0, 2, 1]
 * a.length : 5, sumHistogram : 5
 */
public class EX_1_1_15 {
  public static int[] createRandomArray(int n) {
    int[] a = new int[n];

    for (int i = 0; i < a.length; i++) {
      a[i] = StdRandom.uniform(n);
    }

    return a;
  }

  public static int[] histogram(int[] a, int m) {
    int[] h = new int[m];

    for (int j = 0; j < a.length; j++) {
      h[a[j]]++;
    }

    return h;
  }

  public static int sumHistogram(int[] h) {
    int sum = 0;

    for (int i = 0; i < h.length; i++) {
      sum += h[i];
    }

    return sum;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide an integer number as size for the histogram");
    }

    int size = Integer.parseInt(args[0]);
    int[] a = createRandomArray(size);
    int[] h = histogram(a, size);
    int sumH = sumHistogram(h);

    StdOut.println("Array: " + Arrays.toString(a));
    StdOut.println("Histogram: " + Arrays.toString(h));
    StdOut.printf("a.length : %d, sumHistogram : %d\n", a.length, sumH);
  }
}

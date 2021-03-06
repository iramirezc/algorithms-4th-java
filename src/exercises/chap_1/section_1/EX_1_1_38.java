import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise: 1.1.38
 * Description: BinarySearch vs BruteForceSearch
 * Compilation: javac EX_1_1_38.java
 * Execution: java EX_1_1_38 <whitelist> <input_data>
 * Example(s):
 *
 * $ java EX_1_1_38 ~/algs4-data/largeW.txt ~/algs4-data/largeT.txt
 * BinarySearch Total Time:
 *  2571.719616(ms) # 2.5 seconds
 * Not found: 367966
 *
 * BruteForceSearch Total Time:
 *  1976516.199976(ms) # 32.94 minutes!
 * Not found: 367966
 */
public class EX_1_1_38 {
  public static int binarySearch(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (key < a[mid])
        hi = mid - 1;
      else if (key > a[mid])
        lo = mid + 1;
      else
        return mid;
    }

    return -1;
  }

  public static int bruteForceSearch(int[] a, int key) {
    for (int i = 0; i < a.length; i++)
      if (a[i] == key)
        return i;

    return -1;
  }

  public static void runBFS(int[] whitelist, int[] data) {
    int notFound = 0;
    long start = System.nanoTime();

    for (int i = 0; i < data.length; i++) {
      if (bruteForceSearch(whitelist, data[i]) == -1) {
        notFound++;
      }
    }

    long end = System.nanoTime();
    double totalTimeInMS = (end - start) / (double) 1000000;

    StdOut.println("BruteForceSearch Total Time:");
    StdOut.println(" " + totalTimeInMS + "(ms)");
    StdOut.println("Not found: " + notFound + "\n");
  }

  public static void runBS(int[] whitelist, int[] data) {
    int notFound = 0;
    long start = System.nanoTime();

    Arrays.sort(whitelist);

    for (int i = 0; i < data.length; i++) {
      if (binarySearch(whitelist, data[i]) == -1) {
        notFound++;
      }
    }

    long end = System.nanoTime();
    double totalTimeInMS = (end - start) / (double) 1000000;

    StdOut.println("BinarySearch Total Time:");
    StdOut.println(" " + totalTimeInMS + "(ms)");
    StdOut.println("Not found: " + notFound + "\n");
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide: <white_list_file> <input_data>");
    }

    In whitelistFile = new In(args[0]);
    In dataFile = new In(args[1]);
    int[] whitelist = whitelistFile.readAllInts();
    int[] data = dataFile.readAllInts();

    runBS(whitelist, data);
    runBFS(whitelist, data);
  }
}

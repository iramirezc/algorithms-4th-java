import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1122.java
 * Execution: java E1122 <whitelist_file> < <input_stream>
 *
 * $ java E1122 ~/algs4-data/tinyW.txt < ~/algs4-data/tinyT.txt
 *   1) -> lo: 0   hi: 14
 *   2) -> lo: 0   hi: 6
 *    3) -> lo: 4   hi: 6
 *  1) -> lo: 0   hi: 14
 *   2) -> lo: 8   hi: 14
 *    3) -> lo: 8   hi: 10
 *     4) -> lo: 8   hi: 8
 *      5) -> lo: 9   hi: 8
 * ...
 */

/**
 * E1122. Binary Search - Recursive Implementation
 */
public class E1122 {
  public static int indexOf(int[] a, int target) {
    return indexOf(a, target, 0, a.length - 1, 1);
  }

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

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide the path to the whitelist file.");
    }

    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (indexOf(whitelist, key) == -1)
        StdOut.println(key);
    }
  }
}
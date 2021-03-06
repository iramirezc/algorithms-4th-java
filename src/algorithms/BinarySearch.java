import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * BinarySearch
 * Type: Algorithm
 * Description: Returns the index of the 'key' in the array 'a'.
 * Section: 1.1
 * Ref: p. 25 (recursive), 47
 * Compilation: javac BinarySearch.java
 * Execution: java BinarySearch <whitelist_file> < <input_file> | more
 * Example(s):
 *
 * $ java BinarySearch ~/algs4-data/tinyW.txt < ~/algs4-data/tinyT.txt | more
 * 50
 * 99
 * 13
 */
public class BinarySearch {
  public static int indexOf(int[] a, int key) {
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

  /**
   * Recursive implementation of BinarySearch
   */
  public static int indexOf(int[] a, int key, int lo, int hi) {
    if (lo > hi)
      return -1;

    int mid = lo + (hi - lo) / 2;

    if (key < a[mid])
      return indexOf(a, key, lo, mid - 1);
    if (key > a[mid])
      return indexOf(a, key, mid + 1, hi);
    else
      return mid;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide the <white_list_file_name>");
    }

    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      // recursive implementation
      if (indexOf(whitelist, key, 0, whitelist.length - 1) == -1)
        StdOut.println(key);
    }
  }
}

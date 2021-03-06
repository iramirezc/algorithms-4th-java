import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * BruteForceSearch
 * Type: Algorithm
 * Description: Returns the index of the 'key' in the array 'a'.
 * Section: 1.1
 * Ref: p. 48
 * Compilation: javac BruteForceSearch.java
 * Execution: java BruteForceSearch <whitelist_file> < <input_file> | more
 * Example(s):
 *
 * $ java BruteForceSearch ~/algs4-data/tinyW.txt < ~/algs4-data/tinyT.txt | more
 * 50
 * 99
 * 13
 */
public class BruteForceSearch {

  public static int indexOf(int[] a, int key) {
    for (int i = 0; i < a.length; i++)
      if (a[i] == key)
        return i;

    return -1;
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide the <white_list_file_name>");
    }

    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();

      if (indexOf(whitelist, key) == -1)
        StdOut.println(key);
    }
  }
}

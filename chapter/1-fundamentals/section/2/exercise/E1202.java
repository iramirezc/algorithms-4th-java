import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 * Compilation: javac E1202.java
 * Execution: java E1202 <n>
 *
 * $ java E1202 3
 * 1 2
 * 2 3
 * [2.0, 3.0] intersects [1.0, 2.0]
 * 1 5
 * [1.0, 5.0] intersects [1.0, 2.0]
 * [1.0, 5.0] intersects [2.0, 3.0]
 */

/**
 * E1202
 */
public class E1202 {

  public static String printIntervals(Interval1D[] intervals) {
    String output = "";

    for (int i = 0; i < intervals.length; i++) {
      output += intervals[i].toString() + '\n';
    }

    return output;
  }

  public static void intersectsWith(Interval1D interval, Interval1D[] intervals, int limit) {
    for (int i = 0; i < limit; i++) {
      if (interval.intersects(intervals[i])) {
        StdOut.printf("%s intersects %s\n", interval.toString(), intervals[i].toString());
      }
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new Error("You must provide: <int_n>");
    }

    int n = Integer.parseInt(args[0]);
    Interval1D[] intervals = new Interval1D[n];
    int i = 0;
    double temp;

    while (i < n) {
      double min = StdIn.readDouble();
      double max = StdIn.readDouble();

      if (min > max) {
        temp = min;
        min = max;
        max = temp;
      }

      Interval1D interval = new Interval1D(min, max);
      intersectsWith(interval, intervals, i);
      intervals[i] = interval;
      i++;
    }
  }
}
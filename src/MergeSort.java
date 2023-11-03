import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Alma Ordaz
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

  public <T> void mergeSort(T[] values, int lb, int ub, Comparator<? super T> order) {
    int mid = lb + (ub - lb) / 2;

    if ((ub - lb) > 1) {
      mergeSort(values, lb, mid, order);
      mergeSort(values, mid, ub, order);
      merge(values, lb, mid, ub, order);
    }//if
  }// mergeSort(T[], int, int, int, Comparator<? super T>)

  static <T> void merge(T[] values, int lo, int mid, int hi, Comparator<? super T> order) {
    T[] result = values.clone();
    int i;
    int startMid = mid;

    for (i = lo; lo != startMid && mid != hi; i++) {
      if (order.compare(values[lo], values[mid]) <= 0) {
        result[i] = values[lo];
        lo++;
      } else {
        result[i] = values[mid];
        mid++;
      }//if else
    }//for

    if (lo < startMid) {
      while (i != hi) {
        result[i] = values[lo];
        lo++;
        i++;
      }//while
    }//if

    // copying result back into values
    for (int x = 0; x < values.length; x++) {
      values[x] = result[x];
    }//for
  } // merge(T[], int, int, int, Comparator<? super T>)

}// class MergeSort

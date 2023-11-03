/**
 * Implemented Tim Sort using chatGPT
 *
 * @author Alma Ordaz
 */

import java.util.Arrays;
import java.util.Comparator;

public class OrdazAlmaSort implements Sorter {
  private static final int MIN_MERGE = 32;

  @Override
  public <T> void sort(T[] values, Comparator<? super T> comparator) {
    int n = values.length;
    T[] arr = Arrays.copyOf(values, n);
    Quicksort sort = new Quicksort();
    MergeSort merging = new MergeSort();

    int minRun = minRunLength(n);

    for (int i = 0; i < n; i += minRun) {
      int size = Math.min(minRun, n - i);
      sort.quickSort(arr, comparator, i, i + size);
     // insertionSort(arr, i, i + size, comparator);
    }

    for (int size = minRun; size < n; size = 2 * size) {
      for (int left = 0; left < n; left += 2 * size) {
        int mid = Math.min(left + size, n);
        int right = Math.min(left + 2 * size, n);
        if (mid < right) {
          merging.merge(values, left, mid, right, comparator);
          //merge(arr, left, mid, right, comparator);
        }
      }
    }

    System.arraycopy(arr, 0, values, 0, n);
  }// sort(T[], Comparator<? super T>)

  private static int minRunLength(int n) {
    int r = 0;
    while (n >= MIN_MERGE) {
      r |= (n & 1);
      n >>= 1;
    }
    return n + r;
  }// minRunLength(int)
}//class AlmaOrdazSort

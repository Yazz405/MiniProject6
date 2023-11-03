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

    int minRun = minRunLength(n);

    for (int i = 0; i < n; i += minRun) {
      int size = Math.min(minRun, n - i);
      insertionSort(arr, i, i + size, comparator);
    }

    for (int size = minRun; size < n; size = 2 * size) {
      for (int left = 0; left < n; left += 2 * size) {
        int mid = Math.min(left + size, n);
        int right = Math.min(left + 2 * size, n);
        if (mid < right) {
          merge(arr, left, mid, right, comparator);
        }
      }
    }

    System.arraycopy(arr, 0, values, 0, n);
  }// sort(T[], Comparator<? super T>)

  private <T> void insertionSort(T[] arr, int left, int right, Comparator<? super T> comparator) {
    for (int i = left + 1; i < right; i++) {
      T key = arr[i];
      int j = i - 1;
      while (j >= left && comparator.compare(arr[j], key) > 0) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }// insertionSort(T[], int, int, Comparator<? super T>)

  private <T> void merge(T[] arr, int left, int mid, int right, Comparator<? super T> comparator) {
    int len1 = mid - left;
    int len2 = right - mid;

    T[] leftArr = Arrays.copyOfRange(arr, left, mid);
    T[] rightArr = Arrays.copyOfRange(arr, mid, right);

    int i = 0, j = 0, k = left;
    while (i < len1 && j < len2) {
      if (comparator.compare(leftArr[i], rightArr[j]) <= 0) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
      }
    }

    while (i < len1) {
      arr[k++] = leftArr[i++];
    }

    while (j < len2) {
      arr[k++] = rightArr[j++];
    }
  }// merge (T[], int, int, int, Comparator<? super T>)

  private static int minRunLength(int n) {
    int r = 0;
    while (n >= MIN_MERGE) {
      r |= (n & 1);
      n >>= 1;
    }
    return n + r;
  }// minRunLength(int)
}//class AlmaOrdazSort

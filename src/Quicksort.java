import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Alma Ordaz
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public <T> void swap(T[] arr, int first, int second) {
    T temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }// swap(T[], int, int)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>)

  static <T> void quickSort(T[] values, Comparator<? super T> compare, int lb, int ub) {
    int mid;

    if (values.length > 0) {
      mid = partition(values, compare, lb, ub);

      if ((mid - lb) > 1) {
        quickSort(values, compare, lb, mid);
      } // if
      if ((ub - mid) > 1) {
        quickSort(values, compare, mid + 1, ub);
      } // if
    }

  } // quickSort(T[], Comparator, int, int)

  private static <T> int partition(T[] values, Comparator<? super T> compare, int lb, int ub) {
    int pivot = lb + (ub - lb) / 2;
    int small = lb + 1;
    int large = ub;
    T temp;

    //put pivot at the beginning
    temp = values[pivot];
    values[pivot] = values[lb];
    values[lb] = temp;

    while (small < large) {
      if (compare.compare(values[lb], values[small]) >= 0) {
        small++;
      } else if (compare.compare(values[lb], values[large - 1]) < 0) {
        large--;
      } else {
        temp = values[small];
        large--;
        values[small] = values[large];
        values[large] = temp;
        small++;
      }//if - else
    }//while

    //put pivot back in correct spot
    temp = values[small - 1];
    values[small - 1] = values[lb];
    values[lb] = temp;

    return (small - 1);
  } // partition(T[], Comparator<? super T>, int, int)

} // class Quicksort

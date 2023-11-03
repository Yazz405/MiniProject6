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

  /*
   * helper function that swaps two values in the array,
   * given by the indeces first and second
   */
  public static <T> void swap(T[] arr, int first, int second) {
    T temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }// swap(T[], int, int)

  /*
   * sorts values into ascending order using inputed order
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>)

  /*
   * sorts values into ascending order using inputed order
   */
  public <T> void quickSort(T[] values, Comparator<? super T> compare, int lb, int ub) {
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

  /*
   * arranges the array by putting all values less than or equal to that pivot to its left and 
   * all values greater than that pivot to its right
   */
  private static <T> int partition(T[] values, Comparator<? super T> compare, int lb, int ub) {
    int pivot = lb + (ub - lb) / 2;
    int small = lb + 1;
    int large = ub;

    //put pivot at the beginning
    swap(values, pivot, lb);

    while (small < large) {
      if (compare.compare(values[lb], values[small]) >= 0) {
        small++;
      } else if (compare.compare(values[lb], values[large - 1]) < 0) {
        large--;
      } else {
        swap(values, small++, --large);
      }//if - else
    }//while

    //put pivot back in correct spot
    swap(values, small - 1, lb);

    return small - 1;
  } // partition(T[], Comparator<? super T>, int, int)

} // class Quicksort

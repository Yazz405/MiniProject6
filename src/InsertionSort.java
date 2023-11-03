import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Alma Ordaz
 */

public class InsertionSort implements Sorter {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /*
   * sorts the values into ascending order using inputed order
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    T temp;
    
    for(int i = 1; i < values.length; i++){
      if(order.compare(values[i-1], values[i]) > 0){
        temp = values[i];
        for(int j = i - 1; j >= 0; j--){
          if(order.compare(values[j], temp) <= 0){
            values[j + 1] = temp;
            break;
          }//if
          else{
            values[j + 1] = values[j];
            if(j == 0){
              values[j] = temp;
            }//if
          }//else
        }//for 
      }//if
    }//for

  } // sort(T[], Comparator<? super T>

} // class InsertionSort

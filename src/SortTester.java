import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.beans.Transient;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void sameValueTest() {
    String[] origional = {"alma", "alma", "alma"};
    String[] expected = {"alma", "alma", "alma"};
    sorter.sort(origional, (x, y) -> x.compareTo(y));
    assertArrayEquals(origional, expected);
  }// sameValueTest

  @Test 
  public void emptyTest() {
    String[] origional = { };
    String[] expected = { };
    sorter.sort(origional, (x,y) -> x.compareTo(y));
    assertArrayEquals(origional, expected);
  }// emptyTest

  @Test
  public void oneValueTest() {
    String[] origional = {"hello"};
    String[] expected = {"hello"};
    sorter.sort(origional, (x,y) -> x.compareTo(y));
    assertArrayEquals(origional, expected);
  }// oneValueTest

  @Test
  public void repeatsTest() {
    String[] origional = {"one", "two", "two", "hello", "one"};
    String[] expected = {"hello", "one", "one", "two", "two"};
    sorter.sort(origional, (x,y) -> x.compareTo(y));
    assertArrayEquals(origional, expected);
  }// repeatsTest

  @Test 
  public void noRepeatsTestTest() {
    String[] origional = {"hello","alma", "world", "alma", "two"};
    String[] expected = {"alma", "alma", "hello", "two", "world"};
    sorter.sort(origional, (x,y) -> x.compareTo(y));
    assertArrayEquals(origional, expected);
  }// noRepeatsTest

} // class SortTester

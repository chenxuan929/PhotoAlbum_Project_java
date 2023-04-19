import org.junit.Test;
import shape.PosShape;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the PosShape class.
 */
public class PosShapeTest {

  /**
   * Tests the getXPos method of the PosShape class.
   */
  @Test
  public void testGetXPos() {
    PosShape pos = new PosShape(10, 20);
    assertEquals(10, pos.getXPos());
    PosShape pos2 = new PosShape(5, 10);
    assertEquals(5, pos2.getXPos());
  }

  /**
   * Tests the getYPos method of the PosShape class.
   */
  @Test
  public void testGetYPos() {
    PosShape pos = new PosShape(10, 20);
    assertEquals(20, pos.getYPos());
    PosShape pos2 = new PosShape(5, 10);
    assertEquals(10, pos2.getYPos());
  }

  /**
   * Tests the toString method of the PosShape class.
   */
  @Test
  public void testToString() {
    PosShape pos = new PosShape(10, 20);
    assertEquals("(10, 20)", pos.toString());
    PosShape pos2 = new PosShape(5, 10);
    assertEquals("(5, 10)", pos2.toString());
  }
}

import shape.shapeType;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test of class shapeType.
 */
public class shapeTypeTest {
  /**
   * Test two types of shape.
   */
  @Test
  public void testGetStrShape() {
    assertEquals("rectangle", shapeType.RECTANGLE.getStrShape());
    assertEquals("oval", shapeType.OVAL.getStrShape());
  }
}
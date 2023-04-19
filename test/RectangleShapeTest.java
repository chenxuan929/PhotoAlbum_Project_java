import org.junit.Test;
import shape.Color;
import shape.PosShape;
import shape.RectangleShape;
import shape.shapeType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * This class contains JUnit test cases for the RectangleShape class.
 */
public class RectangleShapeTest {

  /**
   * Test case for creating a RectangleShape object with a negative width and height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegative() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(10,10,10);
    RectangleShape shape = new RectangleShape("1", shapeType.RECTANGLE, pos, -1, 10, color);
    RectangleShape shape2 = new RectangleShape("1", shapeType.RECTANGLE, pos, 10, -1, color);
  }

  /**
   * Test case for copying a RectangleShape object.
   */
  @Test
  public void testCopy() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(10,10,10);
    RectangleShape shape1 = new RectangleShape("1", shapeType.RECTANGLE, pos, 10, 20, color);
    RectangleShape shape2 = (RectangleShape) shape1.copy();
    assertNotSame(shape1, shape2);
    assertEquals(shape1.getName(), shape2.getName());
    assertEquals(shape1.getType(), shape2.getType());
    assertEquals(shape1.getPos().toString(), shape2.getPos().toString());
    assertEquals(shape1.getSizeOne(), shape2.getSizeOne());
    assertEquals(shape1.getSizeTwo(), shape2.getSizeTwo());
    assertEquals(shape1.getColor(), shape2.getColor());
  }

  /**
   * Test case for setting the size value of a RectangleShape object.
   */
  @Test
  public void testSetSizeValue() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(10,10,10);
    RectangleShape shape = new RectangleShape("1", shapeType.RECTANGLE, pos, 10, 20, color);
    shape.setSizeValue(30, 40);
    assertEquals(30, shape.getSizeOne());
    assertEquals(40, shape.getSizeTwo());
  }

  /**
   * Test case for generating a string representation of a RectangleShape object.
   */
  @Test
  public void testToString() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(10,10,10);
    RectangleShape shape = new RectangleShape("1", shapeType.RECTANGLE, pos, 10, 20, color);
    String expected = "Name: 1\n" +
      "Type: RECTANGLE\n" +
      "Position: (0, 0)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 10.0\n" +
      "Height: 20.0\n";
    assertEquals(expected, shape.toString());
  }
}

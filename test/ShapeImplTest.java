import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import shape.Color;
import shape.PosShape;
import shape.RectangleShape;
import shape.ShapeImpl;
import shape.shapeType;
import shape.IShape;

/**
 * Tests of class ShapeImpl.
 */
public class ShapeImplTest {

  /**
   * Tests the constructor of class.
   */
  @Test
  public void testConstructor() {
    ShapeImpl shape;
    Color color = new shape.Color(10,10,10);
    shape = new RectangleShape("1", shapeType.RECTANGLE, new PosShape(0, 1), 10, 20,
      color);
    assertEquals("1", shape.getName());
    assertEquals(shapeType.RECTANGLE, shape.getType());
    assertEquals("(0, 1)", shape.getPos().toString());
    assertEquals("(10, 10, 10)", shape.getColor().toString());
  }

  /**
   * Test to set the position of shape.
   */
  @Test
  public void testSetPos() {
    ShapeImpl shape;
    Color color = new shape.Color(10,10,10);
    shape = new RectangleShape("1", shapeType.RECTANGLE, new PosShape(0, 1), 10, 20,
      color);
    shape.setPos(new PosShape(5, 5));
    assertEquals("(5, 5)", shape.getPos().toString());
    shape.setPos(new PosShape(11, 6));
    assertEquals("(11, 6)", shape.getPos().toString());
  }

  /**
   * Test to set the color of shape.
   */
  @Test
  public void testSetColor() {
    ShapeImpl shape;
    Color color = new shape.Color(10,10,10);
    shape = new RectangleShape("1", shapeType.RECTANGLE, new PosShape(0, 1), 10, 20,
      color);
    shape.setColor(color);
    assertEquals(color, shape.getColor());
  }

  /**
   * Test to make a copy of shape.
   */
  @Test
  public void testCopy() {
    ShapeImpl shape;
    Color color = new shape.Color(10,10,10);
    shape = new RectangleShape("1", shapeType.RECTANGLE, new PosShape(0, 1), 10, 20,
      color);
    IShape copy = shape.copy();
    assertNotSame(shape, copy);
    assertEquals(shape.getName(), copy.getName());
    assertEquals(shape.getType(), copy.getType());
    assertEquals(shape.getPos(), copy.getPos());
    assertEquals(shape.getColor(), copy.getColor());
  }

}

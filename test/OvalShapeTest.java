import org.junit.Test;
import shape.Color;
import shape.OvalShape;
import shape.PosShape;
import shape.shapeType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * This class contains JUnit tests for the OvalShape class,
 * which represents an oval shape with a name, type, position, size, and color.
 */
public class OvalShapeTest {

  /**
   * Tests the constructor of the OvalShape class.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidSize() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(255, 255, 255);
    OvalShape oval = new OvalShape("1", shapeType.OVAL, pos, -10, 20, color);
  }

  /**
   * Tests the constructor of the OvalShape class with a valid size value.
   */
  @Test
  public void testConstructorValidSize() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(255, 255, 255);
    OvalShape oval = new OvalShape("1", shapeType.OVAL, pos, 10, 20, color);
    assertEquals(10, oval.getSizeOne());
    assertEquals(20, oval.getSizeTwo());
    assertEquals("1", oval.getName());
    assertEquals(shapeType.OVAL, oval.getType());
    assertEquals(pos, oval.getPos());
    assertEquals(color, oval.getColor());
  }

  /**
   * Tests the setSizeValue method of the OvalShape class,
   * and checks that the size values are correctly updated.
   */
  @Test
  public void testSetSizeValue() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(255, 255, 255);
    OvalShape oval = new OvalShape("1", shapeType.OVAL, pos, 10, 20, color);
    oval.setSizeValue(15, 25);
    assertEquals(15, oval.getSizeOne());
    assertEquals(25, oval.getSizeTwo());
  }

  /**
   * Tests the setSizeValue method of the OvalShape class with an invalid size value,
   * which should throw an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetSizeValueInvalidSize() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(255, 255, 255);
    OvalShape oval = new OvalShape("1", shapeType.OVAL, pos, 10, 20, color);
    oval.setSizeValue(-5, 10);
  }

  /**
   * Tests the copy method of the OvalShape class.
   */
  @Test
  public void testCopy() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(255, 255, 255);
    OvalShape oval = new OvalShape("1", shapeType.OVAL, pos, 10, 20, color);
    OvalShape ovalCopy = (OvalShape)oval.copy();
    assertNotSame(oval, ovalCopy);
    assertEquals(oval.getName(), ovalCopy.getName());
    assertEquals(oval.getType(), ovalCopy.getType());
    assertEquals(oval.getPos(), ovalCopy.getPos());
    assertEquals(oval.getColor(), ovalCopy.getColor());
    assertEquals(oval.getSizeOne(), ovalCopy.getSizeOne());
    assertEquals(oval.getSizeTwo(), ovalCopy.getSizeTwo());
  }

  /**
   * Tests the toString method of the OvalShape class.
   */
  @Test
  public void testToString() {
    PosShape pos = new PosShape(0, 0);
    Color color = new Color(255, 255, 255);
    OvalShape oval = new OvalShape("1", shapeType.OVAL, pos, 10, 20, color);
    String expected = "Name: 1\nType: OVAL\nPosition: (0, 0)\nColor: (255, 255, 255)\nX radius: 10\nY radius: 20\n";
    assertEquals(expected, oval.toString());
  }
}






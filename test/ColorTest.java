import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import shape.Color;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * This class provides unit tests for the Color class, which represents a color with RGB values.
 */
public class ColorTest {

  /**
   * Tests the valid color values with the toString method.
   */
  @Test
  public void testValidColors() {
    Color color1 = new Color(0, 0, 0);
    assertEquals("(0, 0, 0)", color1.toString());

    Color color2 = new Color(255, 255, 255);
    assertEquals("(255, 255, 255)", color2.toString());

    Color color3 = new Color(128, 128, 128);
    assertEquals("(128, 128, 128)", color3.toString());
  }

  /**
   * Tests the invalid color values with the IllegalArgumentException class.
   */
  @Test
  public void testInvalidColors() {
    // Test values outside the range [0, 255]
    assertThrows(IllegalArgumentException.class, () -> new Color(256, 0, 0));
    assertThrows(IllegalArgumentException.class, () -> new Color(0, 256, 0));
    assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, 256));
    assertThrows(IllegalArgumentException.class, () -> new Color(-1, 0, 0));
    assertThrows(IllegalArgumentException.class, () -> new Color(0, -1, 0));
    assertThrows(IllegalArgumentException.class, () -> new Color(0, 0, -1));

    // Test values exactly at the edges of the range [0, 255]
    Assertions.assertDoesNotThrow(() -> new Color(0, 0, 0));
    Assertions.assertDoesNotThrow(() -> new Color(255, 255, 255));
  }

  /**
   * Tests the constructor with the getR, getG, and getB methods.
   */
  @Test
  public void testConstructor() {
    Color color = new Color(100, 150, 200);
    assertEquals(100, color.getR());
    assertEquals(150, color.getG());
    assertEquals(200, color.getB());
  }

  /**
   * Tests the constructor with invalid values and expects the IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidValues() {
    new Color(-10, 260, 500);
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    Color color = new Color(50, 75, 100);
    assertEquals("(50, 75, 100)", color.toString());
  }
}

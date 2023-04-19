package shape;

/**
 * The Color class represents a color with red, green, and blue components.
 * Each component is an integer value between 0 and 255.
 */
public class Color {
  private int r;
  private int g;
  private int b;

  /**
   * Constructs a new Color with the given red, green, and blue components.
   * @param r the red component of the color
   * @param g the green component of the color
   * @param b the blue component of the color
   * @throws IllegalArgumentException if the component values are not between 0 and 255
   */
  public Color(int r, int g, int b) {
    int lowLimit = 0;
    int highLimit = 255;
    if (r > highLimit || g > highLimit || b > highLimit
      || r < lowLimit || g < lowLimit || b < lowLimit) {
      throw new IllegalArgumentException("Invalid color value, should between 0 and 255.");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Returns the red component of the color.
   * @return the red component of the color
   */
  public int getR() {
    return this.r;
  }

  /**
   * Returns the green component of the color.
   * @return the green component of the color
   */
  public int getG() {
    return this.g;
  }

  /**
   * Returns the blue component of the color.
   * @return the blue component of the color
   */
  public int getB() {
    return this.b;
  }

  /**
   * Returns a String representation of the Color object.
   * @return a String representation of the Color object
   */
  @Override
  public String toString() {
    String st =  "(" + this.r + ", " + this.g + ", " + this.b + ')';
    return st;
  }
}

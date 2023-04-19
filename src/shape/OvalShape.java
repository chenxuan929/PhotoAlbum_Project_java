package shape;

/**
 * This class represents an oval shape,
 * which is defined by two radii: a horizontal radius (s1) and a vertical radius (s2).
 * The oval shape inherits from the ShapeImpl class
 * and implements the IShape interface.
 * The class provides methods for getting
 * and setting the size of the oval shape, as well as a method for creating a copy of the shape.
 */
public class OvalShape extends ShapeImpl {
  private int xRadius;
  private int yRadius;

  /**
   * Creates a new instance of the OvalShape class.
   * @param id The unique identifier of the shape.
   * @param type The type of the shape.
   * @param pos The position of the shape.
   * @param s1 The horizontal radius of the oval shape.
   * @param s2 The vertical radius of the oval shape.
   * @param color The color of the shape.
   * @throws IllegalArgumentException If either of the radii is less than 0.
   */
  public OvalShape(String id, shapeType type, PosShape pos, int s1, int s2, Color color) {
    super(id, type, pos, color);
    if (s1 < 0 || s2 < 0) {
      throw new IllegalArgumentException("Size can not be less than 0.");
    }
    this.xRadius = s1;
    this.yRadius = s2;
  }

  /**
   * Returns the horizontal radius of the oval shape.
   * @return The horizontal radius of the oval shape.
   */
  @Override
  public int getSizeOne() {
    return this.xRadius;
  }

  /**
   * Returns the vertical radius of the oval shape.
   * @return The vertical radius of the oval shape.
   */
  @Override
  public int getSizeTwo() {
    return this.yRadius;
  }

  /**
   * Sets the size of the oval shape to the specified horizontal and vertical radii.
   * @param sizeOne The new horizontal radius of the oval shape.
   * @param sizeTwo The new vertical radius of the oval shape.
   * @throws IllegalArgumentException If either of the radii is less than 0.
   */
  @Override
  public void setSizeValue(int sizeOne, int sizeTwo) {
    if (sizeOne < 0 || sizeTwo < 0) {
      throw new IllegalArgumentException("Size can not be less than 0.");
    }
    this.xRadius = sizeOne;
    this.yRadius = sizeTwo;
  }

  /**
   * Returns a string representation of the oval shape, including its unique identifier, type, position, color, and radii.
   * @return A string representation of the oval shape.
   */
  @Override
  public String toString() {
    return String.format("%sX radius: %d\nY radius: %d\n", super.toString(), xRadius, yRadius);
  }

  /**
   * Creates a deep copy of the oval shape.
   * @return A new instance of the OvalShape class with the same properties as the original shape.
   */
  @Override
  public IShape copy() {
    return new OvalShape(this.name, this.type, this.pos,this.xRadius, this.yRadius, this.color);
  }
}

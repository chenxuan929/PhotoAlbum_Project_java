package shape;

/**
 * This class represents a rectangle shape.
 * It has a width, height, position, id, shape type, and color.
 * It allows setting and getting the size dimensions,
 * copying the shape, and converting it to a string format.
 */
public class RectangleShape extends ShapeImpl {
  private int width;
  private int height;

  /**
   * Constructs a shape with the given id, shape type, position, and color.
   *
   * @param name the name of the shape
   * @param type the type of the shape
   * @param pos the position of the shape
   * @param color the color of the shape
   * @throws IllegalArgumentException if the id is null or empty
   */
  public RectangleShape(String name, shapeType type, PosShape pos, int width, int height, Color color) {
    super(name, type, pos, color);
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Height and width can not be less than 0.");
    }
    this.width = width;
    this.height = height;
  }

  /**
   * Returns a copy of this rectangle shape.
   * @return a new rectangle shape with the same id, type, position, width, height, and color
   */
  @Override
  public IShape copy() {
    return new RectangleShape(this.name, this.type, this.pos,
      this.width, this.height, this.color);
  }

  /**
   * Sets the size dimensions of this rectangle shape to the given values.
   * @param sizeOne the size of the first dimension (i.e., the width)
   * @param sizeTwo the size of the second dimension (i.e., the height)
   * @throws IllegalArgumentException if the width or height is less than 0
   */
  @Override
  public void setSizeValue(int sizeOne, int sizeTwo) {
    if (sizeOne < 0 || sizeTwo < 0) {
      throw new IllegalArgumentException("Setting size can not be less than 0.");
    }
    this.width = sizeOne;
    this.height = sizeTwo;
  }

  /**
   * Returns the size of the first dimension of this rectangle shape (i.e., the width).
   * @return the width of this rectangle shape
   */
  @Override
  public int getSizeOne() {
    return this.width;
  }

  /**
   * Returns the size of the second dimension of this rectangle shape (i.e., the height).
   * @return the height of this rectangle shape
   */
  @Override
  public int getSizeTwo() {
    return this.height;
  }

  /**
   * Returns a string representation of this rectangle shape.
   * @return a string containing the id, type,
   * position, width, height, and color of this rectangle shape.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(String.format("Width: %.1f\n", (double)this.width));
    sb.append(String.format("Height: %.1f\n", (double)this.height));
    return sb.toString();
  }

}

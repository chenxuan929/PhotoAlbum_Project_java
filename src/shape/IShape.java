package shape;

/**
 * The IShape interface represents a shape in a two-dimensional space. It provides
 * methods for setting and getting the position, color, size, ID, and shape type of the shape.
 * It also provides a method for creating a copy of the shape.
 */
public interface IShape {

  /**
   * Sets the position of the shape to the given position.
   * @param pos the new position of the shape
   */
  void setPos(PosShape pos);

  /**
   * Returns the current position of the shape.
   * @return the current position of the shape
   */
  PosShape getPos();

  /**
   * Sets the color of the shape to the given color.
   * @param co the new color of the shape
   */
  void setColor(Color co);

  /**
   * Returns the current color of the shape.
   * @return the current color of the shape
   */
  Color getColor();

  /**
   * Sets the size of the shape to the given dimensions.
   * @param sizeOne the size of the first dimension
   * @param sizeTwo the size of the second dimension
   */
  void setSizeValue(int sizeOne, int sizeTwo);

  /**
   * Returns the size of the first dimension of the shape.
   * @return the size of the first dimension of the shape
   */
  int getSizeOne();

  /**
   * Returns the size of the second dimension of the shape.
   * @return the size of the second dimension of the shape
   */
  int getSizeTwo();

  /**
   * Returns the ID of the shape.
   * @return the ID of the shape
   */
  String getName();

  /**
   * Returns the type of the shape.
   * @return the type of the shape
   */
  shapeType getType();

  /**
   * Creates a copy of the shape.
   * @return a copy of the shape
   */
  IShape copy();
}

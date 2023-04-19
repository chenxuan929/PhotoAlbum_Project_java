package shape;

/**
 * The shapeType enum represents the type of shape, which can be either rectangle or oval.
 * It provides a method for getting the string representation of the shape type.
 */
public enum shapeType {
  RECTANGLE("rectangle"), OVAL("oval");
  private String strShape;

  /**
   * Constructs a new shapeType enum with the given string representation.
   * @param strShape the string representation of the shape type
   * @throws IllegalArgumentException if the string representation is empty or null
   */
  shapeType(String strShape) {
    if (strShape == null || strShape.isEmpty()) {
      throw new IllegalArgumentException("String of shape can not be empty or null!");
    }
    this.strShape = strShape;
  }

  /**
   * Returns the string representation of the shape type.
   * @return the string representation of the shape type
   */
  public String getStrShape() {
    return this.strShape;
  }
}

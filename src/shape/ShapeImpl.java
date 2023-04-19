package shape;

/**
 * This abstract class represents a shape that implements the IShape interface.
 * It contains the common fields and methods，
 * that all shapes have such as id, shape type, position, color, and copy method.
 */
public abstract class ShapeImpl implements IShape {
  protected String name;
  protected shapeType type;
  protected PosShape pos;
  protected Color color;

  /**
   * Constructs a shape with the given id, shape type, position, and color.
   * @param name the name of the shape
   * @param shapeType the type of the shape
   * @param shapePos the position of the shape
   * @param color the color of the shape
   * @throws IllegalArgumentException if the id is null or empty
   */
  public ShapeImpl(String name, shapeType shapeType, PosShape shapePos, Color color) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty.");
      }
    this.name = name;
    this.type = shapeType;
    this.pos = shapePos;
    this.color = color;
    }

  /**
   * Sets the position of the shape to the given position.
   * @param shapePos the new position of the shape
   */
  @Override
  public void setPos(PosShape shapePos) {
    this.pos = shapePos;
  }

  /**
   * Returns the position of the shape.
   * @return the position of the shape
   */
  @Override
  public PosShape getPos() {
    return this.pos;
  }

  /**
   * Sets the color of the shape to the given color.
   * @param color the new color of the shape
   */
  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  /**
   * Returns the color of the shape.
   * @return the color of the shape
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Returns the id of the shape.
   * @return the id of the shape
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Returns the type of the shape.
   * @return the type of the shape
   */
  @Override
  public shapeType getType() {
    return this.type;
  }

  /**
   * Returns a string representation of the shape，
   * including its id, shape type, position, and color.
   * @return a string representation of the shape
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ").append(name).append("\n");
    sb.append("Type: ").append(type).append("\n");
    sb.append("Position: ").append(pos).append("\n");
    sb.append("Color: ").append(color).append("\n");
    return sb.toString();
  }

  /**
   * Returns a deep copy of the shape.
   * @return a deep copy of the shape
   */
  @Override
  public abstract IShape copy();
}

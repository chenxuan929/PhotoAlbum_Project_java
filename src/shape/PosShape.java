package shape;

/**
 * The PosShape class represents a position with x and y coordinates.
 * It provides methods for getting the x and y coordinates and a toString method for getting
 * a string representation of the position in the format "(x, y)".
 */
public class PosShape {
  private int xPos;
  private int yPos;

  /**
   * Constructs a new PosShape object with the given x and y coordinates.
   * @param x the x coordinate of the position
   * @param y the y coordinate of the position
   */
  public PosShape(int x, int y) {
    this.xPos = x;
    this.yPos = y;
  }

  /**
   * Returns the x coordinate of the position.
   * @return the x coordinate of the position
   */
  public int getXPos() {
    return xPos;
  }

  /**
   * Returns the y coordinate of the position.
   * @return the y coordinate of the position
   */
  public int getYPos() {
    return yPos;
  }

  /**
   * Returns a string representation of the position in the format "(x, y)".
   * @return a string representation of the position
   * @return
   */
  @Override
  public String toString() {
    String st = "(" + xPos + ", " + yPos + ')';
    return st;
  }
}

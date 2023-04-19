package view;

import shape.IShape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * A panel used for drawing shapes.
 */
public class PaintPanel extends JPanel {
  private final List<IShape> shapes;

  /**
   * Constructs a new PaintPanel with the specified list of shapes to draw.
   * @param shapes the list of shapes to draw on the panel.
   */
  public PaintPanel(List<IShape> shapes) {
    this.shapes = shapes;
    setBackground(Color.WHITE);
  }

  /**
   * Draws all the shapes in the panel.
   * @param g the <code>Graphics</code> object to protect
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (IShape shape : shapes) {
      Color color = new Color(shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB());
      g.setColor(color);
      int x = shape.getPos().getXPos();
      int y = shape.getPos().getYPos();
      int width = shape.getSizeOne();
      int height = shape.getSizeTwo();

      switch (shape.getType().getStrShape().toLowerCase()) {
        case "rectangle":
          g.fillRect(x,y,width, height);
          break;
        case "oval":
          g.fillOval(x,y,width, height);
          break;
        default:
          break;
      }
    }
  }
}

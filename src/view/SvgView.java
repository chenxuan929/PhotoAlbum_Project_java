package view;

import shape.IShape;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents an SVG gallery with multiple snapshots.
 */
public class SvgView {
  private HashMap<String, List<IShape>> snapshot;
  private List<String> snapshotId;
  private List<String> description;
  private int width;
  private int height;
  private String outPath;

  /**
   * Constructs an SVG gallery with the specified snapshots,
   * snapshot IDs, descriptions, output path, width, and height.
   * @param snapshot a HashMap representing the collection of shapes for each snapshot
   * @param snapshotId a list of strings representing the IDs of each snapshot
   * @param description a list of strings representing the descriptions of each snapshot
   * @param outPath a string representing the output path of the HTML document
   * @param width an integer representing the width of the SVG gallery
   * @param height an integer representing the height of the SVG gallery
   */
  public SvgView(HashMap<String, List<IShape>> snapshot, List<String> snapshotId,
                 List<String> description, String outPath, int width, int height) {
    this.snapshot = snapshot;
    this.snapshotId = snapshotId;
    this.description = description;
    this.outPath = outPath;
    this.width = width;
    this.height = height;
  }

  /**
   * Generates an HTML document with SVG elements representing the SVG gallery.
   * @return a string representing the HTML document with SVG elements
   * @throws IllegalArgumentException if the type of a shape in the snapshot is not recognized
   */
  public String generalHTML() throws IllegalArgumentException {
    StringBuilder sb = new StringBuilder();
    sb.append("<!DOCTYPE html>\n<html>\n<body>\n<h1>Chenxuan Xu's SVG Gallery</h1>\n");
    for (int i = 0; i < this.snapshotId.size(); i++) {
      sb.append(String.format(
        "<div>\n<h2>%s</h2>\n<h3>Description: %s</h3>\n" +
          "<svg width=\"%d\" height=\"%d\">\n",
        this.snapshotId.get(i),
        this.description.get(i),
        this.width,
        this.height));
      for (IShape shape : this.snapshot.get(this.snapshotId.get(i))) {
        switch (shape.getType().getStrShape()) {
          case "rectangle":
            sb.append(String.format(
              "<rect name=\"%s\" x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"rgb(%d,%d,%d)\">\n</rect>\n",
              shape.getName(),
              shape.getPos().getXPos(),
              shape.getPos().getYPos(),
              shape.getSizeOne(),
              shape.getSizeTwo(),
              shape.getColor().getR(),
              shape.getColor().getG(),
              shape.getColor().getB()));
            break;
          case "oval":
            sb.append(String.format(
              "<ellipse name=\"%s\" cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" fill=\"rgb(%d,%d,%d)\">\n</ellipse>\n",
              shape.getName(),
              shape.getPos().getXPos(),
              shape.getPos().getYPos(),
              shape.getSizeOne(),
              shape.getSizeTwo(),
              shape.getColor().getR(),
              shape.getColor().getG(),
              shape.getColor().getB()));
            break;
          default:
            throw new IllegalArgumentException("Can not find this shape type.");
        }
      }
      sb.append("</svg>\n</div>\n");
    }
    sb.append("</body>\n</html>");
    return String.valueOf(sb);
  }

  /**
   * Writes the SVG gallery to the output file specified in the constructor.
   * @throws IOException if there is an error writing to the output file
   */
  public void outputFile() throws IOException {
    String content = this.generalHTML();
    if (!outPath.equals("SysOut")) {
      try (PrintWriter writer = new PrintWriter(this.outPath, StandardCharsets.UTF_8)) {
        writer.append(content);
      }
    } else {
      System.out.print(content);
    }
  }
}
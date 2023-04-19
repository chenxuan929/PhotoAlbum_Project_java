import model.IModel;
import shape.Color;
import shape.PosShape;
import shape.shapeType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeFileParser{

  /**
   * Parses a file with commands that modify the given shape model.
   *
   * @param filename the name of the file to parse
   * @param model the shape model to modify
   * @throws FileNotFoundException if the file is not found
   */
  public static void parseFile(String filename, IModel model) throws FileNotFoundException {
    File file = new File(filename);
    Scanner input = new Scanner(file);

    while (input.hasNext()) {
      String command = input.next().toLowerCase();
      switch (command) {
        case "#":
          input.nextLine();
          break;
        case "shape":
          parseShapeCommand(input, model);
          break;
        case "move":
          parseMoveCommand(input, model);
          break;
        case "color":
          parseColorCommand(input, model);
          break;
        case "resize":
          parseResizeCommand(input, model);
          break;
        case "remove":
          parseRemoveCommand(input, model);
          break;
        case "snapshot":
          parseSnapshotCommand(input, model);
          break;
        default:
          // ignore unknown commands
      }
    }

    input.close();
  }

  private static void parseShapeCommand(Scanner input, IModel model) {
    String id = input.next();
    String type = input.next();
    int x = Integer.parseInt(input.next());
    int y = Integer.parseInt(input.next());
    int width = Integer.parseInt(input.next());
    int height = Integer.parseInt(input.next());
    int r = Integer.parseInt(input.next());
    int g = Integer.parseInt(input.next());
    int b = Integer.parseInt(input.next());
    if (type.equalsIgnoreCase(shapeType.RECTANGLE.toString())) {
      model.addShape(model.createShape(id, new PosShape(x,y), new Color(r, g, b), width, height, shapeType.RECTANGLE));
    } else {
      model.addShape(model.createShape(id, new PosShape(x,y), new Color(r, g, b), width, height, shapeType.OVAL));
    }
  }

  private static void parseMoveCommand(Scanner input, IModel model) {
    String id = input.next();
    int x = input.nextInt();
    int y = input.nextInt();
    model.changeShapePos(id, new PosShape(x, y));
  }

  private static void parseColorCommand(Scanner input, IModel model) {
    String id = input.next();
    int r = input.nextInt();
    int g = input.nextInt();
    int b = input.nextInt();
    model.changeShapeColor(id, new Color(r, g, b));
  }

  private static void parseResizeCommand(Scanner input, IModel model) {
    String id = input.next();
    int width = input.nextInt();
    int height = input.nextInt();
    model.changeSize(id, width, height);
  }

  private static void parseRemoveCommand(Scanner input, IModel model) {
    String id = input.next();
    model.clearShape(id);
  }

  private static void parseSnapshotCommand(Scanner input, IModel model) {
    String description = input.nextLine().trim();
    model.addSnapShot(description);
  }

}

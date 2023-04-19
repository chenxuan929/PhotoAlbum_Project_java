
import controller.Controller;
import model.IModel;
import model.IModelImpl;

import java.io.File;
import java.io.IOException;

/**
 * Main.
 */
public class PhotoAlbumMain {

  /**
   * Parses command-line arguments and uses them to initialize and run the program.
   * @param s command-line arguments as an array of strings
   * @throws IOException
   */
  public static void main(String[] s) throws IOException {
    int maxX = 1000;
    int maxY = 1000;
    String input = null;
    String chooseView = null;
    String output = null;

    for (int i = 0; i < s.length; i++) {
      if (isValidIntegerString(s[i]) && maxX == 1000 && maxY == 1000) {
        maxX = Integer.parseInt(s[i]);
        maxY = Integer.parseInt(s[i + 1]);
      }
      else {
        switch (s[i].toLowerCase()) {
          case "-in":
            input = s[i+1];
            break;
          case "-v":
          case "-view":
            chooseView = s[i+1];
            break;
          case "-out":
            output = s[i+1];
            break;
          default:
        }
      }
    }

    if (input == null || chooseView == null) {
      throw new IllegalArgumentException("Input file name or view choice not provided.");
    }

    if (chooseView.equalsIgnoreCase("WEB") && (output == null)) {
      throw new IllegalArgumentException("Output file name not provided for web view");
      //System.exit(1); // program terminate due to error output not found.
    }

/**
    //check if the input and output files exist and are not directories.
    File inputFile = new File(input);
    if (!inputFile.exists() || inputFile.isDirectory()) {
      throw new IllegalArgumentException("Input file not found or is a directory: " + input);
    }
    File outputFile = new File(output);
    if (output != null && (!outputFile.exists() || outputFile.isDirectory())) {
      throw new IllegalArgumentException("Output file not found or is a directory: " + output);
    }
 */


    IModel model = new IModelImpl();
    ShapeFileParser.parseFile(input, model);
    if (chooseView.equalsIgnoreCase("GRAPHICAL")) {
      Controller controller = new Controller(model, maxX, maxY);
      controller.showGraphicalView();
    } else {
      Controller controller = new Controller(model, output, maxX, maxY);
      controller.outputSVGFile();
    }
  }


  /**
   * Checks if the given input is a valid numeric string.
   *
   * @param str a String to be checked.
   * @return true if the input is a valid numeric string, false otherwise.
   */
  public static boolean isValidIntegerString(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}



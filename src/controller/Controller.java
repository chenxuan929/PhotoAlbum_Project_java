package controller;

import model.IModel;
import view.GraphView;
import view.SvgView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The Controller class serves as a bridge between the Model and the Views.
 */
public class Controller implements ActionListener {
  private IModel model;
  private GraphView graphView;
  private SvgView svgView;
  private int maxX;
  private int maxY;

  /**
   * Constructs a Controller object with a given model, maximum X and Y coordinates.
   * @param model the model to be used by the Controller
   * @param maxX the maximum X coordinate
   * @param maxY the maximum Y coordinate
   * @throws IllegalArgumentException if the model is null
   */
  public Controller(IModel model, int maxX, int maxY) {
    if (model == null) {
      throw new IllegalArgumentException("Error: model is null.");
    }
    this.model = model;
    this.graphView = new GraphView(this.model.ViewSnapShot(),
      this.model.getSnapShotIdList(), this.model.getDescription(), maxX, maxY);
    this.graphView.setListener(this);
  }

  /**
   * Constructs a Controller object with a given model, filename, maximum X and Y coordinates.
   * @param model the model to be used by the Controller
   * @param filename the name of the SVG file to be generated
   * @param maxX the maximum X coordinate
   * @param maxY the maximum Y coordinate
   * @throws IllegalArgumentException if the model is null
   */
  public Controller(IModel model, String filename, int maxX, int maxY) {
    if (model == null) {
      throw new IllegalArgumentException("Error: model is null.");
    }
    this.model = model;
    this.svgView = new SvgView(this.model.ViewSnapShot(), this.model.getSnapShotIdList(),
        this.model.getDescription(),filename, maxX, maxY);
}

  /**
   * Processes an ActionEvent by performing an action based on the command string of the event.
   * @param e the ActionEvent to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
      case "Prev":
        if (this.graphView.getCurrentSnapshot() == 0) {
          JOptionPane.showMessageDialog(this.graphView,
            "This is the first snapshot, no previous available.");
          break;
        }
        this.graphView.setCurrentSnapshot(this.graphView.getCurrentSnapshot() - 1);
        this.graphView.clearNorth();
        this.graphView.updateNorth();
        this.graphView.clearCenter();
        this.graphView.updateCenter();
        break;
      case "Select":
        String menuS = (String) JOptionPane.showInputDialog(
          this.graphView, "Choose", "Menu", JOptionPane.QUESTION_MESSAGE, null,
          this.graphView.getSnapshotIdList(), this.graphView.getSnapshotIdList()[0]);
        if (menuS != null) {
          int indexS = this.graphView.getSnapshotIndex(menuS);
          this.graphView.setCurrentSnapshot(indexS);
          this.graphView.clearNorth();
          this.graphView.updateNorth();
          this.graphView.clearCenter();
          this.graphView.updateCenter();
        }
        break;
      case "Next":
        if (this.graphView.getCurrentSnapshot() == this.model.getSnapShotIdList().size() - 1) {
          JOptionPane.showMessageDialog(this.graphView, "This is the last snapshot, no next available.");
          break;
        }
        this.graphView.setCurrentSnapshot(this.graphView.getCurrentSnapshot() + 1);
        this.graphView.clearNorth();
        this.graphView.updateNorth();
        this.graphView.clearCenter();
        this.graphView.updateCenter();
        break;
      case "Quit":
        System.exit(0);
      default:
    }
  }

  /**
   * Displays the graphical view of the model.
   * @throws IOException if there is an error in displaying the graphical view
   */
  public void showGraphicalView() throws IOException {
    this.graphView.setVisible(true);
  }

  /**
   * Outputs an SVG file representing the model.
   * @throws IOException if there is an error in writing the SVG file
   */
  public void outputSVGFile() throws IOException {
    this.svgView.outputFile();
  }
}

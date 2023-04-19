package model;

import shape.IShape;
import shape.PosShape;
import shape.Color;
import shape.shapeType;

import java.util.HashMap;
import java.util.List;

/**
 * This interface defines the methods that a model,
 * should have to support creating, managing, and manipulating shapes,
 * as well as taking and managing snapshots of the model's state.
 */
public interface IModel {

  /**
   * Creates a new shape with the specified properties and returns it as an {@link IShape} object.
   * @param name the name of the new shape
   * @param pos the position of the new shape
   * @param color the color of the new shape
   * @param sizeOne the size of the first dimension of the new shape
   * @param sizeTwo the size of the second dimension of the new shape
   * @param type the type of the new shape
   * @return the newly created shape as an {@link IShape} object
   */
  IShape createShape(String name, PosShape pos,
                     Color color, int sizeOne, int sizeTwo, shapeType type);

  /**
   * Clears the shape with the specified ID from the model.
   * @param name the name of the shape to be cleared
   */
  void clearShape(String name);

  /**
   * Adds the specified shape to the model.
   * @param newShape the shape to be added to the model
   */
  void addShape(IShape newShape);

  /**
   * Returns a string representation of all the shapes in the model.
   * @return a string representation of all the shapes in the model
   */
  String printShape();

  /**
   * Changes the color of the shape with the specified ID to the specified color.
   * @param name the name of the shape whose color should be changed
   * @param newColor the new color to be set for the shape
   */
  void changeShapeColor(String name, Color newColor);

  /**
   * Changes the position of the shape with the specified ID to the specified position.
   * @param name the name of the shape whose position should be changed
   * @param newPos the new position to be set for the shape
   */
  void changeShapePos(String name, PosShape newPos);

  /**
   * Changes the size of shape depends on the type of shape.
   * @param name name of the shape whose size should be changed
   * @param size1 the size 1
   * @param size2 the size 2
   */
  void changeSize(String name, int size1, int size2);

  /**
   * Adds a snapshot of the current state of the model to the snapshot list.
   * @param description a description of the snapshot to be added
   */
  void addSnapShot(String description);

  /**
   * Returns a string representation of all the snapshots taken of the model.
   * @return a string representation of all the snapshots taken of the model
   */
  String printSnapShot();

  /**
   * Resets the snapshot list by removing all the snapshots from it.
   */
  void resetSnapShot();

  /**
   * Returns a list of descriptions of all the snapshots taken of the model.
   * @return a list of descriptions of all the snapshots taken of the model
   */
  List<String> getDescription();

  /**
   * Returns a list of timestamps for all the snapshots taken of the model.
   * @return a list of timestamps for all the snapshots taken of the model
   */
  List<String> getTimeStampList();

  /**
   * Returns a list of IDs of all the snapshots taken of the model.
   * @return a list of IDs of all the snapshots taken of the model
   */
  List<String> getSnapShotIdList();

  /**
   * Returns a map of snapshots, where each snapshot is identified,
   * by its ID, and contains a list of shapes.
   * @return a map of snapshots for viewing
   */
  HashMap<String, List<IShape>> ViewSnapShot();
}

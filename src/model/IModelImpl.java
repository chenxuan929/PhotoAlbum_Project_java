package model;

import shape.IShape;
import shape.Color;
import shape.OvalShape;
import shape.PosShape;
import shape.RectangleShape;
import shape.shapeType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation of the IModel interface,
 * representing a model that stores shapes and snapshots.
 */
public class IModelImpl implements IModel {
  private List<IShape> shape;
  private HashMap<String, Integer> shapeName;
  private HashMap<String, String> snapshot;
  private List<String> snapshotId;
  private List<String> timeStamp;
  private List<String> description;
  private HashMap<String, List<IShape>> ViewSnapshots;
  private static final int flag1 = 0;
  private static final int flag2 = 1;

  /**
   * Constructs a new IModelImpl object with empty lists，
   * and hash maps for shapes, snapshots, and other related data.
   */
  public IModelImpl() {
    this.shape = new ArrayList<>();
    this.shapeName = new HashMap<>();
    this.snapshot = new HashMap<>();
    this.snapshotId = new ArrayList<>();
    this.timeStamp = new ArrayList<>();
    this.ViewSnapshots = new HashMap<>();
    this.description = new ArrayList<>();
  }

  /**
   * Creates a new shape with the given name, position, color, size, and type.
   * @param name the name of the new shape
   * @param pos the position of the new shape
   * @param color the color of the new shape
   * @param sizeOne the size of the first dimension of the new shape
   * @param sizeTwo the size of the second dimension of the new shape
   * @param type the type of the new shape
   * @return the new shape created
   */
  @Override
  public IShape createShape(String name, PosShape pos, Color color, int sizeOne, int sizeTwo, shapeType type) {
    IShape shape;
    switch (type.getStrShape().toLowerCase()) {
      case "rectangle":
        shape = new RectangleShape(name, type, pos, sizeOne, sizeTwo, color);
        break;
      case "oval":
        shape = new OvalShape(name, type, pos, sizeOne, sizeTwo, color);
        break;
      default:
        shape = null;
    }
    return shape;
  }

  /**
   * Removes a shape with the given name from the model.
   * @param id the name of the shape to be cleared
   * @throws IllegalArgumentException if the shape does not exist in the model
   */
  @Override
  public void clearShape(String id) throws IllegalArgumentException {
    Integer index = shapeName.get(id);
    if (index == null) {
      throw new IllegalArgumentException("The shape does not exist.");
    }
    shape.remove(index.intValue());
    shapeName.remove(id);
    for (int i = index.intValue(); i < shape.size(); i++) {
      shapeName.replace(shape.get(i).getName(), i);
    }
  }

  /**
   * Adds a new shape to the model.
   * @param newShape the shape to be added to the model
   * @throws IllegalArgumentException if the new shape is null or already exists in the model
   */
  @Override
  public void addShape(IShape newShape) throws IllegalArgumentException {
    if (newShape == null) {
      throw new IllegalArgumentException("The new shape is null.");
    }
    if (shapeName.containsKey(newShape.getName())) {
      throw new IllegalArgumentException("The new shape already exists.");
    }
    int newIndex = shape.size();
    shape.add(newShape);
    shapeName.put(newShape.getName(), newIndex);
  }

  /**
   * Returns a string representation of all shapes currently in the model.
   * @return a string representation of all shapes in the model
   */
  @Override
  public String printShape() {
    String st = "Shape Information:\n";
    for (IShape shape: this.shape) {
      st += shape.toString();
    }
    return st;
  }

  /**
   * Changes the color of a shape with the given name.
   * @param id the name of the shape whose color should be changed
   * @param newColor the new color to be set for the shape
   * @throws IllegalArgumentException if the shape does not exist in the model
   */
  @Override
  public void changeShapeColor(String id, Color newColor) throws IllegalArgumentException {
    if (!shapeName.containsKey(id)) {
      throw new IllegalArgumentException("The shape does not exist.");
    }
    this.shape.get(this.shapeName.get(id)).setColor(newColor);
  }

  /**
   * Changes the position of a shape with the given name.
   * @param id the name of the shape to be changed
   * @param newPos the new position to be set for the shape
   * @throws IllegalArgumentException if the shape does not exist in the model
   */
  @Override
  public void changeShapePos(String id, PosShape newPos) throws IllegalArgumentException {
    if (!shapeName.containsKey(id)) {
      throw new IllegalArgumentException("The shape need to be change does not exist.");
    }
    this.shape.get(this.shapeName.get(id)).setPos(newPos);
  }

  /**
   * Changes the size of a shape with the given name.
   * @param name name of the shape whose size should be changed
   * @param size1 the size 1
   * @param size2 the size 2
   * @throws IllegalArgumentException if the shape does not exist in the model
   */
  @Override
  public void changeSize(String name, int size1, int size2) throws IllegalArgumentException {
    if (!shapeName.containsKey(name)) {
      throw new IllegalArgumentException("The shape need to be change does not exist.");
    }
    this.shape.get(this.shapeName.get(name)).setSizeValue(size1, size2);
  }

  /**
   * Adds a snapshot of the current state of the model with the given description.
   * @param description a description of the snapshot to be added
   */
  @Override
  public void addSnapShot(String description) {
    LocalDateTime now = LocalDateTime.now();
    String id = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now);
    String time = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(now);
    String st = String.format("Snapshot ID: %s\nTimestamp: %s\nDescription: %s\nShape Information:",
      id, time, description);

    for (IShape shape : this.shape) {
      st += "\n" + "Name: " + shape.getName() + "\n"
        + "Type: " + shape.getType().getStrShape() + "\n";
      switch (shape.getType().getStrShape().toLowerCase()) {
        case "rectangle":
          st += "Min corner: (" + shape.getPos().getXPos() + "," + shape.getPos().getYPos()
            + "), Width: " + shape.getSizeOne() + ", Height: " + shape.getSizeTwo()
            + ", Color: (" + shape.getColor().getR() + "," + shape.getColor().getG()
            + "," + shape.getColor().getB() + ")" + "\n";
          break;
        case "oval":
          st += "Center: (" + shape.getPos().getXPos() + "," + shape.getPos().getYPos()
            + "), X radius: " + shape.getSizeOne() + ", Y radius: " + shape.getSizeTwo()
            + ", Color: (" + shape.getColor().getR() + "," + shape.getColor().getG()
            + "," + shape.getColor().getB() + ")" + "\n";
          break;
        default:
      }
    }
    this.description.add(description);
    this.snapshotId.add(id);
    this.timeStamp.add(time);
    ArrayList<IShape> copylist = new ArrayList<>();
    for (IShape shape : this.shape) {
      copylist.add(shape.copy());
    }
    this.ViewSnapshots.put(id, copylist);
    this.snapshot.put(id, st.substring(flag1, st.length() - flag2));
   }

  /**
   * Returns a string representation of all the stored snapshots.
   * @return a string representing all the snapshots.
   */
  @Override
  public String printSnapShot() {
    StringBuilder sb = new StringBuilder("Printing Snapshots\n");
    this.snapshotId.forEach(snapshotId -> sb.append(this.snapshot.get(snapshotId)).append("\n\n"));
    return sb.toString();
  }

  /**
   * Clears all stored snapshots.
   */
  @Override
  public void resetSnapShot() {
    StringBuilder sb = new StringBuilder();
    sb.append("List of snapshots taken before reset: ");
    sb.append(String.join(", ", this.snapshotId));
    System.out.println(sb.toString());
    this.snapshotId.clear();
    this.snapshot.clear();
  }

  /**
   * Returns the description list of shapes stored in the snapshot.
   * @return a list of string descriptions of shapes.
   */
  @Override
  public List<String> getDescription() {
    return this.description;
  }

  /**
   * Returns the timestamp list of snapshots.
   * @return a list of string timestamps for each snapshot.
   */
  @Override
  public List<String> getTimeStampList() {
    return this.timeStamp;
  }

  /**
   * Returns the snapshot ID list.
   * @return a list of string IDs for each stored snapshot.
   */
  @Override
  public List<String> getSnapShotIdList() {
    return this.snapshotId;
  }

  /**
   * Returns a hashmap of all the stored snapshots with their respective IDs.
   * @return a hashmap with the ID of the snapshot as the key,
   * and a list of shapes as the value.
   */
  @Override
  public HashMap<String, List<IShape>> ViewSnapShot() {
    return this.ViewSnapshots;
  }
}

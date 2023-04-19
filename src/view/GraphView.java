package view;

import shape.IShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

/**
 * A JFrame class that displays an album of snapshots of shapes with their respective IDs and descriptions.
 */
public class GraphView extends JFrame {
  private HashMap<String, List<IShape>> snapshot;
  private List<String> snapshotId;
  private List<String> description;
  private int currentSnapshot;
  private int width;
  private int height;
  private JPanel northView;
  private JPanel southView;
  private JPanel centerView;
  private JButton Next;
  private JButton Prev;
  private JButton Select;
  private JButton Quit;

  /**
   * Constructs a GraphView object with a given HashMap of snapshots, a List of snapshot IDs, a List of descriptions,
   * @param snapshot a HashMap of snapshots where each snapshot is a list of IShape objects
   * @param snapshotId a List of snapshot IDs
   * @param description a List of snapshot descriptions
   * @param maxX the maximum X-coordinate value for the shapes
   * @param maxY the maximum Y-coordinate value for the shapes
   */
  public GraphView(HashMap<String, List<IShape>> snapshot, List<String> snapshotId, List<String> description, int maxX, int maxY) {
    this.snapshot = snapshot;
    this.snapshotId = snapshotId;
    this.description = description;

    this.currentSnapshot = 0;
    this.width = maxX;
    this.height = maxY;

    this.setSize(width, height);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("cs5004 Shapes Photo Album Viewer");

    this.setLayout(new BorderLayout());
    this.northView = new JPanel();
    this.centerView = new PaintPanel(this.snapshot.get(this.snapshotId.get(this.currentSnapshot)));
    this.southView = new JPanel();
    this.add(northView, BorderLayout.NORTH);
    this.add(centerView, BorderLayout.CENTER);
    this.add(southView, BorderLayout.SOUTH);
    this.paintNorth(northView);
    this.paintSouth(southView);
  }

  /**
   * Paints components to the north panel of the frame, including the current snapshot ID and its description.
   * @param northView a JPanel in the north of the frame
   */
  public void paintNorth(JPanel northView) {
    northView.setPreferredSize(new Dimension(0,25));
    northView.setBackground(Color.pink);
    northView.add(new JLabel(this.snapshotId.get(currentSnapshot)));
    northView.add(new JLabel("\nDescription: " + this.description.get(currentSnapshot)));
  }

  /**
   * Paints components to the south panel of the frame, including the "Prev", "Next", "Select", and "Quit" buttons.
   * @param southView a JPanel in the south of the frame
   */
  public void paintSouth(JPanel southView) {
    southView.setPreferredSize(new Dimension(0,45));
    southView.setBackground(Color.yellow);
    Prev = new JButton("<< Prev <<");
    Prev.setActionCommand("Prev");
    southView.add(Prev);
    Next = new JButton(">> Next >>");
    Next.setActionCommand("Next");
    southView.add(Next);
    Select = new JButton("^^ Select ^^");
    Select.setActionCommand("Select");
    southView.add(Select);
    Quit = new JButton("xx Quit xx");
    Quit.setActionCommand("Quit");
    southView.add(Quit);
  }

  /**
   * Sets the listener for the action events on the buttons in the GUI.
   * @param l object to use as the listener
   */
  public void setListener(ActionListener l) {
    this.Prev.addActionListener(l);
    this.Next.addActionListener(l);
    this.Select.addActionListener(l);
    this.Quit.addActionListener(l);
  }

  /**
   * Clears the center panel of the GUI.
   */
  public void clearCenter() {
    this.centerView.revalidate();
  }

  /**
   * Clears the north panel of the GUI.
   */
  public void clearNorth() {
    this.northView.revalidate();
  }

  /**
   * Updates the center panel of the GUI with the latest snapshot of the canvas.
   */
  public void updateCenter() {
    this.centerView = new PaintPanel(this.snapshot.get(this.snapshotId.get(this.currentSnapshot)));
    this.add(centerView, BorderLayout.CENTER);
  }

  /**
   * Updates the north panel of the GUI with the description of the current snapshot.
   */
  public void updateNorth() {
    this.northView = new JPanel();
    this.northView.setPreferredSize(new Dimension(0,25));
    this.northView.setBackground(Color.pink);
    northView.add(new JLabel("\nDescription: " + this.description.get(currentSnapshot)));
    this.add(northView, BorderLayout.NORTH);
  }

  /**
   * Sets the current snapshot to the specified index.
   * @param cur the index of the snapshot to set as current
   */
  public void setCurrentSnapshot(int cur) {
    this.currentSnapshot = cur;
  }

  /**
   * Returns the index of the snapshot with the specified ID.
   * @return the index of the snapshot with the specified ID
   */
  public int getCurrentSnapshot() {
    return this.currentSnapshot;
  }

  /**
   * Returns an array of all the snapshot IDs.
   * @param Id id of snapshot.
   * @return an array of all the snapshot IDs
   */
  public int getSnapshotIndex(String Id) {
    return this.snapshotId.indexOf(Id);
  }

  /**
   * Returns the index of the current snapshot.
   * @return the index of the current snapshot
   */
  public Object[] getSnapshotIdList() {
    return this.snapshotId.toArray();
  }
}

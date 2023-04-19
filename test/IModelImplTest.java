import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import shape.IShape;
import shape.Color;
import shape.PosShape;
import shape.shapeType;
import model.IModel;
import model.IModelImpl;

/**
 * Test for the IModelImpl class.
 */
public class IModelImplTest {
  IShape R1;
  IShape R2;
  IShape O1;
  IShape O2;
  IModel model;

  /**
   * Set up the test fixture.
   */
  @Before
  public void setUp() {
    model = new IModelImpl();
    R1 = model.createShape("rect1", new PosShape(100,100),
      new Color(10, 10, 10), 300, 150, shapeType.RECTANGLE);
    O1 = model.createShape("oval1", new PosShape(90, 70),
      new Color(44,55,66), 40, 50, shapeType.OVAL);
  }

  /**
   * Test the createShape method of the IModelImpl class.
   */
  @Test
  public void CreateShapeTest() {
    IShape s = model.createShape("testCreate", new PosShape(1,2),
      new Color(1,2,3), 5,5, shapeType.RECTANGLE);
    assertEquals("RECTANGLE", s.getType().toString());
    assertEquals("(1, 2, 3)", s.getColor().toString());
  }

  /**
   * Test the clearShape method of the IModelImpl class.
   */
  @Test
  public void clearShapeTest() {
    model.addShape(R1);
    model.addShape(O1);
    String s2 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n" +
      "Name: oval1\n" +
      "Type: OVAL\n" +
      "Position: (90, 70)\n" +
      "Color: (44, 55, 66)\n" +
      "X radius: 40\n" +
      "Y radius: 50\n";
    assertEquals(s2, model.printShape());
    model.clearShape("oval1");
    String s1 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n";
    assertEquals(s1, model.printShape());

    //Test edge case when clear null or empty or a name doesn't exist.
    assertThrows(IllegalArgumentException.class, () -> model.clearShape(""));
    assertThrows(IllegalArgumentException.class, () -> model.clearShape(null));
    assertThrows(IllegalArgumentException.class, () -> model.clearShape("DontExist"));
  }

  /**
   * Test the addShape method of the IModelImpl class.
   */
  @Test
  public void addShapeTest() {
    model.addShape(R1);
    String s1 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n";
    assertEquals(s1, model.printShape());
    model.addShape(O1);
    String s2 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n" +
      "Name: oval1\n" +
      "Type: OVAL\n" +
      "Position: (90, 70)\n" +
      "Color: (44, 55, 66)\n" +
      "X radius: 40\n" +
      "Y radius: 50\n";
    assertEquals(s2, model.printShape());

    //Test edge case if add same shape or add null.
    R2 = model.createShape("rect1", new PosShape(100,100),
      new Color(10, 10, 10), 300, 150, shapeType.RECTANGLE);
    assertThrows(IllegalArgumentException.class, () -> model.addShape(R2));
    assertThrows(IllegalArgumentException.class, () -> model.addShape(null));
  }

  /**
   * Test the changeShapeColor method of the IModelImpl class.
   */
  @Test
  public void changeShapeColorTest() {
    model.addShape(R1);
    String s1 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n";
    assertEquals(s1, model.printShape());
    model.changeShapeColor("rect1", new Color(99,99,99));
    String s2 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (99, 99, 99)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n";
    assertEquals(s2, model.printShape());

    //Test edge case when change a valid or invalid color to a not exist or null shape.
    assertThrows(IllegalArgumentException.class, () -> model.changeShapeColor("", new Color(1,2,3)));
    assertThrows(IllegalArgumentException.class, () -> model.changeShapeColor("NotEXIST", new Color(3,2,1)));
    assertThrows(IllegalArgumentException.class, () -> model.changeShapeColor("rect1", new Color(999,10,10)));
    assertThrows(IllegalArgumentException.class, () -> model.changeShapeColor("rect1", new Color(-1,10,10)));
  }

  /**
   * Test the changeSize method of the IModelImpl class.
   */
  @Test
  public void changeSizeTest() {
    model.addShape(R1);
    String s1 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n";
    assertEquals(s1, model.printShape());
    model.changeSize("rect1", 999, 999);
    String s2 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 999.0\n" +
      "Height: 999.0\n";
    assertEquals(s2, model.printShape());

    //Test edge case when change size to a not exist or null shape.
    assertThrows(IllegalArgumentException.class, () -> model.changeSize("", 100,100));
    assertThrows(IllegalArgumentException.class, () -> model.changeSize("NotEXIST", 0,0));
    assertThrows(IllegalArgumentException.class, () -> model.changeSize(null, 100,100));
  }

  /**
   * Test the changeShapePos method of the IModelImpl class.
   */
  @Test
  public void changeShapePosTest() {
    model.addShape(R1);
    String s1 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n";
    assertEquals(s1, model.printShape());
    model.changeShapePos("rect1", new PosShape(1,1));
    String s2 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (1, 1)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n";
    assertEquals(s2, model.printShape());

    //Test edge case when change position to a not exist or null shape.
    assertThrows(IllegalArgumentException.class, () -> model.changeShapePos("", new PosShape(1,1)));
    assertThrows(IllegalArgumentException.class, () -> model.changeShapePos("NotEXIST", new PosShape(1,1)));
    assertThrows(IllegalArgumentException.class, () -> model.changeShapePos(null, new PosShape(1,1)));
  }

  /**
   * Test the addSnapShot method of the IModelImpl class.
   */
  @Test
  public void addSnapShotTest() {
    model.addShape(R1);
    model.addShape(O1);
    model.addSnapShot("this is a snapshot");
    List<String> snaplist = model.getSnapShotIdList();
    List<String> timelist = model.getTimeStampList();

    assertFalse(snaplist.isEmpty());
    assertFalse(timelist.isEmpty());

    assertEquals("Printing Snapshots\n" +
      "Snapshot ID: " + snaplist.get(0) + "\n" +
      "Timestamp: " + timelist.get(0) + "\n" +
      "Description: this is a snapshot\n" +
      "Shape Information:\n" +
      "Name: rect1\n" +
      "Type: rectangle\n" +
      "Min corner: (100,100), Width: 300, Height: 150, Color: (10,10,10)\n" +
      "\n" +
      "Name: oval1\n" +
      "Type: oval\n" +
      "Center: (90,70), X radius: 40, Y radius: 50, Color: (44,55,66)\n" +
      "\n", model.printSnapShot());
  }

  /**
   * Test the resetSnapShot method of the IModelImpl class.
   */
  @Test
  public void resetSnapShotTest() {
    model.addShape(R1);
    model.addShape(O1);
    model.addSnapShot("this is a snapshot");
    List<String> snapshotIds = model.getSnapShotIdList();
    List<String> timeStamps = model.getTimeStampList();
    assertEquals("Printing Snapshots\n" +
      "Snapshot ID: " + snapshotIds.get(0) + "\n" +
      "Timestamp: " + timeStamps.get(0) + "\n" +
      "Description: this is a snapshot\n" +
      "Shape Information:\n" +
      "Name: rect1\n" +
      "Type: rectangle\n" +
      "Min corner: (100,100), Width: 300, Height: 150, Color: (10,10,10)\n" +
      "\n" + "Name: oval1\n" + "Type: oval\n" +
      "Center: (90,70), X radius: 40, Y radius: 50, Color: (44,55,66)\n" +
      "\n", model.printSnapShot());
    model.resetSnapShot();
    assertEquals("Printing Snapshots\n", model.printSnapShot());
  }

  /**
   * Test the ClearShape method of the IModelImpl class.
   */
  @Test
  public void testClearShape() {
    model.addShape(R1);
    String s1 = "Shape Information:\n" + "Name: rect1\n" +
      "Type: RECTANGLE\n" +
      "Position: (100, 100)\n" +
      "Color: (10, 10, 10)\n" +
      "Width: 300.0\n" +
      "Height: 150.0\n";
    assertEquals(s1, model.printShape());
    model.clearShape("rect1");
    String s2 = "Shape Information:\n";
    assertEquals(s2, model.printShape());
  }
}
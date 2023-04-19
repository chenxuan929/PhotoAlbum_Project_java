import static org.junit.Assert.assertEquals;

import model.IModel;
import model.IModelImpl;
import view.SvgView;
import org.junit.Before;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SvgViewTest {
  IModel model;
  SvgView svgView;


  @Before
  public void setUp() throws Exception {
    this.model = new IModelImpl();
    ShapeFileParser.parseFile("buildings.txt", model);
    this.svgView = new SvgView(model.ViewSnapShot(), model.getSnapShotIdList(), model.getDescription(),
    "buildingsOut.html", 1000, 1000);
  }

  @Test
  public void testGeneralHTML() {
    assertEquals("<!DOCTYPE html>\n" +
      "<html>\n" +
      "<body>\n" +
      "<h1>Chenxuan Xu's SVG Gallery</h1>\n" +
      "<div>\n" +
      "<h2>"+ model.getSnapShotIdList().get(0) + "</h2>\n" +
      "<h3>Description: </h3>\n" +
      "<svg width=\"1000\" height=\"1000\">\n" +
      "<rect name=\"background\" x=\"0\" y=\"0\" width=\"800\" height=\"800\" fill=\"rgb(33,94,248)\">" + "\n</rect>\n" +
      "<rect name=\"B0\" x=\"80\" y=\"424\" width=\"100\" height=\"326\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B1\" x=\"260\" y=\"365\" width=\"100\" height=\"385\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B2\" x=\"440\" y=\"375\" width=\"100\" height=\"375\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B3\" x=\"620\" y=\"445\" width=\"100\" height=\"305\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"window000\" x=\"100\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window001\" x=\"140\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window010\" x=\"100\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window011\" x=\"140\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "</svg>\n" +
      "</div>\n" +
      "<div>\n" +
      "<h2>"+ model.getSnapShotIdList().get(1) + "</h2>\n" +
      "<h3>Description: </h3>\n" +
      "<svg width=\"1000\" height=\"1000\">\n" +
      "<rect name=\"background\" x=\"0\" y=\"0\" width=\"800\" height=\"800\" fill=\"rgb(33,94,248)\">" + "\n</rect>\n" +
      "<rect name=\"B0\" x=\"80\" y=\"424\" width=\"100\" height=\"326\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B1\" x=\"260\" y=\"365\" width=\"100\" height=\"385\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B2\" x=\"440\" y=\"375\" width=\"100\" height=\"375\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B3\" x=\"620\" y=\"445\" width=\"100\" height=\"305\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"window000\" x=\"100\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window001\" x=\"140\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window010\" x=\"100\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window011\" x=\"140\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window002\" x=\"280\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window021\" x=\"320\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window022\" x=\"280\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window200\" x=\"320\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "</svg>\n" +
      "</div>\n" +
      "<div>\n" +
      "<h2>"+ model.getSnapShotIdList().get(2) + "</h2>\n" +
      "<h3>Description: Turn on the Lights!</h3>\n" +
      "<svg width=\"1000\" height=\"1000\">\n" +
      "<rect name=\"background\" x=\"0\" y=\"0\" width=\"800\" height=\"800\" fill=\"rgb(33,94,248)\">" + "\n</rect>\n" +
      "<rect name=\"B0\" x=\"80\" y=\"424\" width=\"100\" height=\"326\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B1\" x=\"260\" y=\"365\" width=\"100\" height=\"385\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B2\" x=\"440\" y=\"375\" width=\"100\" height=\"375\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"B3\" x=\"620\" y=\"445\" width=\"100\" height=\"305\" fill=\"rgb(0,0,0)\">" + "\n</rect>\n" +
      "<rect name=\"window000\" x=\"100\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window001\" x=\"140\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window010\" x=\"100\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window011\" x=\"140\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window002\" x=\"280\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window021\" x=\"320\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window022\" x=\"280\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window200\" x=\"320\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window003\" x=\"460\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window033\" x=\"500\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window333\" x=\"460\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window313\" x=\"500\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window004\" x=\"640\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window044\" x=\"680\" y=\"500\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window444\" x=\"640\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<rect name=\"window414\" x=\"680\" y=\"600\" width=\"20\" height=\"20\" fill=\"rgb(255,255,255)\">" + "\n</rect>\n" +
      "<ellipse name=\"moon\" cx=\"200\" cy=\"200\" rx=\"100\" ry=\"100\" fill=\"rgb(229,229,255)\">" +
      "\n</ellipse>\n" +
      "</svg>\n" +
      "</div>\n" +
      "</body>\n" +
      "</html>", svgView.generalHTML());
  }

  @Test
  public void testOutputFile() throws IOException {
    svgView.outputFile();
    BufferedReader reader = new BufferedReader(new FileReader("buildingsOut.html"));
    StringBuilder builder = new StringBuilder();
    StringBuffer buffer;
    while (reader.ready()) {
      buffer = (new StringBuffer(reader.readLine()));
      builder.append(buffer).append("\n");
    }
    assertEquals(svgView.generalHTML(), builder.substring(0, builder.length() - 1));
    reader.close();
  }
}
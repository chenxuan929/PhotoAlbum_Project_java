# PhotoAlbum_Project_java
## final project for CS5004 in Spring 2023

This is a simple album editing model that allows users to create and edit shapes on one page of an album. The application supports 2D graphics, including ovals and rectangles.

### Structure
The project is divided into several packages:
* package model: Contains the interfaces and implementations for the shapes and the album.
   * IShape: Defines the attributes of a shape, such as name, position, size, color, and type.
   * ShapeImpl: An abstract class that implements IShape. It acts as a base class for all shapes in the system and provides common functionality shared by all shapes to avoid code duplication.
   * OvalShape and RectangleShape: Concrete classes that extend ShapeImpl and implement accurate operations for their respective shapes.
   * IModel: Defines the operations on one page of the album, such as create, add, print, change, clear, and include extra operations to add snapshot, description, and timestamp.
   * IModelImpl: A concrete class that implements IModel. It provides a concrete implementation of the methods defined in the IModel interface, such as addShape, removeShape, getShapes, and getShapesByType. This class separates the concerns, making it easier to add new functions in the future and make the code more flexible.
* package view: Contains the classes responsible for the visual representation of the shapes and the album.
  * GraphView: A class responsible for rendering shapes using graphics.
  * PaintPanel: A class responsible for drawing the shapes on the screen.
  * SvgView: A class responsible for generating SVG files that represent the shapes.
* package controller: Contains the classes that control the interaction between the user and the model.
  * Controller: A class that listens for user input and updates the model and view accordingly.
*  class ShapeFileParser: the class responsible for parsing the input file.

### Testing
For each class, independent tests have been created, including all edge cases and exceptions. The tests are located in the test package and are separate from the main packages to keep the project structure concise.


### Usage
To use the application, run the PhotoAlbumMain class. The following command-line arguments are supported:
* -in <filename>: Specifies the input file.
* -v <view> or -view <view>: Specifies the view to be used (GRAPHICAL or WEB).
* -out <filename>: Specifies the output file (required for the WEB view).



  

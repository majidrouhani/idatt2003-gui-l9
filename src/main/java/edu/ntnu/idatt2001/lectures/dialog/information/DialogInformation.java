/* Online help: https://code.makery.ch/blog/javafx-dialogs-official/
 */

package edu.ntnu.idatt2001.lectures.dialog.information;

import edu.ntnu.idatt2001.lectures.dialog.controller.MainDialogController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DialogInformation extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("My first stage with scene");

    VBox vbox = new VBox();
    MenuBar mainMenu = createMenus();

    vbox.getChildren().add(mainMenu);

    BorderPane root  = new BorderPane();

    root.setTop(vbox);

    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }

  /**
   * Creates the menus to be displayed.
   */
  private MenuBar createMenus() {
    // Create the Menu Bar to hold all the menus
    MenuBar menuBar = new MenuBar();

    // The File-menu
    Menu fileMenu = new Menu("File");
    MenuItem fileOpen = new MenuItem("Open");
    MenuItem filePrint = new MenuItem("Print");
    filePrint.setDisable(true);
    MenuItem fileExit = new MenuItem("Exit");
    fileExit.setOnAction(MainDialogController::exit);

    fileMenu.getItems().add(fileOpen);
    fileMenu.getItems().add(filePrint);
    fileMenu.getItems().add(new SeparatorMenuItem());
    fileMenu.getItems().add(fileExit);

    // The Edit-menu
    Menu editMenu = new Menu("Edit");

    // The View-menu
    Menu viewMenu = new Menu("View");

    // The View-menu
    Menu helpMenu = new Menu("Help");
    MenuItem helpAbout = new MenuItem("About");
    helpAbout.setOnAction(MainDialogController::about);
    helpMenu.getItems().addAll(helpAbout);

    menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu, helpMenu);

    return menuBar;
  }

}
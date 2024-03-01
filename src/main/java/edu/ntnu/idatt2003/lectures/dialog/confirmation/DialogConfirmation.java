/* https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/menu_controls.htm
 * Online help: https://openjfx.io/openjfx-docs/#maven
 * Non-modular from IDE
 * Run argument: --module-path "C:\git\javafx\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
 * 
 */

package edu.ntnu.idatt2003.lectures.dialog.confirmation;

import edu.ntnu.idatt2003.lectures.dialog.controller.MainDialogController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DialogConfirmation extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("My first stage with scene");
    BorderPane root  = new BorderPane();

    VBox vbox = new VBox();
    MenuBar mainMenu = createMenus();

    vbox.getChildren().add(mainMenu);
    root.setTop(vbox);
    
    Scene scene = new Scene(root, 300, 250);

    primaryStage.setScene(scene);

    primaryStage.show();
  }

  /**
   * Creates the menus to be displayed.
   */
  private MenuBar createMenus() {
    // Create the Menu Bar to hold all the menus
    MenuBar menuBar = new MenuBar();

    // The File-menu
    Menu menu = new Menu("File");
    MenuItem fileOpen = new MenuItem("Open");
    MenuItem filePrint = new MenuItem("Print");
    filePrint.setDisable(true);
    MenuItem fileExit = new MenuItem("Exit");
    fileExit.setOnAction(MainDialogController::exit);

    menu.getItems().add(fileOpen);
    menu.getItems().add(filePrint);
    menu.getItems().add(new SeparatorMenuItem());
    menu.getItems().add(fileExit);
    
    // The Edit-menu
    Menu menuEdit = new Menu("Edit");
    
    // The View-menu
    Menu menuView = new Menu("View");

    menuBar.getMenus().addAll(menu, menuEdit, menuView);

    return menuBar;
  }

}
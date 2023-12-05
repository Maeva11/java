package application;
  
import java.net.URL;

import entite.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      Parent rootFXML = FXMLLoader.load(getClass().getResource("View.fxml"));
      Scene sceneFXML = new Scene(rootFXML);
      
      //title application
      primaryStage.setTitle("Fantast'Picture ");
      
      URL cssURL = getClass().getResource("application.css");
      sceneFXML.getStylesheets().add(cssURL.toExternalForm());
      
      primaryStage.setScene(sceneFXML);
      primaryStage.show();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    launch(args);
    }
}
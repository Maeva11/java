package application;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		  Parent rootFXML = FXMLLoader.load(getClass().getResource("/vues/Vue.fxml"));
		  Scene sceneFXML = new Scene(rootFXML);
		  
		  //title application
		  primaryStage.setTitle("Exo 1 JAVA FXML");
		  
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
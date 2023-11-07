package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Controller implements Initializable {

  @FXML
  private Label labelCouleur;
  @FXML
  private Label labelTaille;
  @FXML
  private Label price; 
  @FXML 
  private ChoiceBox<String> choixCouleur = new ChoiceBox<String>(); 
  private final String[] couleurs = {"rouge", "vert", "bleu"};
  @FXML 
  private ChoiceBox<String> choixTaille = new ChoiceBox<String>(); 
  private final String[] taille = {"S", "M", "L"};
        
  private String selectedImage = "@course.jpeg";
  @FXML
  private ImageView veloVille;

  @FXML
  private ImageView veloCourse;
  
  private StringProperty selectedImageProperty = new SimpleStringProperty("@course.jpeg");

  public String getSelectedImage() {
      return selectedImageProperty.get();
  }

  public void setSelectedImage(String selectedImage) {
      this.selectedImageProperty.set(selectedImage);
  }

  @FXML
  private void getDetails(MouseEvent event) throws IOException {
      if (event.getSource() == veloVille) {
          selectedImage = "@ville.jpeg";
      } else if (event.getSource() == veloCourse) {
          selectedImage = "@course.jpeg";
      }

      System.out.println(selectedImage);
      Parent detail = FXMLLoader.load(getClass().getResource("/vues/vueDetail.fxml"));
      Scene scene2 = new Scene(detail);
      
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene2);
      stage.show();
  }
  
  public void back(MouseEvent event) throws IOException {
    Parent main = FXMLLoader.load(getClass().getResource("/vues/vue.fxml"));
    Scene scene1 = new Scene(main);
    
    Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene1);
    stage.show();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO Auto-generated method stub
    choixCouleur.getItems().addAll(couleurs);
    choixTaille.getItems().addAll(taille);
    
    choixCouleur.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          labelCouleur.setText(newValue);
          switch (newValue) {
            case "rouge" :
              System.out.println(price.getText());
              break;
            case "bleu" :
              System.out.println("bleu");
              break;
            case "vert" :
              System.out.println("vert");
              break;
          }
      }
    });
    
    choixTaille.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        labelTaille.setText(newValue);
      }
    });
   }
}

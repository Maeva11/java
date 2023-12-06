package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import org.json.simple.parser.ParseException;

import entite.Connexion;
import entite.Post;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.Modele;

public class Controller implements Initializable{
  
  @FXML
  public ListView<String> listViewPost;
  @FXML 
  public Label infoDataPost;
  @FXML
  public Label infoData; 
  @FXML
  public TextField textID; 
  
  Modele modele;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      modele = new Modele();
      Connexion.connectBDD();

      updateListView();    
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }   
  }

  private void updateListView() throws SQLException {
    ArrayList<Post> posts = modele.SelectAllData();

    listViewPost.getItems().clear();
    
    for(Post post: posts) {
      listViewPost.getItems().addAll(post.getTitle());
    }
  }
  
  public void ValueTitle() throws SQLException {
    String selectedTitle = listViewPost.getSelectionModel().getSelectedItem();
    Modele modele = new Modele();
    ArrayList<Post> posts = modele.SelectAllData();

    for (Post post : posts) {
        if (post.getTitle().equals(selectedTitle)) {
          infoDataPost.setText(post.getBody());
        }
    }
  }
  
  public void includeData(MouseEvent e) throws SQLException, ParseException {
    try {
      Modele.getDataFromURL();
      infoData.setText("Données ajoutées");
      this.updateListView();
    }catch (SQLException e1) {
      e1.printStackTrace();
    }
  }
  
  public void deletePostByID(MouseEvent e) throws SQLException {
    String text = textID.getText();
    try {
      if(text != null ) {
        Modele.deleteData(text); 
        this.updateListView();
        infoData.setText("Données supprimées");
      } else {
        infoData.setText("l'id n'est pas renseigné");
      }
  } catch (SQLException e1) {
      e1.printStackTrace();
      infoData.setText("l'id n'existe pas. Veuillez en choisir un autre");
  }
 }
}

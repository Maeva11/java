package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.Modele;

public class Controller implements Initializable {
    private Modele modele;

    @FXML
    public Label labelError;
    @FXML
    public TextField noteField;
    @FXML
    public TextField nameField;
    @FXML
    public TextField password;
    @FXML
    public ImageView imageView;
    @FXML
    public ListView<String> listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.modele = new Modele();
    }

    public void getImageConnected(MouseEvent event) {
        listView.getItems().clear();
        labelError.setText("");

        String name = nameField.getText();

        ArrayList<String> cityName = modele.getNameAboutImage(name);
        if (name == null || name.isEmpty()) {
            labelError.setText("Veuillez vous connecter");
        } else {
            listView.getItems().addAll(cityName);
        }
    }

    public void validateNoteToFile(MouseEvent event) throws IOException {
        String note = noteField.getText();
        String name = nameField.getText();
        String selectedImage = listView.getSelectionModel().getSelectedItem();
        try {
            if (name == null || name.isEmpty()) {
                labelError.setText("Veuillez vous connecter");
            }
            if (note == null || note.isEmpty()) {
                note = "0";
            } else {
                modele.saveData(name, selectedImage, note);
            }
        } catch (NumberFormatException e) {
            String errorMessage = "Ce n'est pas valide (vide ou pas un nombre)";
        } catch (IllegalArgumentException e) {
            labelError.setText(e.getMessage());
        }
    }

    public void getValueImage(MouseEvent event) throws IOException {
        String selectedImage = listView.getSelectionModel().getSelectedItem();
        String urlImage = modele.getUrlFromCity(selectedImage);
        String name = nameField.getText();

        javafx.scene.image.Image image = new javafx.scene.image.Image(urlImage);
        imageView.setImage(image);

        String note = modele.fillDataFields(name, selectedImage);

        noteField.setText(note == null || note.isEmpty() ? "0" : note);
    }
}

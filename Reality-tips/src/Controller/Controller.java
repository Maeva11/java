package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import application.Calcul;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller implements Initializable {
  
  @FXML
  public TextField bill; 
  @FXML
  public TextField tips; 
  @FXML
  public TextField person; 
  @FXML
  public TextField labelDate; 
  
  @FXML
  public Label labelError; 
  @FXML
  public Label labelBill; 
  @FXML
  public Label labelTips; 
  @FXML
  public Label labelPerson; 
  
  @FXML
  public Label labelTotal; 
  @FXML
  public Label LabelTipTotal; 

  @FXML
  private void calculate(MouseEvent event) throws IOException {
      String billValue = bill.getText();
      String tipsValue = tips.getText();
      String personValue = person.getText();
      String labelDateValue = labelDate.getText(); 

      String billLabel = labelBill.getText();
      String tipsLabel = labelTips.getText();
      String personLabel = labelPerson.getText();
      
      try {
          float billAmount = Float.parseFloat(billValue);
          float tipsAmount = Float.parseFloat(tipsValue);
          float personCount = Float.parseFloat(personValue);

          Calcul calcul = new Calcul(billAmount, tipsAmount, personCount,labelDateValue);
          float totalPerPerson = calcul.calculateTotalPerPerson();
          labelTotal.setText(totalPerPerson + "€");
          
          float tipsPerPerson = calcul.calculateTipsPerPerson();
          LabelTipTotal.setText(tipsPerPerson + "€");
          
          calcul.isValidDateFormat(); 
          
          saveData(labelDateValue, billValue, tipsValue, personValue);
      } catch (NumberFormatException e) {
          String errorMessage =  "Ce n'est pas valide (vide ou pas un nombre)";
          
          if (e.getMessage().contains(billValue)) {
              labelError.setText(billLabel + " : " + errorMessage);
          } else if (e.getMessage().contains(tipsValue)) {
              labelError.setText(tipsLabel + " : " + errorMessage);
          } else if (e.getMessage().contains(personValue)) {
              labelError.setText(personLabel + " : " + errorMessage);
          } else {
              labelError.setText("Erreur inconnue : " + errorMessage);
          }
      }
      catch (IllegalArgumentException e) {
        labelError.setText(e.getMessage());
      }
  }


  public void saveData(String labelDateValue, String billValue, String tipsValue, String personValue) throws IOException {
    ArrayList<String> list = new ArrayList<String>();
    boolean labelDateFound = false;

    try {
        File fichier = new File("Enregistrement.txt");
        BufferedReader reader = new BufferedReader(new FileReader(fichier));

        String line;
        String newText = labelDateValue + "; " + billValue + "; " + tipsValue + "; " + personValue;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith(labelDateValue)) {
                list.add(newText);
                labelDateFound = true;
            } else {
                list.add(line);
            }
        }

        reader.close();

        if (!labelDateFound) {
            list.add(newText); 
        }

        FileOutputStream flux = new FileOutputStream(fichier);

        for (int i = 0; i < list.size(); i++) {
            flux.write(list.get(i).getBytes());
            flux.write("\n".getBytes()); 
        }

        flux.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
  
  @FXML
  public void fillDataFields(final KeyEvent event) throws IOException {
      try {
          String labelDateValue = labelDate.getText();

          File fichier = new File("Enregistrement.txt");
          BufferedReader reader = new BufferedReader(new FileReader(fichier));

          String line;
          boolean dateFound = false;

          while ((line = reader.readLine()) != null) {
              if (line.startsWith(labelDateValue)) {
                  String[] parts = line.split("; ");
                  if (parts.length >= 4) {
                      bill.setText(parts[1]); 
                      tips.setText(parts[2]); 
                      person.setText(parts[3]);
                      dateFound = true;
                      break;
                  }
              }
          }

          reader.close();

          if (!dateFound) {
              bill.setText("");
              tips.setText(""); 
              person.setText(""); 
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }


  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // TODO Auto-generated method stub
    
  }
}

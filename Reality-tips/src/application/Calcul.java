package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calcul {
  
  public float bill;
  public float tips; 
  public float person;
  public String date;
  
  public Calcul(float bill, float tips, float person, String date) {
    super();
    this.bill = bill;
    this.tips = tips;
    this.person = person;
    this.date = date;
  }
  
  public float calculateTotalPerPerson() {
    if (person > 0) {
      float Tips = tips / 100; 
      float montantTips = bill * Tips; 
      float totalWithTips = bill + montantTips;
      return totalWithTips / person;
    } else {
      throw new IllegalArgumentException("Le nombre de personne ne peux pas etre inférieur ou égal à 0");
    }
  }
  
  public float calculateTipsPerPerson() {
    if (tips > 0) {
      float Tips = tips / 100; 
      float billTotal = bill; 
      float Total = billTotal * Tips;
      return Total / person;
    }else {
      throw new IllegalArgumentException("Le Tip ne peux pas etre inférieur ou égal à 0");
    }
  }
 
  public void isValidDateFormat() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    if (date.length() == 10 && date.charAt(2) == '/' && date.charAt(5) == '/') {
      sdf.setLenient(false);
    } else {
      throw new IllegalArgumentException("Format de date invalide. Utilisez le format 'dd/mm/yyyy'.");
    }
  }

}

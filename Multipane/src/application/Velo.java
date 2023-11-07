package application;

import java.util.ArrayList;

public class Velo {

  private String type; 
  private int prixDefaut; 
  private ArrayList<Option> optionList;
  
  Velo(String type, String marque, int prixDefaut, ArrayList<Option> optionList) {
    this.type = type;
    this.prixDefaut = prixDefaut;
    this.optionList = optionList; 
    }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getPrixDefaut() {
    return prixDefaut;
  }

  public void setPrixDefaut(int prixDefaut) {
    this.prixDefaut = prixDefaut;
  }

  public ArrayList<Option> getOptionList() {
    return optionList;
  }

  public void setOptionList(ArrayList<Option> optionList) {
    this.optionList = optionList;
  }
}

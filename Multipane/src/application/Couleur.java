package application;

public class Couleur extends Option {
  private String RGB; 
  private String photoLien; 
  
  public Couleur(String libelle, float prix, String RGB, String photoLien ) {
    super(libelle, prix);
    // TODO Auto-generated constructor stub
    this.RGB = RGB;
    this.photoLien = photoLien;
  }

  public String getRGB() {  
    return RGB;
  }

  public void setRGB(String RGB) {
    this.RGB = RGB;
  }

  public String getPhotoLien() {
    return photoLien;
  }

  public void setPhotoLien(String photoLien) {
    this.photoLien = photoLien;
  }
  
}

package application;

public abstract class Option {

  private String libelle; 
  private float prix; 
  
  Option(String libelle, float prix) {
    this.libelle = libelle;
    this.prix = prix;
    }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public float getPrix() {
    return prix;
  }

  public void setPrix(float prix) {
    this.prix = prix;
  }
}

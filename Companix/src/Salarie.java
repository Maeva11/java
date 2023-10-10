import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Salarie {
  private String code; 
  private String nom; 
  private String prenom; 
  private LocalDate dateEmbauche; 
  
  Salarie(String code, String nom, String prenom, String dateEmbauche) {
    this.code = code;
    this.nom = nom;
    this.prenom = prenom;
    this.dateEmbauche = LocalDate.parse(dateEmbauche);
    }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public LocalDate getDateEmbauche() {
    return dateEmbauche;
  }

  public void setDateEmbauche(LocalDate dateEmbauche) {
    this.dateEmbauche = dateEmbauche;
  }
  
  public String toString() {
    return "Code : " + this.code + " - nom : " + this.nom + " - prenom : " + this.prenom + " - date d'embauche : " + this.dateEmbauche;
 }
  
  public boolean compareCode (String code) {
    if(code.equals(this.code)) {
      return true;
    } else {
      return false;
    }
  }
}

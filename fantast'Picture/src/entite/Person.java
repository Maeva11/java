package entite;

public class Person {
  private String nom; 
  private String password;
  
  public Person(String nom, String password) {
    super();
    this.nom = nom;
    this.password = password;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
}


public class Analyste extends Salarie {
  private int deplacementClient;

  Analyste(String code, String nom, String prenom, String dateEmbauche, int deplacementClient) {
    super(code, nom, prenom, dateEmbauche);
    // TODO Auto-generated constructor stub
    this.deplacementClient = deplacementClient;
  }

  public int getDeplacementClient() {
    return deplacementClient;
  }

  public void setDeplacementClient(int deplacementClient) {
    this.deplacementClient = deplacementClient;
  }
  
  @Override
  public String toString(){
    return super.toString() + " - Nombre de déplacement : " + this.deplacementClient;
  }
}

public class Concepteur extends Salarie {
  private int anneeDev;

  Concepteur(String code, String nom, String prenom, String dateEmbauche, int anneeDev) {
    super(code, nom, prenom, dateEmbauche);
    // TODO Auto-generated constructor stub
    this.anneeDev = anneeDev;
  }

  public int getAnneeDev() {
    return anneeDev;
  }

  public void setAnneeDev(int anneeDev) {
    this.anneeDev = anneeDev;
  }
  
  @Override
  public String toString(){
    return super.toString() + " - Année de développement : " + this.anneeDev;
  }
}

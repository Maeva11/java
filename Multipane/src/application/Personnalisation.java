package application;

public class Personnalisation extends Option{
  private String description; 
  
    Personnalisation(String libelle, float prix, String description) {
      super(libelle, prix);
      // TODO Auto-generated constructor stub
      this.description = description;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }
}

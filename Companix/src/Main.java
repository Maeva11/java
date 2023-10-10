import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  /**
   * 
   * @param args
   * @throws InterruptedException 
   */
  
  public static void main(String[] args) throws InterruptedException {
    
    ArrayList<Concepteur> listConcepteur = new ArrayList<Concepteur>();
    ArrayList<Analyste> listAnalyste = new ArrayList<Analyste>();
    ArrayList<Salarie> allSalarie = new ArrayList<Salarie>();

    Print.mockDatasConceptor(listConcepteur);
    Print.mockDatasAnalyst(listAnalyste);
    
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int str = -1;
    
    System.out.println("Bienvenue sur votre interface Companix !");
    Thread.sleep(500);

    while (str != 0) {
      
      Thread.sleep(1000);
      Print.printMenu(sc);
      str = sc.nextInt();  
      
      switch(str){
          case 1: 
            Print.printConceptor(listConcepteur, sc);
            break;
            
          case 2:
            System.out.println("\nQuel concepteur voulez-vous supprimer ? (-1 pour annuler)");
            Print.listConceptorWithPosition(listConcepteur);
            int index = sc.nextInt(); 
            if (index == -1) {
              System.out.println("annulation...");
              break;
            } else {
              Print.wrongIndexConceptor(index, listConcepteur);
            }
            break;
   
          case 3:
            Print.listConceptor(listConcepteur);
              break;
              
          case 4:
            Print.printAnalyst(listAnalyste, sc);
              break;
              
          case 5:
            System.out.println("\nQuel analyste voulez-vous supprimer ? (-1 pour annuler)");
            Print.listAnalystWithPosition(listAnalyste);
            int indexAnalyst = sc.nextInt(); 
            if (indexAnalyst == -1) {
              System.out.println("annulation...");
              break;
            } else {
              Print.wrongIndexAnalyst(indexAnalyst, listAnalyste);
            }            
            break;
            
          case 6:
            Print.listAnalyst(listAnalyste);
            break;
            
          case 7:
            Print.listAllByType(listAnalyste, listConcepteur);
            break;
            
          case 8:
            Print.sortList(listAnalyste, listConcepteur);
            break;
      }      
    }
  }
}

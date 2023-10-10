import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Print {

  static void printConceptor(ArrayList<Concepteur> listConcepteur, Scanner sc) {

    System.out.println("Saisir le code concepteur :");
    String code = sc.next(); 

    System.out.println("Saisir le nom du concepteur :");
    String nom = sc.next(); 
    
    System.out.println("Saisir le prénom du concepteur :");
    String prenom = sc.next(); 
    
    System.out.println("Saisir la date d'embauche du concepteur (YYYY-MM-DD) :");
    String dateEmbauche = sc.next(); 
    
    System.out.println("Combien d'année de déveleppement à le concepteur :");
    int anneeDev = sc.nextInt(); 
    
    Concepteur concepteur = new Concepteur(code, nom, prenom, dateEmbauche, anneeDev);
    
    if (concepteur.compareCode(code)) {
      System.out.println("Ce code existe déjà. Choisissez un autre code");
    } else {
      listConcepteur.add(concepteur);
      System.out.println("Le concepteur " + nom + " " + prenom + " a bien été ajouté");
    }
  }
  
  static void printAnalyst(ArrayList<Analyste> listAnalyste, Scanner sc) {
    System.out.println("Saisir le code de l'analyste :");
    String code = sc.next(); 

    System.out.println("Saisir le nom de l'analyste :");
    String nom = sc.next(); 
    
    System.out.println("Saisir le prénom de l'analyste :");
    String prenom = sc.next(); 
    
    System.out.println("Saisir la date d'embauche de l'analyste (YYYY-MM-DD) :");
    String dateEmbauche = sc.next(); 
    
    System.out.println("Combien de déplacement Client à l'analyste :");
    int deplacementClient = sc.nextInt(); 
    
    Analyste analyste = new Analyste(code, nom, prenom, dateEmbauche, deplacementClient);
    
    if (analyste.compareCode(code)) {
      System.out.println("Ce code existe déjà. Choisissez un autre code");
    } else {
      listAnalyste.add(analyste);
      System.out.println("L'analyste " + nom + " " + prenom + " a bien été ajouté");
    }
  }
  
  static void printMenu(Scanner sc) {
    String menu = "\nVeuillez choisir un numéro :\n" +
        "1- Ajouter un concepteur\n" +
        "2- Supprimer un concepteur\n" +
        "3- Lister les concepteurs existants\n" +
        "4- Ajouter un analyste\n" +
        "5- Supprimer un analyste\n" +
        "6- Lister les analystes existants \n" +
        "7- Lister les salariés existants en mettant en évidence la fonction (Concepteur ou Analyste) \n" +
        "8- Trier par ordre alphabétique)";
    System.out.println(menu);
  }
  
  static void listConceptor (ArrayList<Concepteur> listConcepteur) {
    for (Concepteur concepteur : listConcepteur) {
      System.out.println(concepteur.toString());
    }
  }
  
  static void listConceptorWithPosition (ArrayList<Concepteur> listConcepteur) {
    for (int i = 0; i < listConcepteur.size(); i++) {
        System.out.println(i + " | " + listConcepteur.get(i).toString());
    }
  }

  static void wrongIndexConceptor(int index, ArrayList<Concepteur> listConcepteur ) {
    if(index > listConcepteur.size() || index < 0) {
      System.out.println("Vous ne pouvons pas supprimer un élément qui n'existe pas");
    } else {
      System.out.println("Supression... ");
      listConcepteur.remove(index);
    }
  }
  
  static void listAnalystWithPosition (ArrayList<Analyste> listAnalyst) {
    for (int i = 0; i < listAnalyst.size(); i++) {
      System.out.println(i + " | " + listAnalyst.get(i).toString());
    }
  }
  
  static void wrongIndexAnalyst(int index, ArrayList<Analyste> listAnalyst ) {
    if(index > listAnalyst.size() || index < 0) {
      System.out.println("Vous ne pouvons pas supprimer un élément qui n'existe pas");
    } else {
      System.out.println("Supression... ");
      listAnalyst.remove(index);
    }
  }
  static void listAnalyst (ArrayList<Analyste> listAnalyst) {
    for (Analyste analyste : listAnalyst) {
      System.out.println(analyste.toString());
    }
  }
  
   static void mockDatasConceptor (ArrayList<Concepteur> listConcepteur) {
     Concepteur concepteur = new Concepteur("023", "vignon", "maeva", "2023-10-02", 5);
     listConcepteur.add(concepteur);
     
     Concepteur raphael = new Concepteur("010", "CapdeVielle", "Raphaël", "1999-09-12", 4);
     listConcepteur.add(raphael);
   }
   
   static void mockDatasAnalyst (ArrayList<Analyste> listAnalyste) {
     Analyste clement = new Analyste("456", "Fellah", "Clément", "2010-04-02", 10);
     listAnalyste.add(clement);
     
     Analyste lucas = new Analyste("789", "Chal", "Lucas", "2015-12-09", 6);
     listAnalyste.add(lucas);
   }
   
   static void listAllByType (ArrayList<Analyste> listAnalyst, ArrayList<Concepteur> listConcepteur ) {    
     
     System.out.println("Analyste : ");
     for (Analyste analyste : listAnalyst) {
       System.out.println(analyste.toString());
     }
     
     System.out.println("\nConcepteur : ");
     for (Concepteur concepteur : listConcepteur) {
       System.out.println(concepteur.toString());
     }
   }
   
   static void sortList (ArrayList<Analyste> listAnalyst, ArrayList<Concepteur> listConcepteur ) {       
     ArrayList<Salarie> allSalarie = new ArrayList<>();
     allSalarie.addAll(listAnalyst);
     allSalarie.addAll(listConcepteur);

     Collections.sort(allSalarie, Comparator.comparing(Salarie::getNom));

     for (Salarie salarie : allSalarie) {
       System.out.println(salarie);
     }
   }
}

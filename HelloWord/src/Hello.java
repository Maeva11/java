import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hello {
  
  /** 
   * 
   * @param args
   */

  public static void main(String[] args) {
    System.out.println("Hello world");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int i = 0; 
    int j = 0; 
    try {
      System.out.println("Enter i : ");
      i = Integer.parseInt(in.readLine());
    }catch (IOException e) {
      //TODO Auto-generate catch block 
      e.printStackTrace();
    }
    
    try {
      System.out.println("Enter j : ");
      j = Integer.parseInt(in.readLine());
    }catch (IOException e) {
      //TODO Auto-generate catch block 
      e.printStackTrace();
    }
    System.out.println("Addition is : " + (i + j));
  }

}

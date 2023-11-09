package application;

public class EcritureFichierException extends Exception {

  public EcritureFichierException(String message) {
      super(message);
  }

  public EcritureFichierException(String message, Throwable cause) {
      super(message, cause);
  }
}
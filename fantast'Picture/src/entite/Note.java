package entite;

public class Note {
  private int note;
  private Person namePerson; 
  private Image nameCity;
  
  
  public Note(int note, Person namePerson, Image nameCity) {
    super();
    this.note = note;
    this.namePerson = namePerson;
    this.nameCity = nameCity;
  }
  public int getNote() {
    return note;
  }
  public void setNote(int note) {
    this.note = note;
  }
  public Person getNamePerson() {
    return namePerson;
  }
  public void setNamePerson(Person namePerson) {
    this.namePerson = namePerson;
  }
  public Image getNameCity() {
    return nameCity;
  }
  public void setNameCity(Image nameCity) {
    this.nameCity = nameCity;
  } 

  

}

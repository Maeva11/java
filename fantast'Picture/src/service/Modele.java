package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entite.Image;
import entite.Note;
import entite.Person;

public class Modele {
    private ArrayList<Person> peopleList;
    private ArrayList<Image> imageList;
    private ArrayList<Note> noteList;

    public Modele() {
        super();
        peopleList = new ArrayList<Person>();
        this.listPerson();

        imageList = new ArrayList<Image>();
        this.listImage();

        noteList = new ArrayList<Note>();
        this.listNote();
    }

    public void listPerson() {
        Person maeva = new Person("Maeva", "123");
        peopleList.add(maeva);
        Person andrew = new Person("Andrew", "456");
        peopleList.add(andrew);
    }

    public void listImage() {
        Image castres = new Image("Castres", "image/castres.jpg");
        imageList.add(castres);
        Image paris = new Image("Paris", "image/paris.jpg");
        imageList.add(paris);
    }

    public void listNote() {
        Note rightParis = new Note(0, new Person("Maeva", "123"), new Image("Paris", "image/paris.jpg"));
        noteList.add(rightParis);
        Note rightCastres = new Note(0, new Person("Andrew", "456"), new Image("Castres", "image/castres.jpg"));
        noteList.add(rightCastres);
        Note rightCastresMaeva = new Note(0, new Person("Maeva", "123"), new Image("Castres", "image/castres.jpg"));
        noteList.add(rightCastresMaeva);
    }

    public ArrayList<Image> displayImageList() {
        return imageList;
    }

    public ArrayList<Person> displayPeopleList() {
        return peopleList;
    }

    public ArrayList<Note> displayNoteList() {
        return noteList;
    }

    public int getNoteAboutImage(String name) {
        for (Note note : this.noteList) {
            if (name.equals(note.getNamePerson().getNom())) {
                return note.getNote();
            }
        }
        return 0;
    }

    public void saveData(String person, String city, String note) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        boolean personAndCityFound = false;

        try {
            File fichier = new File("Enregistrement.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fichier));

            String line;
            String newText = person + "; " + city + "; " + note;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(person + "; " + city + ";")) {
                    list.add(newText);
                    personAndCityFound = true;
                } else {
                    list.add(line);
                }
            }

            reader.close();

            if (!personAndCityFound) {
                list.add(newText);
            }

            FileOutputStream flux = new FileOutputStream(fichier);

            for (int i = 0; i < list.size(); i++) {
                flux.write(list.get(i).getBytes());
                flux.write("\n".getBytes());
            }

            flux.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fillDataFields(String person, String city) throws IOException {
        try {

            File fichier = new File("Enregistrement.txt");
            BufferedReader reader = new BufferedReader(new FileReader(fichier));

            String line;
            boolean noteFound = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(person + "; " + city + ";")) {
                    String[] parts = line.split("; ");
                    if (parts.length >= 3) {
                        noteFound = true;
                        return parts[2];
                    }
                }
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "null";
    }

    public ArrayList<String> getNameAboutImage(String name) {
        ArrayList<String> listName = new ArrayList<String>();
        for (Note note : this.noteList) {
            if (name.equals(note.getNamePerson().getNom())) {
                listName.add(note.getNameCity().getNom());
            }
        }
        return listName;
    }

    public String getUrlFromCity(String cityName) {
        for (Image image : this.imageList) {
            if (cityName.equals(image.getNom())) {
                return image.getUrl();
            }
        }
        return null;
    }
}
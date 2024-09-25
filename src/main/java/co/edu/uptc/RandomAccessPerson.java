package co.edu.uptc;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessPerson {
    public static void main(String[] args) {
        String filePath = "people.dat";

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            Person p1 = new Person("Alice", 30, "Tunja");
            Person p2 = new Person("Bob", 25, "Cali");
            Person p3 = new Person("Oscar" , 20, "Campo Hermoso");
            p1.writeToFile(raf);
            p2.writeToFile(raf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            raf.seek(0); 
            int PERSON_SIZE = Person.NAME_SIZE + Integer.BYTES + Person.CITY_SIZE;
            do {
                Person auxPerson = new Person();
                auxPerson.readFromFile(raf);
                System.out.println(auxPerson);
                raf.seek(PERSON_SIZE);
            } while (condition);
            // Person p1 = new Person();
            // p1.readFromFile(raf);
            // System.out.println("First person: " + p1);
            // Person auxPerson = new Person();
            //  do {
            //     raf.seek(Person.NAME_SIZE + Integer.BYTES + Person.CITY_SIZE);
            //     auxPerson.readFromFile(raf);
            //     System.out.println("person: " + auxPerson);
            // } while ();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
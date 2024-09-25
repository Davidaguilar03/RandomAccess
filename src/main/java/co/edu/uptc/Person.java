package co.edu.uptc;

import java.io.IOException;
import java.io.RandomAccessFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

class Person {
    private String name;
    private int age;
    private String city;

    public static final int NAME_SIZE = 30;
    public static final int CITY_SIZE = 30;

    public Person() {
        this.name = "";
        this.city ="";
        this.age = 0;
    }

    public void writeToFile(RandomAccessFile raf) throws IOException {
        byte[] nameBytes = new byte[NAME_SIZE];
        byte[] nameArray = name.getBytes();
        byte[] cityBytes = new byte[CITY_SIZE];
        byte[] cityArray = city.getBytes();
        System.arraycopy(nameArray, 0, nameBytes, 0, Math.min(nameArray.length, NAME_SIZE));
        System.arraycopy(cityArray, 0, cityBytes, 0, Math.min(cityArray.length, NAME_SIZE));
        raf.write(nameBytes);
        raf.writeInt(age);
        raf.write(cityBytes);
    }

    public void readFromFile(RandomAccessFile raf) throws IOException {
        byte[] nameBytes = new byte[NAME_SIZE];
        byte[] cityBytes = new byte[CITY_SIZE];
        raf.read(nameBytes);
        this.name = new String(nameBytes).trim();
        this.age = raf.readInt();
        raf.read(cityBytes);
        this.city = new String(cityBytes).trim();
    }
}

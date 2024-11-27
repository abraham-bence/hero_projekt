package hu.petrik.szuperhosprojekt;


public class Main {
    public static String path = "C:\\Users\\bmben\\OneDrive\\Asztali gép\\tanulósdi\\java\\hero_projekt\\src\\main\\java\\hu\\petrik\\szuperhosprojekt\\szuperhos.txt";


    public static void main(String[] args) {
        try {

            Kepregeny.szereplok(path);
            Kepregeny.szuperhosok();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}



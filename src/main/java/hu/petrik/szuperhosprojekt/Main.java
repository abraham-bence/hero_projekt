package hu.petrik.szuperhosprojekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            File file = new File(classLoader.getResource("szuperhos.txt").getFile());
            Kepregeny.szereplok(file.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    interface Szuperhos {
        boolean legyoziE(Szuperhos szuperhos);
        float mekkoraAzEreje();
    }

    interface Milliardos{
        void kutyutKeszit();
    }

    abstract class Bosszuallo implements Szuperhos{
        private float szuperero;
        private boolean vanEGyengesege;

        public Bosszuallo(int szuperero, boolean vanEGyengesege){
            this.szuperero = szuperero;
            this.vanEGyengesege =vanEGyengesege;
        }

        public abstract boolean megmentiAVilagot();

        @Override
        public float mekkoraAzEreje() {
            return this.szuperero;
        }

        @Override
        public boolean legyoziE(Szuperhos szuperhos) {
            if (this.mekkoraAzEreje() > szuperhos.mekkoraAzEreje()){
                return true;
            }
            return false;
        }

        public void setSzuperero(float szuperero) {
            this.szuperero = szuperero;
        }

        public float getSzuperero() {
            return szuperero;
        }

        public void setVanEGyengesege(boolean vanEGyengesege){
            this.vanEGyengesege = vanEGyengesege;
        }

        public boolean getVanEgyengesege() {
            return vanEGyengesege;
        }

        @Override
        public String toString() {
            return String.format("Szupererő: %2.f; %s", szuperero, ((vanEGyengesege) ? "van gyengesége" : "nincs gyengesége")) ;
        }
    }

    class Vasember extends Bosszuallo implements Milliardos{

        public Vasember() {
            super(150, true);
        }

        @Override
        public void kutyutKeszit() {
            Random rnd = new Random();
            this.setSzuperero(this.getSzuperero() + rnd.nextFloat(10));
        }

        @Override
        public boolean megmentiAVilagot() {
            return getSzuperero() > 1000;
        }

        @Override
        public String toString() {
            return String.format("Vasember {0}",Bosszuallo.class.toString());
        }
    }

    class Batman implements Szuperhos, Milliardos{

        private float lelemenyesseg;

        public Batman(){
            this.lelemenyesseg = 100;

        }
        @Override
        public void kutyutKeszit() {
            this.lelemenyesseg += 50;
        }

        @Override
        public boolean legyoziE(Szuperhos szuperhos) {
            return lelemenyesseg > szuperhos.mekkoraAzEreje();
        }

        @Override
        public float mekkoraAzEreje() {
            return lelemenyesseg * 2;
        }

        @Override
        public String toString() {
            return String.format("Batman: Leleményesség: %2.f", lelemenyesseg);
        }
    }

    public class Kepregeny{

        public static List<Szuperhos> szuperhosLista = new ArrayList<Szuperhos>();
        public static void szereplok(String fileName){
            try {
                FileReader r = new FileReader(fileName);
                char[] charArray = new char[100];

                r.read(charArray);

                System.out.println(charArray);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}



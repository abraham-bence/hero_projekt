package hu.petrik.szuperhosprojekt;

import java.util.Random;

public class Vasember extends Bosszuallo implements Milliardos{

    public Vasember() {
        super(150, true);
    }

    @Override
    public void kutyutKeszit() {
        Random rnd = new Random();
        this.setSzuperero(this.getSzuperero() + rnd.nextDouble(10));
    }

    @Override
    public boolean megmentiAVilagot() {
        return getSzuperero() > 1000;
    }

    @Override
    public String toString() {
        return String.format("Vasember\nErő: %d", Math.round(this.mekkoraAzEreje()));
    }
}

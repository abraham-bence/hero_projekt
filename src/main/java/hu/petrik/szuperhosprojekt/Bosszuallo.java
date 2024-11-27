package hu.petrik.szuperhosprojekt;

abstract class Bosszuallo implements Szuperhos{
    private double szuperero;
    private boolean vanEGyengesege;

    public Bosszuallo(double szuperero, boolean vanEGyengesege){
        this.szuperero = szuperero;
        this.vanEGyengesege =vanEGyengesege;
    }

    public abstract boolean megmentiAVilagot();

    @Override
    public double mekkoraAzEreje() {
        return this.szuperero;
    }

    @Override
    public boolean legyoziE(Szuperhos szuperhos) {
        return this.mekkoraAzEreje() > szuperhos.mekkoraAzEreje();
    }

    public void setSzuperero(double szuperero) {
        this.szuperero = szuperero;
    }

    public double getSzuperero() {
        return szuperero;
    }

    public void setVanEGyengesege(boolean vanEGyengesege){
        this.vanEGyengesege = vanEGyengesege;
    }

    public boolean isVanEGyengesege() {
        return vanEGyengesege;
    }

    @Override
    public String toString() {
        return String.format("Szupererő: %f; %s", szuperero, ((vanEGyengesege) ? "van gyengesége" : "nincs gyengesége")) ;
    }
}
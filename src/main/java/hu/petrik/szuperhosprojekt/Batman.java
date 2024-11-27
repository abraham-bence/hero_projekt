package hu.petrik.szuperhosprojekt;

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
    public double mekkoraAzEreje() {
        return lelemenyesseg * 2;
    }

    @Override
    public String toString() {
        return String.format("Batman: %d", Math.round(lelemenyesseg));
    }
}
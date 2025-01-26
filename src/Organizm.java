import java.awt.*;

public abstract class Organizm {
    protected int sila;
    protected int inicjatywa;
    protected int wiek;
    protected int x, y;
    protected boolean czyZyje = true;
    protected Swiat swiat;

    public Organizm(int x, int y, Swiat swiat, int sila, int inicjatywa) {
        this.x = x;
        this.y = y;
        this.swiat = swiat;
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.wiek = 0;
    }

    public abstract void akcja();

    public abstract void rysowanie(Graphics g, int x, int y, int size);

    public abstract Organizm rozmnazanie(int x, int y);

    public void increaseWiek() {
        wiek++;
    }

    public int getWiek() {
        return wiek;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public int getSila() {
        return sila;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void smierc() {
        czyZyje = false;
    }

    public boolean getCzyZyje() {
        return czyZyje;
    }
}
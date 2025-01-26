import java.awt.*;
import java.util.Random;

public abstract class Zwierze extends Organizm {
    public Zwierze(int x, int y, Swiat swiat, int sila, int inicjatywa) {
        super(x, y, swiat, sila, inicjatywa);
    }

    public void akcja() {
        Random rand = new Random();
        int newX = x + rand.nextInt(3) - 1;
        int newY = y + rand.nextInt(3) - 1;

        if (newX == x && newY == y) {
            return;
        }

        if (newX >= 0 && newX < swiat.getN() && newY >= 0 && newY < swiat.getN()) {
            Organizm other = swiat.getPole(newX, newY);
            if (other != null && other.getClass() == this.getClass()) {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int freeX = x + dx;
                        int freeY = y + dy;
                        if (freeX >= 0 && freeX < swiat.getN() && freeY >= 0 && freeY < swiat.getN() && swiat.getPole(freeX, freeY) == null) {
                            Organizm nowy = rozmnazanie(freeX, freeY);
                            swiat.dodajOrganizm(nowy);
                            return;
                        }
                    }
                }
            }
            else if (other != null && other.getSila() > sila) {
                if (other.getClass() == Lew.class && sila < 5) {
                    return;
                }
                swiat.usunOrganizm(x, y);
                smierc();
            }
            else if (other != null && other.getSila() <= sila) {
                if (other.getClass() == Guarana.class) {
                    sila += 3;
                }
                swiat.usunOrganizm(newX, newY);
                this.setX(newX);
                this.setY(newY);
            }
            else {
                this.setX(newX);
                this.setY(newY);
            }
        }
    }

    @Override
    public abstract Organizm rozmnazanie(int x, int y);
}
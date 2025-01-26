import java.awt.*;
import java.util.Random;

public class Antylopa extends Zwierze {
    public Antylopa(int x, int y, Swiat swiat) {
        super(x, y, swiat, 4, 4);
    }

    @Override
    public void rysowanie(Graphics g, int x, int y, int size) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public Organizm rozmnazanie(int x, int y) {
        return new Antylopa(x, y, swiat);
    }

    @Override
    public void akcja() {
        Random rand = new Random();
        int newX = this.getX() + rand.nextInt(5) - 2;
        int newY = this.getY() + rand.nextInt(5) - 2;

        if (newX == this.getX() && newY == this.getY()) {
            return;
        }

        if (newX >= 0 && newX < swiat.getN() && newY >= 0 && newY < swiat.getN()) {
            Organizm other = swiat.getPole(newX, newY);
            if (other != null && other.getClass() == this.getClass()) {

                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int freeX = this.getX() + dx;
                        int freeY = this.getY() + dy;
                        if (freeX >= 0 && freeX < swiat.getN() && freeY >= 0 && freeY < swiat.getN() && swiat.getPole(freeX, freeY) == null) {
                            System.out.println("Antylopa rozmnaza sie na polu: " + freeX + " " + freeY + "z pola " + this.getX() + " " + this.getY());
                            Organizm nowy = rozmnazanie(freeX, freeY);
                            swiat.dodajOrganizm(nowy);
                            return;
                        }
                    }
                }
            }
            else if (other != null) {
                Random runRand = new Random();
                if (runRand.nextInt(2) == 0) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int runX = this.getX() + i;
                            int runY = this.getY() + j;

                            if (runX >= 0 && runX < this.swiat.getN() && runY >= 0 && runY < this.swiat.getN() && this.swiat.getPole(runX, runY) == null) {
                                this.setX(runX);
                                this.setY(runY);
                                return;
                            }
                        }
                    }
                }
                if (other.getSila() > sila) {
                    if (other.getClass() == Lew.class && sila < 5) {
                        return;
                    }
                    swiat.usunOrganizm(this.getX(), this.getY());
                }
                else if (other.getSila() <= sila) {
                    if (other.getClass() == Guarana.class) {
                        sila += 3;
                    }
                    swiat.usunOrganizm(newX, newY);
                    this.setX(newX);
                    this.setY(newY);
                }
            }
            else {
                this.setX(newX);
                this.setY(newY);
            }
        }
    }
}
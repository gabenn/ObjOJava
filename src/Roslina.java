import java.util.Random;

public abstract class Roslina extends Organizm {
    public Roslina(int x, int y, Swiat swiat, int sila) {
        super(x, y, swiat, sila, 0);
    }

    public void akcja() {
        Random rand = new Random();
        if (rand.nextInt(10) == 2) {
            int dx = rand.nextInt(3) - 1;
            int dy = rand.nextInt(3) - 1;
            if (dx == 0 && dy == 0) {
                return;
            }

            int newX = this.getX() + dx;
            int newY = this.getY() + dy;

            if (newX >= 0 && newX < swiat.getN() && newY >= 0 && newY < swiat.getN()) {
                if (swiat.getPole(newX, newY) == null) {
                    Organizm nowy = this.rozmnazanie(newX, newY);
                    swiat.dodajOrganizm(nowy);
                }
            }
        }
    }

    @Override
    public abstract Organizm rozmnazanie(int x, int y);
}
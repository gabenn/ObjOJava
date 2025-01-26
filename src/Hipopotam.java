import java.awt.*;

public class Hipopotam extends Zwierze {
    public Hipopotam(int x, int y, Swiat swiat) {
        super(x, y, swiat, 11, 2);
    }

    @Override
    public void rysowanie(Graphics g, int x, int y, int size) {
        g.setColor(Color.PINK);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public Organizm rozmnazanie(int x, int y) {
        return new Hipopotam(x, y, swiat);
    }

    @Override
    public void akcja() {
        if(getWiek() % 2 == 0) {
            super.akcja();
        }
    }
}
import java.awt.*;

public class Mlecz extends Roslina {
    public Mlecz(int x, int y, Swiat swiat) {
        super(x, y, swiat, 0);
    }

    @Override
    public void rysowanie(Graphics g, int x, int y, int size) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public void akcja() {
        for (int i = 0; i < 3; i++) {
            super.akcja();
        }
    }

    @Override
    public Organizm rozmnazanie(int x, int y) {
        return new Mlecz(x, y, swiat);
    }
}
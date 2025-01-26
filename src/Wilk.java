import java.awt.*;
import java.util.Random;

public class Wilk extends Zwierze {
    public Wilk(int x, int y, Swiat swiat) {
        super(x, y, swiat, 9, 5);
    }

    @Override
    public void rysowanie(Graphics g, int x, int y, int size) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public Organizm rozmnazanie(int x, int y) {
        return new Wilk(x, y, swiat);
    }
}
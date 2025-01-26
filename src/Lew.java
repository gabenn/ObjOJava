import java.awt.*;
import java.util.Random;

public class Lew extends Zwierze {
    public Lew(int x, int y, Swiat swiat) {
        super(x, y, swiat, 11, 7);
    }

    @Override
    public void rysowanie(Graphics g, int x, int y, int size) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, size, size);
        g.setColor(Color.BLACK);
    }

    @Override
    public Organizm rozmnazanie(int x, int y) {
        return new Lew(x, y, swiat);
    }
}
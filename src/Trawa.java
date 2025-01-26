import java.awt.*;

public class Trawa extends Roslina {
    public Trawa(int x, int y, Swiat swiat) {
        super(x, y, swiat, 0);
    }

    @Override
    public void rysowanie(Graphics g, int x, int y, int size) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public Organizm rozmnazanie(int x, int y) {
        return new Trawa(x, y, swiat);
    }
}
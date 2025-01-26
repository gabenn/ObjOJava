import java.awt.*;

public class Guarana extends Roslina {
    public Guarana(int x, int y, Swiat swiat) {
        super(x, y, swiat, 0);
    }

    @Override
    public void rysowanie(Graphics g, int x, int y, int size) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public Organizm rozmnazanie(int x, int y) {
        return new Guarana(x, y, swiat);
    }
}
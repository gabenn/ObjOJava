import java.awt.*;
import java.util.Random;

public class Owca extends Zwierze {
    public Owca(int x, int y, Swiat swiat) {
        super(x, y, swiat, 4, 4);
    }

    @Override
    public void rysowanie(Graphics g, int x, int y, int size) {
        g.setColor(Color.RED);
        g.fillRect(x, y, size, size);
        //fill border with black
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public Organizm rozmnazanie(int x, int y) {
        return new Owca(x, y, swiat);
    }
}
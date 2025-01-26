import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Swiat extends JPanel {
    private static final int N = 30;
    private Organizm[][] plansza;
    private ArrayList<Organizm> organizmy;
    private int tura = 1;

    public Swiat() {
        plansza = new Organizm[N][N];
        organizmy = new ArrayList<>();
        JFrame frame = new JFrame("Swiat Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(this);
        frame.setVisible(true);
    }

    public void wykonajTure() {
        Collections.sort(organizmy, new Comparator<Organizm>() {
            @Override
            public int compare(Organizm a, Organizm b) {
                if (a.getInicjatywa() == b.getInicjatywa()) {
                    return Integer.compare(b.getWiek(), a.getWiek());
                }
                return Integer.compare(b.getInicjatywa(), a.getInicjatywa());
            }
        });


        ArrayList<Organizm> organizmyCopy = new ArrayList<>(organizmy);

        for (Organizm organizm : organizmyCopy) {
            if (organizm.getCzyZyje()) {
                organizm.akcja();
            }
        }

        usunMartweOrganizmy();
        repaint();

        System.out.println();
        System.out.println("Łukasz Cysewski s200791");
        System.out.println();
        System.out.println("Ilosc Organizmow: " + organizmy.size());
        System.out.println("Tura: " + tura++);
        System.out.println();
    }

    public int getN() {
        return N;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                plansza[i][j] = null;
            }
        }

        for (Organizm organizm : organizmy) {
            plansza[organizm.getX()][organizm.getY()] = organizm;
        }

        int cellSize = getWidth() / N - 5;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (plansza[i][j] != null) {
                    plansza[i][j].rysowanie(g, i * cellSize, j * cellSize, cellSize);
                } else {
                    g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    public void dodajOrganizm(Organizm organizm) {
        int x = organizm.getX();
        int y = organizm.getY();

        if (plansza[x][y] != null) {
            return;
        }

        plansza[x][y] = organizm;
        organizmy.add(organizm);
    }

    public void usunOrganizm(int x, int y) {
        if (plansza[x][y] != null) {
            for (Organizm organizm : organizmy) {
                if (organizm.getX() == x && organizm.getY() == y) {
                    organizm.smierc();
                    break;
                }
            }
            plansza[x][y] = null;
        }
    }

    public void usunMartweOrganizmy() {
        int zginelo = 0;
        for (int i = 0; i < organizmy.size(); ) {
            Organizm organizm = organizmy.get(i);
            if (!organizm.getCzyZyje()) {
                zginelo++;
                organizmy.remove(i);
            } else {
                i++;
            }
        }
        System.out.println("Zginęło: " + zginelo);
        System.out.println();
    }

    public Organizm getPole(int x, int y) {
        for (Organizm organizm : organizmy) {
            if (organizm.getX() == x && organizm.getY() == y) {
                return organizm;
            }
        }
        return plansza[x][y];
    }

    public ArrayList<Organizm> getOrganizmy() {
        return organizmy;
    }
}
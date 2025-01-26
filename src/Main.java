import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swiat Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);

        Swiat swiat = new Swiat();

        for (int i = 0; i < 6; i++) {
            swiat.dodajOrganizm(new Owca((int) (Math.random() * 20), (int) (Math.random() * 20), swiat));
            swiat.dodajOrganizm(new Wilk((int) (Math.random() * 20), (int) (Math.random() * 20), swiat));
            swiat.dodajOrganizm(new Antylopa((int) (Math.random() * 20), (int) (Math.random() * 20), swiat));
            swiat.dodajOrganizm(new Lew((int) (Math.random() * 20), (int) (Math.random() * 20), swiat));
            swiat.dodajOrganizm(new Hipopotam((int) (Math.random() * 20), (int) (Math.random() * 20), swiat));
            swiat.dodajOrganizm(new Trawa((int) (Math.random() * 20), (int) (Math.random() * 20), swiat));
            swiat.dodajOrganizm(new Mlecz((int) (Math.random() * 20), (int) (Math.random() * 20), swiat));
            swiat.dodajOrganizm(new Guarana((int) (Math.random() * 20), (int) (Math.random() * 20), swiat));
        }

        JButton button = new JButton("Next Turn");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swiat.wykonajTure();
            }
        });

        JPanel panel = new JPanel();
        panel.add(button);

        frame.add(swiat);
        frame.add(panel, BorderLayout.SOUTH);

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swiat.wykonajTure();
            }
        });
        timer.start();

        frame.setVisible(true);
    }
}
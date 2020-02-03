package spc.ripper.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
public abstract class ColorFrame extends JFrame {

    @Autowired
    private Color color;

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        //getContentPane().setBackground(color);
        getContentPane().setBackground(getColor());
        repaint();
    }

    public abstract Color getColor();
}

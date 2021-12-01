package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        super("Cafe");
        constructFrame();
    }

    public void constructFrame() {

        Menu m = new Menu();
        CheckRecipe recipe = m.getRecipe();
        Panel panel = new Panel(recipe);

        /*Main Frame*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());
        getContentPane().add(panel.buttonPanel, BorderLayout.EAST);
        getContentPane().add(panel.leftPanel, BorderLayout.WEST);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}

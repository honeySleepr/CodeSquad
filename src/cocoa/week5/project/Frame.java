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
        CheckRecipe recipe = m.getMenu();
        Panel panel = new Panel(recipe);

        /*Main Frame*/
        ImageIcon icon = new ImageIcon("src/cocoa/week5/project/image/codeSquad.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());
        getContentPane().add(panel.buttonPanel, BorderLayout.EAST);
        getContentPane().add(panel.leftPanel, BorderLayout.WEST);
        setResizable(false);
        pack();  // 이거 안해주면 Panels 크기가 딱딱 들어맞지 않는 이상 서로 침범하고 난리남
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}

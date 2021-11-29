package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    String option;
    public Frame() {
        super("Cafe");
        LeftPanel leftPanel = new LeftPanel();
        ButtonPanel buttonPanel = new ButtonPanel();
//        FrameComponents components = new FrameComponents(this);
        /*Main Frame*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new BorderLayout());
        getContentPane().add(buttonPanel,BorderLayout.EAST);
        getContentPane().add(leftPanel,BorderLayout.WEST);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
//        leftPanel.add(ingredientPanel, BorderLayout.NORTH);
    }


    public void setIngredient(String ingredient) {
option = ingredient;
    }

    public static void main(String[] args) {
        new Frame();
    }

}

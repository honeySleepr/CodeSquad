package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    String option;
    public Frame() {
        super("Cafe");
        ButtonPanel buttonPanel = new ButtonPanel();
//        FrameComponents components = new FrameComponents(this);
        /*Main Frame*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new BorderLayout(10,10));
        getContentPane().add(buttonPanel,BorderLayout.EAST);
        setResizable(false);
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

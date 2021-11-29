package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    Frame() {
        super("Cafe");
        ImageIcon mainIcon = new ImageIcon("image/Coffee.png");

        /*Button Panel*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.gray);
        buttonPanel.setLayout(new GridLayout(5, 2));
        buttonPanel.setPreferredSize(new Dimension(300, 800));

        /*Buttons*/
        Buttons buttons = new Buttons();
        buttons.makeButton(buttonPanel, "우유");
        buttons.makeButton(buttonPanel, "에스프레소샷");
        buttons.makeButton(buttonPanel, "물");
        buttons.makeButton(buttonPanel, "모카시럽");
        buttons.makeButton(buttonPanel, "바닐라시럽");
        buttons.makeButton(buttonPanel, "바닐라시럽");
        buttons.makeButton(buttonPanel, "바닐라시럽");
        buttons.makeButton(buttonPanel, "바닐라시럽");
        buttons.makeButton(buttonPanel, "바닐라시럽");

        setIconImage(mainIcon.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
        add(buttonPanel, BorderLayout.EAST);
    }


}

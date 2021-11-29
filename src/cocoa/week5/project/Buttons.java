package cocoa.week5.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons implements ActionListener{

    JButton makeButton(JPanel panel, String title) {
        JButton button = new JButton(title);
        button.setActionCommand(title);
        button.addActionListener(this);
        button.setFocusable(false);
        panel.add(button);
        return button;
    }

    public void icons(){
        ImageIcon mainIcon = new ImageIcon("image/Coffee.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("우유")) {
            System.out.println(e.getActionCommand());
            System.out.println("YAY");
        }
    }
    }

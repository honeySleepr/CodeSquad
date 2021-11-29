package cocoa.week5.SwingPractice;

import javax.swing.*;
import java.awt.*;

public class Panels {
    public static void main(String[] args) {

        ImageIcon icon = new ImageIcon("image/cabbage22.png");

        JLabel label = new JLabel();
        label.setText("Hi");
//        label.setFont(new Font("MV Boli", Font.BOLD, 50));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setIcon(icon);
//        label.setVerticalAlignment(JLabel.BOTTOM);
//        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBounds(0,0,50,50);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(null);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);
        bluePanel.setLayout(null);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0, 250, 500, 250);
        greenPanel.setLayout(null);

        JFrame frame = new JFrame();
        frame.setTitle("Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);
//        frame.setResizable(false);  // 창 크기 고정
        frame.setVisible(true);
        greenPanel.add(label);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);


//        frame.add(label);
    }
}

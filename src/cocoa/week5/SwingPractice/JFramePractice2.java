package cocoa.week5.SwingPractice;

import javax.swing.*;
import java.awt.*;

public class JFramePractice2 extends JFrame {

    JFramePractice2(){
        setTitle("Jframe title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setResizable(false);
        setVisible(true);

        ImageIcon image = new ImageIcon("image/2.png");
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(0x81fce0));
    }
}

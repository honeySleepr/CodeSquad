package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LeftPanel {
    private Frame frame;

//    public FrameComponents(Frame frame){
//        this.frame = frame;
//    }

    public void Components(){
        Frame frame = new Frame();
        ImageIcon mainIcon = new ImageIcon("image/Coffee.png");
        frame.setIconImage(mainIcon.getImage());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
//        leftPanel.setBackground(Color.GRAY);
        leftPanel.setPreferredSize(new Dimension(480, 800));

        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setBackground(new Color(200,200,180));
        ingredientPanel.setPreferredSize(new Dimension(800, 200));

        /*Labels*/
        JLabel label = new JLabel();
//        label.setText(option);
        label.setHorizontalTextPosition(JLabel.CENTER);  // 라벨 텍스트 가로 위치
        label.setVerticalTextPosition(JLabel.TOP);       // 라벨 텍스트 세로 위치
        label.setForeground(new Color(0xff0000));   // 라벨 텍스트 색상
        label.setFont(new Font("MV Boli", Font.BOLD, 50));
//        label.setVisible(true);
        label.setOpaque(true);
        ingredientPanel.add(label);

//        frame.add(leftPanel, BorderLayout.WEST);
//        frame.add(buttonPanel, BorderLayout.EAST);
//        leftPanel.add(ingredientPanel, BorderLayout.NORTH);

    }
    public void icons() {
        ImageIcon mainIcon = new ImageIcon("image/Coffee.png");
    }

}

package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Flow;

public class LeftPanel extends JPanel {
    JPanel ingredientPanel;

    public LeftPanel() {

        setLayout(new BorderLayout());
        setBackground(new Color(189, 209, 239));
        setPreferredSize(new Dimension(500, 800));

        ingredientPanel = new JPanel();
        ingredientPanel.setBackground(new Color(200, 180, 180));
        ingredientPanel.setPreferredSize(new Dimension(200, 200));
        ingredientPanel.setLayout(new FlowLayout());

        add(ingredientPanel, BorderLayout.NORTH);

        /*라벨로 안되면 그냥 TextArea 로 하자*/
        makeLabel("우유");
        makeLabel("에스프레소샷");
        makeLabel("물");
        makeLabel("모카시럽");
        makeLabel("바닐라시럽");
        makeLabel("카라멜시럽");
        makeLabel("연유");
        makeLabel("자바칩");
        makeLabel("간얼음");
        makeLabel("제조 중..");
//        ingredientPanel.add(label);
    }

    public void icons() {
        ImageIcon mainIcon = new ImageIcon("image/Coffee.png");
    }

    public void makeLabel(String option) {
        JLabel label = new JLabel();
        label.setText(option + "   ");
        label.setForeground(new Color(0x070707));   // 라벨 텍스트 색상
        label.setFont(new Font("a뉴굴림2", Font.PLAIN, 30));
        // 제조중 표시를 아래에 새 패널을 만들어 옮기자
        if (label.getText().contains("제조")) {
            label.setForeground(new Color(0xFF2424));
            label.setFont(new Font("a뉴굴림2", Font.BOLD, 30));
        }
        label.setVisible(false);
        ingredientPanel.add(label);
        ingredientPanel.validate();
    }

    public void showLabel(String option) {
        for (Component jc : ingredientPanel.getComponents()) {
            if (jc instanceof JLabel) {
                JLabel label = (JLabel) jc;
                if (label.getText().contains(option)) {
                    label.setVisible(true);
                    ingredientPanel.add(label);
                    ingredientPanel.setVisible(true);
ingredientPanel.updateUI();
                    System.out.println("equals");
                    System.out.println(label);
                }
            }
        }
    }

    public void removeLabel() {
//ingredientPanel.get
    }
}

package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel implements ActionListener, MouseListener {
    String option;
    JPanel buttonPanel;
    JPanel leftPanel;
    JPanel ingredientPanel;

    public Panel() {
        buttonPanel = new JPanel();
        leftPanel = new JPanel();

        buttonPanel.setBackground(new Color(0xF6F5E9));
        buttonPanel.setLayout(new GridLayout(5, 2));
        buttonPanel.setPreferredSize(new Dimension(300, 800));

        /*Buttons*/
        // 버튼 생성, add, addActionListener, setActionCommand 전부 합친 메소드
        makeButton("우유");
        makeButton("에스프레소샷");
        makeButton("물");
        makeButton("모카시럽");
        makeButton("바닐라시럽");
        makeButton("카라멜시럽");
        makeButton("연유");
        makeButton("자바칩");
        makeButton("간얼음");
        makeButton("제조");

        /*LEFT*/
        leftPanel.setLayout(new GridLayout(5, 5));
        leftPanel.setBackground(new Color(189, 209, 239));
        leftPanel.setPreferredSize(new Dimension(500, 800));

        ingredientPanel = new JPanel();
        ingredientPanel.setBackground(new Color(200, 180, 180));
        ingredientPanel.setPreferredSize(new Dimension(200, 200));
        ingredientPanel.setLayout(new FlowLayout());

        leftPanel.add(ingredientPanel, BorderLayout.NORTH);

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
    }

    void makeButton(String title) {
        JButton button = new JButton(title);
        button.setActionCommand(title);
        button.addActionListener(this);
        button.addMouseListener(this);
        button.setFocusable(false);
        button.setFont(new Font("a뉴굴림2", Font.PLAIN, 15));
        if (button.getText().equals("제조")) {
            button.setBackground(new Color(0xEFD3AB));
            button.setFont(new Font("a뉴굴림2", Font.BOLD, 20));
        }
        buttonPanel.add(button);
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
        label.setVisible(true);
        ingredientPanel.add(label);
        ingredientPanel.validate();
    }

    public void showLabel(String option) {
        for (Component jc : ingredientPanel.getComponents()) {
            if (jc instanceof JLabel) {
                JLabel label = (JLabel) jc;
                if (label.getText().contains(option)) {

                    ingredientPanel.add(label);
                    ingredientPanel.setVisible(true);
                    ingredientPanel.updateUI();
                    System.out.println("equals");
                    System.out.println(label);
                    label.setVisible(false);
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        option = e.getActionCommand();
        System.out.println(option);
        showLabel(option);

//        JOptionPane.showMessageDialog(getComponent(0), "Hello World");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
// 버튼 위에선 손 모양 마우스 포인터로 변경
        e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
    }

    public String getOption() {
        return option;
    }
}

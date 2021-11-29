package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonPanel extends JPanel implements ActionListener, MouseListener {
    private String option;


    public ButtonPanel() {
        setBackground(Color.gray);
        setLayout(new GridLayout(5, 2));
        setPreferredSize(new Dimension(300, 800));

        /*Buttons*/
        // 버튼 생성, add, addActionListener, setActionCommand 전부 합친 메소드
        makeButton("우유");
        makeButton("에스프레소샷");
        makeButton("물");
        makeButton("모카시럽");
        makeButton("바닐라시럽");
        makeButton("바닐라시럽");
        makeButton("바닐라시럽");
        makeButton("바닐라시럽");
        makeButton("바닐라시럽");

    }

    void makeButton(String title) {
        JButton button = new JButton(title);
        button.setActionCommand(title);
        button.addActionListener(this);
        button.addMouseListener(this);
        button.setFocusable(false);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("우유")) {
            System.out.println(e.getActionCommand());
            option = e.getActionCommand();
//            frame.setIngredient("우유");
        }
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
}

package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Panel implements ActionListener, MouseListener {
    String option;
    JPanel buttonPanel;
    JPanel leftPanel;
    JPanel ingredientPanel;
    //    ArrayList<String> allIngredients = new ArrayList<>(List.of("~"));
    ArrayList<JLabel> selectedIngredients = new ArrayList<>();

    public Panel() {
        buttonPanel = new JPanel();
        leftPanel = new JPanel();
        ingredientPanel = new JPanel();

        /*Buttons Panel*/
        buttonPanel.setBackground(new Color(0xF6F5E9));
        buttonPanel.setLayout(new GridLayout(6, 2));
        buttonPanel.setPreferredSize(new Dimension(400, 600));
        /*Left Panel*/
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(new Color(189, 209, 239));
        leftPanel.setPreferredSize(new Dimension(500, 600));
        /*Ingredient Panel*/
        ingredientPanel.setBackground(new Color(200, 180, 180));
        ingredientPanel.setPreferredSize(new Dimension(200, 180));
        ingredientPanel.setLayout(new FlowLayout());

        leftPanel.add(ingredientPanel, BorderLayout.NORTH);
        /*Buttons & Labels : Arraylist+for 문 사용해서 줄일 것 */
        makeButton("물");
        makeButton("에스프레소샷");
        makeButton("우유");
        makeButton("그린티파우더");
        makeButton("모카시럽");
        makeButton("바닐라시럽");
        makeButton("카라멜시럽");
        makeButton("헤이즐넛시럽");
        makeButton("연유");
        makeButton("자바칩");
        makeButton("간얼음");
        makeButton("제조");

        makeLabel("물");
        makeLabel("에스프레소샷");
        makeLabel("우유");
        makeLabel("그린티파우더");
        makeLabel("모카시럽");
        makeLabel("바닐라시럽");
        makeLabel("카라멜시럽");
        makeLabel("헤이즐넛시럽");
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
        button.setFont(new Font("a뉴굴림2", Font.BOLD, 20));
        if (button.getText().equals("제조")) {
            button.setBackground(new Color(0xEFD3AB));
            button.setFont(new Font("a뉴굴림2", Font.BOLD, 30));
        }
        buttonPanel.add(button);
    }

    public void makeLabel(String option) {
        JLabel label = new JLabel();
        if (option.contains("제조")) {
            label.setText(option);
            label.setForeground(new Color(0xFF2424));
            label.setFont(new Font("a뉴굴림2", Font.BOLD, 30));
        } else {
            label.setText(option + "   ");
            label.setForeground(new Color(0x070707));   // 라벨 텍스트 색상
            label.setFont(new Font("a뉴굴림2", Font.PLAIN, 30));
        }
        label.setVisible(false);
        ingredientPanel.add(label);
    }

    public void showLabel(String option) {
        for (Component jc : ingredientPanel.getComponents()) {
            JLabel label = (JLabel) jc;
            if (label.getText().contains(option)) {
                label.setVisible(!label.isVisible());
                if (label.isVisible() && !label.getText().contains("제조")) {
                    selectedIngredients.add(label);
                } else if (!label.isVisible()) {
                    selectedIngredients.remove(label);
                }
            }
        }
        /**/
        System.out.print("selectedIngredients :  ");
        for (JLabel j : selectedIngredients) {
            System.out.print(j.getText() + "  ");
        }
        System.out.println();
        /**/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        option = e.getActionCommand();
        showLabel(option);
        if (option.contains("제조")) {
            Recipe recipe = new Recipe();
            recipe.checkRecipe(selectedIngredients);
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

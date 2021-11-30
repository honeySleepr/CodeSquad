package cocoa.week5.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Panel implements ActionListener, MouseListener {
    JPanel buttonPanel;
    JPanel leftPanel;
    JPanel ingredientPanel;
    JPanel displayPanel;
    JLabel make;
    //    ArrayList<String> allIngredients = new ArrayList<>(List.of("~"));
    ArrayList<JLabel> selectedIngredients = new ArrayList<>();
    final String[] list = new String[]{"에스프레소샷", "우유",
            "그린티파우더", "모카시럽", "바닐라시럽", "카라멜시럽",
            "헤이즐넛시럽", "연유", "자바칩", "간얼음", "제조"};

    public Panel() {
        /*필드에서 선언했을 때와의 차이는? */
        buttonPanel = new JPanel();
        leftPanel = new JPanel();
        ingredientPanel = new JPanel();
        displayPanel = new JPanel();

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
        /*Display Panel*/
        displayPanel.setBackground(new Color(181, 201, 150));
        displayPanel.setPreferredSize(new Dimension(200, 420));
        displayPanel.setLayout(new BorderLayout());

        leftPanel.add(ingredientPanel, BorderLayout.NORTH);
        leftPanel.add(displayPanel, BorderLayout.SOUTH);

        makeButtonList();
        makeLabelList();
        displayPanel.add(make, BorderLayout.CENTER);
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
            make = new JLabel();
            make.setText("제조 중..");
            make.setForeground(new Color(0xFF2424));
            make.setFont(new Font("a뉴굴림2", Font.BOLD, 30));
            make.setHorizontalAlignment(JLabel.CENTER);// 라벨 세로 위치 설정
            make.setVisible(false);
        } else {
            label.setText(option + "   ");
            label.setForeground(new Color(0x070707));   // 라벨 텍스트 색상
            label.setFont(new Font("a뉴굴림2", Font.PLAIN, 30));
        }
        label.setVisible(false);
        ingredientPanel.add(label);
    }

    void makeButtonList() {
        for (String i : list) {
            makeButton(i);
        }
    }

    void makeLabelList() {
        for (String i : list) {
            makeLabel(i);
        }
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
        /*------- 테스트용 selectedIngredients 출력 ---*/
        System.out.print("selectedIngredients :  ");
        for (JLabel j : selectedIngredients) {
            System.out.print(j.getText() + "  ");
        }
        System.out.println();
        /*-------------------------------------------*/
    }

    public void resetLabel() {
        for (Component jc : ingredientPanel.getComponents()) {
            jc.setVisible(false);
        }
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        make.setVisible(false);
        selectedIngredients.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        showLabel(e.getActionCommand());

        if (e.getActionCommand().contains("제조")) {
            make.setVisible(true);
            Recipe recipe = new Recipe();
            recipe.checkRecipe(selectedIngredients);
            resetLabel();
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

package cocoa.week5.project;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class Panel implements ActionListener, MouseListener {
    JPanel buttonPanel;
    JPanel leftPanel, ingredientPanel, displayPanel;
    JLabel make;
    JLabel imgLabel;
    String drink;
    ArrayList<JLabel> selectedIngredients = new ArrayList<>();
    final String[] list = new String[]{"에스프레소샷", "우유",
            "그린티파우더", "모카시럽", "바닐라시럽", "카라멜시럽",
            "헤이즐넛시럽", "연유", "자바칩", "간얼음", "제조", "목록"};
    CheckRecipe recipe;

    public Panel(CheckRecipe recipe) {
        buttonPanel = new JPanel();
        leftPanel = new JPanel();
        ingredientPanel = new JPanel();
        displayPanel = new JPanel();
        this.recipe = recipe;

        createPanel();
        buttonSound(-80); // actionPerformed 에서만 실행하면 처음 버튼을 누를때 약간의 렉이 발생해서
        // 여기서 먼저 소리 없이 한번 실행시켜줬다.
    }

    private void createPanel() {
        /*Buttons Panel*/
        buttonPanel.setBackground(new Color(0xFFFFFF));
        buttonPanel.setLayout(new GridLayout(6, 2));
        buttonPanel.setPreferredSize(new Dimension(400, 600));
        /*Left Panel*/
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(new Color(189, 209, 239));
        leftPanel.setPreferredSize(new Dimension(500, 600));
        /*Ingredient Panel*/
        ingredientPanel.setBackground(new Color(0xFFF6EF));
        ingredientPanel.setPreferredSize(new Dimension(200, 180));
        ingredientPanel.setLayout(new FlowLayout());
        /*Display Panel*/
        displayPanel.setBackground(Color.WHITE);
        displayPanel.setPreferredSize(new Dimension(200, 420));
        displayPanel.setLayout(new BorderLayout(10, 10));

        leftPanel.add(ingredientPanel, BorderLayout.NORTH);
        leftPanel.add(displayPanel, BorderLayout.SOUTH);

        makeButtonList();
        makeLabelList();
        displayPanel.add(make, BorderLayout.NORTH);
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

    void makeButton(String title) {
        JButton button = new JButton(title);
        button.setActionCommand(title);
        button.addActionListener(this);
        button.addMouseListener(this);
        button.setFocusable(false);
        button.setFont(new Font("a뉴굴림2", Font.BOLD, 20));
        if (button.getText().contains("제조") || button.getText().contains("목록")) {
            button.setBackground(new Color(0xEFDFCC));
            button.setFont(new Font("맑은고딕", Font.BOLD, 40));
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
            make.setHorizontalAlignment(JLabel.CENTER); // 라벨 세로 위치 설정
            make.setVisible(false);
        } else if (!option.contains("목록")) {
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
    }

    static void buttonSound(float volumeControl) {
        File file = new File("src/cocoa/week5/project/sound/button.wav");
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volumeControl);  // 볼륨 -10 데시벨
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonSound(-20);
        showLabel(e.getActionCommand());

        if (e.getActionCommand().contains("제조")) {
            make.setVisible(true);
            drink = this.recipe.checkRecipe(selectedIngredients);
            buildup();
        }
        if (e.getActionCommand().contains("목록")) {

            if (this.recipe.toBeMade.size() > 0) {
                JOptionPane.showMessageDialog(buttonPanel,
                        this.recipe.toBeMade.toArray());
            } else {
                JOptionPane.showMessageDialog(buttonPanel,
                        "          모든 음료 완성! \n 이제 직접 사먹으러 가자^-^");
            }
        }
    }

    private void buildup() {
        playSound();
        Timer timer1 = new Timer(700, e -> {
            make.setVisible(!make.isVisible());        //깜빡이 효과
        });

        Timer timer2 = new Timer(4000, e -> {
            timer1.stop();
            resetLabel();
        });

        timer1.setRepeats(true);
        timer1.start();
        timer2.setRepeats(false);
        timer2.start();
    }

    private void playSound() {
        File file;

        if (drink == null) {
            file = new File("src/cocoa/week5/project/sound/Cooking_Fail.wav");
        } else {
            file = new File("src/cocoa/week5/project/sound/Cooking_Success.wav");
        }
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0);  // 볼륨 -10 데시벨
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetLabel() {
        selectedIngredients.clear();

        for (Component jc : ingredientPanel.getComponents()) {
            jc.setVisible(false);
        }
        make.setVisible(false);
        showDrink();
    }

    public void showDrink() {
        ImageIcon icon;
        imgLabel = new JLabel();
        if (drink == null) {
            icon = new ImageIcon("src/cocoa/week5/project/image/FAIL.png");
        } else {
            icon = new ImageIcon("src/cocoa/week5/project/image/coffee2.gif");
            imgLabel.setText(drink);
        }
        imgLabel.setIcon(icon);
        imgLabel.setHorizontalTextPosition(JLabel.CENTER);  // 라벨 텍스트 위치
        imgLabel.setVerticalTextPosition(JLabel.BOTTOM);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setFont(new Font("a뉴굴림2", Font.BOLD, 30));
        imgLabel.setIconTextGap(20);
        displayPanel.add(imgLabel, BorderLayout.CENTER);
        if (drink == null) {
            JOptionPane.showMessageDialog(ingredientPanel, "                    실패!");
        } else {
            JOptionPane.showMessageDialog(ingredientPanel, drink + " 성공!");
        }
        displayPanel.remove(1);
        displayPanel.repaint();  // 이게 있어야 이미지가 안보이게된다
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // 버튼 위에선 손 모양 마우스 포인터로 변경
        e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
}

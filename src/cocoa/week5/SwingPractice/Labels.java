package cocoa.week5.SwingPractice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Labels {
    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("image/cabbage22.png");
        Border border = BorderFactory.createLineBorder(Color.green, 3);

        JLabel label = new JLabel();
        label.setText("Do you even code, Bro?");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);  // 라벨 텍스트 가로 위치
        label.setVerticalTextPosition(JLabel.TOP);       // 라벨 텍스트 세로 위치
        label.setForeground(new Color(0xff0000));   // 라벨 텍스트 색상
        label.setFont(new Font("MV Boli", Font.BOLD, 50));
        label.setIconTextGap(0);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);      //백그라운드 컬러 보여짐
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); // 라벨 가로 위치 설정
        label.setHorizontalAlignment(JLabel.CENTER);// 라벨 세로 위치 설정
//        label.setBounds(50,50,250,250);


        JFrame frame = new JFrame();
        frame.setTitle("Labels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
//        frame.setLayout(null);
//        frame.setResizable(false);  // 창 크기 고정
        frame.setVisible(true);
        frame.add(label);
//        frame.getContentPane().setBackground(Color.BLACK);
    frame.pack(); // frame에 맞게 내용 정렬. 맨 마지막에 추가해야 작동한다.
    }
}

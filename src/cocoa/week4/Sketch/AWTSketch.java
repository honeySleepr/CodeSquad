package cocoa.week4.Sketch;

import java.awt.*;
import java.awt.event.*;

public class AWTSketch extends Frame implements MouseMotionListener {
    int x1, x2, x3;
    int y1, y2, y3;
    Image img = null;
    Graphics graphics = null;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Panel panel;
    static String option;              // todo: static 안쓰고 어떻게 해야할까


    public static void main(String[] args) {
        new AWTSketch("Sketch test 2");
    }

    public AWTSketch(String title) {
        super(title);
        addMouseMotionListener(this);
        addMouseListener(new MouseHandler());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Buttons();

        setBounds(700, 300, 500, 500);
        setVisible(true);

        img = createImage(500, 500);

        graphics = img.getGraphics();
        graphics.drawString("왼쪽 버튼 누르고 선 그리기", 20, 80);
        repaint();
    }

    public void Buttons() {
        panel = new Panel(new FlowLayout(1, 20, 5));
        add(panel, BorderLayout.NORTH);
        bt1 = new Button("사각형");
        bt2 = new Button("원");
        bt3 = new Button("직선");
        bt4 = new Button("곡선");
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(bt4);
        bt1.addActionListener(new ActionHandler());
        bt2.addActionListener(new ActionHandler());
        bt3.addActionListener(new ActionHandler());
        bt4.addActionListener(new ActionHandler());
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("PAINT 호출");
        if (img == null) {
            return;
        }
        g.drawImage(img, 0, 0, this);
// Dynamically calculate size information
//        Dimension size = getSize();        // diameter
//        int d = 50;
//        int x = (size.width - d) / 2;
//        int y = (size.height - d) / 2;
//        // draw circle (color already set to foreground)
//
//        g.setColor(Color.green);
//        g.drawOval(x, y, d, d);
    }


    @Override
    public void mouseMoved(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (option.equals("직선")) {
            if (me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;
            graphics.drawLine(x1, y1, me.getX(), me.getY());
            x1 = me.getX();
            y1 = me.getY();
            repaint();
        } else if (option.equals("원")) {
            if (me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;
            graphics.drawOval(x2, y2, x3, y3);

            repaint();
        }{
            return;
        }
    }

    class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            System.out.println("클-");
            System.out.println(x2);
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            x3 = getX();
            y3 = getY();
            System.out.println("-릭");
        }
    }
    class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Button btn = (Button) e.getSource();
            if (btn.getLabel().equals("사각형")) {
                option = btn.getLabel();
            } else if (btn.getLabel().equals("원")) {
                System.out.println(btn.getLabel());
                option = btn.getLabel();
            } else if (btn.getLabel().equals("직선")) {
                System.out.println(btn.getLabel());
                option = btn.getLabel();
                System.out.println(option);
            } else if (btn.getLabel().equals("곡선")) {
                System.out.println(btn.getLabel());
                option = btn.getLabel();
            }
        }
    }
}







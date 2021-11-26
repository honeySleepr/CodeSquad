package cocoa.week4.Sketch;

import java.awt.*;
import java.awt.event.*;

/*잔상 남기기 구현 실패..*/

public class AWTSketch extends Frame {
    int x1, x2, x4, x3;
    int y1, y2, y4, y3;
    Image img = null;
    Image img2 = null;
    Graphics graphics = null;
    Graphics graphics2 = null;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Panel panel;
    String option = "사각형";
    boolean mouseDown = false;

    public static void main(String[] args) {
        new AWTSketch("Sketch test 2");
    }

    public AWTSketch(String title) {
        super(title);
        MouseHandler mouse = new MouseHandler();
        addMouseMotionListener(mouse);
        addMouseListener(mouse);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Buttons();
        setBounds(700, 300, 800, 800);
        setVisible(true);
        /*여기 순서 때문에 에러났었네..*/
        img = createImage(getWidth(), getHeight());
        graphics = img.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        paintComponents(g);
        /*여기 순서 바꾸니 또 되네..*/
        g.drawImage(img2, 0, 0, this);
        g.drawImage(img, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        if (option.equals("사각형")) {
            graphics.drawRect(Math.min(x2, x4), Math.min(y2, y4), Math.abs(x4 - x2), Math.abs(y4 - y2));
        }
        if (option.equals("원")) {
            graphics.drawOval(Math.min(x2, x4), Math.min(y2, y4), Math.abs(x4 - x2), Math.abs(y4 - y2));
        }
        if (option.equals("곡선")) {
            graphics.drawLine(x2, y2, x3, y3);
            x2 = x3;
            y2 = y3;

            /* 이것 때문에 쌩고생..*/
//            repaint();
        }

        if (option.equals("직선")) {
            graphics.drawLine(x2, y2, x4, y4);
        }
    }

    class MouseHandler implements MouseMotionListener, MouseListener {
        @Override
        public void mouseMoved(MouseEvent e) {

            x1 = e.getX();
            y1 = e.getY();
        }

        @Override
        public void mousePressed(MouseEvent e) {

            mouseDown = true;
            x2 = e.getX();
            y2 = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            x3 = e.getX();
            y3 = e.getY();

            /*여기에 이걸 넣으니 되네..?*/
            if (option.equals("곡선")) {
                repaint();
            }
            if (option.equals("직선")) {
                /* 잔상 구현 실패..repaint 넣으면 잔상은 나타나지만 실제로 그려지는 라인이 이상해진다 */
//                img2 = createImage(getWidth(), getHeight());
//                graphics2 = img2.getGraphics();
//                graphics2.setColor(Color.red);
//                graphics2.drawLine(x2 + 30, y2, x3, y3);

//                graphics2.dispose();
//                img2.flush();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mouseDown = false;
            x4 = e.getX();
            y4 = e.getY();

            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public void Buttons() {
        panel = new Panel(new FlowLayout(1, 20, 5));
        add(panel, BorderLayout.NORTH);
        bt1 = new Button("사각형");
        bt2 = new Button("원");
        bt3 = new Button("곡선");
        bt4 = new Button("직선");
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(bt4);
        bt1.addActionListener(new ActionHandler());
        bt2.addActionListener(new ActionHandler());
        bt3.addActionListener(new ActionHandler());
        bt4.addActionListener(new ActionHandler());
    }

    class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Button btn = (Button) e.getSource();

            if (btn.getLabel().equals("사각형")) {

                option = btn.getLabel();
                System.out.println(option);
            } else if (btn.getLabel().equals("원")) {

                option = btn.getLabel();
                System.out.println(option);
            } else if (btn.getLabel().equals("곡선")) {

                option = btn.getLabel();
                System.out.println(option);
            } else if (btn.getLabel().equals("직선")) {

                option = btn.getLabel();
                System.out.println(option);
            }
        }
    }
}







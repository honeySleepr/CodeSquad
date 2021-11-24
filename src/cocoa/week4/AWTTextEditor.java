package cocoa.week4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class AWTTextEditor extends Frame {
    String fileName;
    TextArea content;
    MenuBar mb;
    Menu mFile, mView;
    MenuItem miNew, miOpen, miSaveAs, miExit;
    CheckboxMenuItem miChangeLine;

    public static void main(String[] args) {
        AWTTextEditor main = new AWTTextEditor("TextEditor");
    }

    AWTTextEditor(String title) {
        super(title);

        // X 누르면 창 종료되도록 설정
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
            }
        });

        content = new TextArea();
        add(content);

        mb = new MenuBar();
        mFile = new Menu("File");
        mView = new Menu("View");
        miNew = new MenuItem("New");
        miOpen = new MenuItem("Open");
        miSaveAs = new MenuItem("Save As..");
        miExit = new MenuItem("Exit");
        miChangeLine = new CheckboxMenuItem("Word wrap");

        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSaveAs);
        mFile.addSeparator();
        mFile.add(miExit);
        mView.add(miChangeLine);

        mb.add(mFile);
        mb.add(mView);
        setMenuBar(mb);

        MenuHandler handler = new MenuHandler();
        miNew.addActionListener(handler);
        miOpen.addActionListener(handler);
        miSaveAs.addActionListener(handler);
        miExit.addActionListener(handler);

        setVisible(true);
        setSize(500, 500);
    }

    void fileOpen(String fileName) {
        FileReader fr;
        BufferedReader br;
        StringWriter sw;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            sw = new StringWriter();
            int ch = 0;
            while ((ch = br.read()) != -1) {
                sw.write(ch);
            }
            br.close();
            content.setText(sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void saveAs(String fileName) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            bw.write(content.getText());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class MenuHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // todo: 텍스트 줄 자동 바꿈 설정 어떻게?
            if (miChangeLine.getState()) {
//                setLayout(new FlowLayout());
            }

            //File Menu 기능 설정
            if (command.equals("New")) {
                content.setText("");
            } else if (command.equals("Open")) {
                FileDialog open = new FileDialog(AWTTextEditor.this, "오픈더파일!");
                open.setVisible(true);
                fileName = open.getDirectory() + open.getFile();
                System.out.println(fileName);
                fileOpen(fileName);
            } else if (command.equals("Save As..")) {
                FileDialog save = new FileDialog(AWTTextEditor.this, "즈어어어어장!", FileDialog.SAVE);
                save.setVisible(true);
                fileName = save.getDirectory() + save.getFile();
                System.out.println(fileName);
                saveAs(fileName);
            } else if (command.equals("Exit")) {
                System.exit(0);
            }

        }
    }
}

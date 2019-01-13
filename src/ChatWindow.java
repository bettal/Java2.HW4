import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class ChatWindow extends JFrame{

    String fontName = "Arial";
        int style = 0;
        int size = 30;

        public ChatWindow() {
            setTitle("MyWindows");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(500, 300, 500, 400);

            setLayout(new GridLayout(2, 2));

            JTextArea textArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.append("Мой текст \n");
            add(scrollPane);

            textArea.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println(e.getX() + " " + e.getY());
                    textArea.setBackground(Color.getHSBColor(
                            (float) Math.random(),
                            (float) Math.random(),
                            (float) Math.random() * 0.2f + 0.8f
                    ));
                }
            });


            //////////////////////////////////////////

            JPanel panel1 = new JPanel();
            JCheckBox italicBox = new JCheckBox("Italic");
            JCheckBox boldBox = new JCheckBox("Bold");
            panel1.add(italicBox);
            panel1.add(boldBox);
            add(panel1);

            Font font = new Font(fontName, style, size);
            textArea.setFont(font);

            ChangeListener changeListener = new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    style = boldBox.isSelected() ? 1 : 0;
                    style += italicBox.isSelected() ? 2 : 0;
                    textArea.setFont(new Font(fontName, style, size));
                }
            };
            italicBox.addChangeListener(changeListener);
            boldBox.addChangeListener(changeListener);

            /////////////////////////////

            JPanel buttonPanel = new JPanel();
            ButtonGroup group = new ButtonGroup();
            JRadioButton radioButton18 = new JRadioButton("18");
            JRadioButton radioButton30 = new JRadioButton("30", true);
            JRadioButton radioButton48 = new JRadioButton("48");

            group.add(radioButton18);
            group.add(radioButton30);
            group.add(radioButton48);

            buttonPanel.add(radioButton18);
            buttonPanel.add(radioButton30);
            buttonPanel.add(radioButton48);

            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (radioButton18.isSelected()) {
                        size = 18;
                    }
                    if (radioButton30.isSelected()) {
                        size = 30;
                    }
                    if (radioButton48.isSelected()) {
                        size = 48;
                    }
                    textArea.setFont(new Font(fontName, style, size));
                }
            };
            radioButton18.addActionListener(actionListener);
            radioButton30.addActionListener(actionListener);
            radioButton48.addActionListener(actionListener);

            add(buttonPanel);

            //////////////////////////////////////////////

            JPanel panel = new JPanel();
            JTextField textField = new JTextField("some text");
            Dimension dimension = new Dimension(200, 30);
            textField.setPreferredSize(dimension);
            panel.add(textField);

            JButton jButton = new JButton("Ввод");
            jButton.setPreferredSize(dimension);
            panel.add(jButton);

//        textArea.setEditable(false);

            textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(textField.getText() + "\n");
                    textField.setText("");
                    textField.grabFocus();
                }
            });

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(textField.getText() + "\n");
                    textField.setText("");
                    textField.grabFocus();
                }
            });

            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    System.out.println(e.getKeyCode());
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        System.out.println("Пробел");
                    }
                    if (e.getKeyCode() == KeyEvent.VK_F1) {
                        System.out.println("HELP");
                    }

                }
            });


            add(panel);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("Bue!");
                }

                @Override
                public void windowActivated(WindowEvent e) {
                    System.out.println("Activated");
                }

                @Override
                public void windowDeactivated(WindowEvent e) {
                    System.out.println("Deactivated   ");
                }
            });

            ///////////////////////////////////

            JMenuBar menuBar = new JMenuBar();
            JMenu file = new JMenu("Файл");
            JMenuItem open = new JMenuItem("Открыть",
                    new ImageIcon("src/img/open.png"));
            JMenuItem exit = new JMenuItem("Выход",
                    new ImageIcon("src/img/exit.png"));

            file.add(open);
            file.addSeparator();
            file.add(exit);
            menuBar.add(file);
            setJMenuBar(menuBar);

            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    dispose();
                }
            });

            setVisible(true);
        }
    }



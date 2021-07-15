import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Main {
    JButton clearBtn, whiteBtn, blueBtn, limeBtn, orangeBtn, yellowBtn;
    Slate drawArea;
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == whiteBtn) {
                drawArea.white();
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
            } else if (e.getSource() == limeBtn) {
                drawArea.lime();
            } else if (e.getSource() == orangeBtn) {
                drawArea.orange();
            } else if (e.getSource() == yellowBtn) {
                drawArea.yellow();
            }
        }
    };
    public static void main(String[] args) {
        new Main().show();
    }
    public void show() {
        
        JFrame frame = new JFrame("Slate");
        ImageIcon icon = new ImageIcon("slate.png");
        frame.setIconImage(icon.getImage());
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        drawArea = new Slate();
        content.add(drawArea, BorderLayout.CENTER);
        JPanel controls = new JPanel();
        clearBtn = new JButton("CLEAR");
        clearBtn.setFocusable(false);
        clearBtn.setBounds(440,15,50,27);
        clearBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        clearBtn.setForeground(new Color(0xa074c4));
        clearBtn.setBackground(new Color(0xa074c4));
        clearBtn.setOpaque(false);
        clearBtn.setBorderPainted(false);
        clearBtn.addActionListener(actionListener);

        whiteBtn = new JButton("WHITE");
        whiteBtn.setFocusable(false);
        whiteBtn.setBounds(440,15,50,27);
        whiteBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        whiteBtn.setForeground(Color.white);
        whiteBtn.setBackground(Color.white);
        whiteBtn.setOpaque(false);
        whiteBtn.setBorderPainted(false);
        whiteBtn.addActionListener(actionListener);

        blueBtn = new JButton("BLUE");
        blueBtn.addActionListener(actionListener);
        blueBtn.setFocusable(false);
        blueBtn.setBounds(440,15,50,27);
        blueBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        blueBtn.setForeground(new Color(0x87cefa));
        blueBtn.setBackground(new Color(0x87cefa));
        blueBtn.setOpaque(false);
        blueBtn.setBorderPainted(false);

        limeBtn = new JButton("GREEN");
        limeBtn.setFocusable(false);
        limeBtn.setBounds(440,15,50,27);
        limeBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        limeBtn.setForeground(new Color(0xc2d647));
        limeBtn.setBackground(new Color(0xc2d647));
        limeBtn.setOpaque(false);
        limeBtn.setBorderPainted(false);
        limeBtn.addActionListener(actionListener);

        orangeBtn = new JButton("ORANGE");
        orangeBtn.setFocusable(false);
        orangeBtn.setBounds(440,15,50,27);
        orangeBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        orangeBtn.setForeground(new Color(0xd85c14));
        orangeBtn.setBackground(new Color(0xd85c14));
        orangeBtn.setOpaque(false);
        orangeBtn.setBorderPainted(false);
        orangeBtn.addActionListener(actionListener);

        yellowBtn = new JButton("YELLOW");
        yellowBtn.setFocusable(false);
        yellowBtn.setBounds(440,15,50,27);
        yellowBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        yellowBtn.setForeground(new Color(0xffb454));
        yellowBtn.setBackground(new Color(0xffb454));
        yellowBtn.setOpaque(false);
        yellowBtn.setBorderPainted(false);
        yellowBtn.addActionListener(actionListener);
        
        controls.add(limeBtn);
        controls.add(blueBtn);
        controls.add(whiteBtn);
        controls.add(orangeBtn);
        controls.add(yellowBtn);
        controls.add(clearBtn);
        controls.setBackground(new Color(0x00010a));
        content.add(controls, BorderLayout.SOUTH);


        // Toolkit toolkit = Toolkit.getDefaultToolkit();
        // Image image = toolkit.getImage("test.png");
        // Cursor c = toolkit.createCustomCursor(image , new Point(frame.getX(),frame.getY()), "img");
        // frame.setCursor (c);





        frame.setSize(1200, 999);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}
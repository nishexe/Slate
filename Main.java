import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Main{
    private JSlider sizeSlider = new JSlider(1,100);
    private JButton clearBtn, whiteBtn, blueBtn, limeBtn, orangeBtn, yellowBtn, wiperBtn;
    private Slate drawArea;
    private int lastSize = 5;
    private int brushSize = lastSize;
    private JLabel sizeLabel = new JLabel();
    private JLabel toolLabel = new JLabel();
    /* The below array is required to set the last used color after the clear canvas function is called */
    private int[] hexArr = {
        0xc2d647,/* 0 LIME */
        0x87cefa,/* 1 BLUE */
        0xFFFFFF,/* 2 WHITE */
        0xd85c14,/* 3 ORANGE */
        0xffb454,/* 4 YELLOW */
    };
    private int lastColor = 0;
    /* :) */
    /* ActionListener for the controls (Buttons for COLORS) */
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn){
                drawArea.clear(hexArr[lastColor]);
            }
            else if (e.getSource() == whiteBtn){
                drawArea.white();
                drawArea.setSize(lastSize);
                sizeSlider.setValue(lastSize);
                toolLabel.setText("WHITE");
                toolLabel.setForeground(Color.WHITE);
                toolLabel.setBackground(Color.WHITE);
                lastColor = 2;
            }
            else if (e.getSource() == blueBtn){
                drawArea.blue();
                drawArea.setSize(lastSize);
                sizeSlider.setValue(lastSize);
                toolLabel.setText("BLUE");
                toolLabel.setForeground(new Color(0x87cefa));
                toolLabel.setBackground(new Color(0x87cefa));
                lastColor = 1;
            }
            else if (e.getSource() == limeBtn){
                drawArea.lime();
                drawArea.setSize(lastSize);
                sizeSlider.setValue(lastSize);
                toolLabel.setText("LIME");
                toolLabel.setForeground(new Color(0xc2d647));
                toolLabel.setBackground(new Color(0xc2d647));
                lastColor = 0;
            }
            else if (e.getSource() == orangeBtn){
                drawArea.orange();
                drawArea.setSize(lastSize);
                sizeSlider.setValue(lastSize);
                toolLabel.setText("ORANGE");
                toolLabel.setForeground(new Color(0xd85c14));
                toolLabel.setBackground(new Color(0xd85c14));
                lastColor = 3;
            }
            else if (e.getSource() == yellowBtn){
                drawArea.yellow();
                drawArea.setSize(lastSize);
                sizeSlider.setValue(lastSize);
                toolLabel.setText("YELLOW");
                toolLabel.setForeground(new Color(0xffb454));
                toolLabel.setBackground(new Color(0xffb454));
                lastColor = 4;
            }
            else if(e.getSource() == wiperBtn){
                if(lastSize > sizeSlider.getValue()){
                    lastSize = sizeSlider.getValue();
                }
                drawArea.wiper();
                drawArea.setSize(75);
                sizeSlider.setValue(75);
                toolLabel.setText("WIPER");
                toolLabel.setForeground(new Color(0x6844ca));
                toolLabel.setBackground(new Color(0x6844ca));
            }
        }
    };
    /* KeyListener for keyboard shortcuts */
    KeyListener KL = new KeyListener(){
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyChar()){
                case 'w':
                        drawArea.white();
                        drawArea.setSize(lastSize);
                        sizeSlider.setValue(lastSize);
                        toolLabel.setText("WHITE");
                        toolLabel.setForeground(Color.WHITE);
                        toolLabel.setBackground(Color.WHITE);
                        lastColor = 2;
                break;
                case 'b':
                        drawArea.blue();
                        drawArea.setSize(lastSize);
                        sizeSlider.setValue(lastSize);
                        toolLabel.setText("BLUE");
                        toolLabel.setForeground(new Color(0x87cefa));
                        toolLabel.setBackground(new Color(0x87cefa));
                        lastColor = 1;
                break;
                case 'g':
                        drawArea.lime();
                        drawArea.setSize(lastSize);
                        sizeSlider.setValue(lastSize);
                        toolLabel.setText("LIME");
                        toolLabel.setForeground(new Color(0xc2d647));
                        toolLabel.setBackground(new Color(0xc2d647));
                        lastColor = 0;
                break;
                case 'y':
                        drawArea.yellow();
                        drawArea.setSize(lastSize);
                        sizeSlider.setValue(lastSize);
                        toolLabel.setText("YELLOW");
                        toolLabel.setForeground(new Color(0xffb454));
                        toolLabel.setBackground(new Color(0xffb454));
                        lastColor = 4;
                break;
                case 'o':
                        drawArea.orange();
                        drawArea.setSize(lastSize);
                        sizeSlider.setValue(lastSize);
                        toolLabel.setText("ORANGE");
                        toolLabel.setForeground(new Color(0xd85c14));
                        toolLabel.setBackground(new Color(0xd85c14));
                        lastColor = 3;
                break;
                case 'W':
                        if(lastSize > sizeSlider.getValue()){
                            lastSize = sizeSlider.getValue();
                        }
                        drawArea.wiper();
                        drawArea.setSize(75);
                        sizeSlider.setValue(75);
                        toolLabel.setText("WIPER");
                        toolLabel.setForeground(new Color(0x6844ca));
                        toolLabel.setBackground(new Color(0x6844ca));
                break;
                case 'C':
                        if(toolLabel.getText()=="WIPER"){
                            drawArea.clear(0x0a0e14);
                        }
                        else{
                            drawArea.clear(hexArr[lastColor]);
                        }
                break;
                case '1':
                if(sizeSlider.getValue()>1){
                    sizeSlider.setValue(sizeSlider.getValue()-1);
                }
                break;
                case '2':
                if(lastSize<100){
                    sizeSlider.setValue(sizeSlider.getValue()+1);
                }
                break;
                case '3':
                sizeSlider.setValue(5);
                lastSize = 5;
                break;
                case '!':
                if(sizeSlider.getValue()>5){
                    sizeSlider.setValue(sizeSlider.getValue()-5);
                }
                break;
                case '@':
                if(lastSize<100){
                    sizeSlider.setValue(sizeSlider.getValue()+5);
                }
                break;
            }
        }  
        public void keyReleased(KeyEvent e) {  
        }  
        public void keyTyped(KeyEvent e) {  
        }
    };
    @SuppressWarnings("deprecation")
    public void show() {
        /*Setting up required JComponents */
        JFrame frame = new JFrame("Slate");
        ImageIcon appicon = new ImageIcon("icons/appicon/slate.png");
        ImageIcon blueIcon = new ImageIcon("icons/colors/blue.png");
        ImageIcon greenIcon = new ImageIcon("icons/colors/lime.png");
        ImageIcon orangeIcon = new ImageIcon("icons/colors/orange.png");
        ImageIcon yellowIcon = new ImageIcon("icons/colors/yellow.png");
        ImageIcon whiteIcon = new ImageIcon("icons/colors/white.png");
        Container content = frame.getContentPane();
        JPanel controls = new JPanel();
        JPanel topPanel = new JPanel();
        frame.setIconImage(appicon.getImage());
        content.setLayout(new BorderLayout());
        drawArea = new Slate();
        content.add(drawArea, BorderLayout.CENTER);
        /* Setting up clear button */
        clearBtn = new JButton("CLEAR");
        clearBtn.setFocusable(false);
        clearBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        clearBtn.setForeground(new Color(0xa074c4));
        clearBtn.setBackground(new Color(0xa074c4));
        clearBtn.setOpaque(false);
        clearBtn.setBorderPainted(false);
        clearBtn.setBorder(BorderFactory.createEmptyBorder(7,0,0,0));
        clearBtn.addActionListener(actionListener);
        /* Setting up white button */
        whiteBtn = new JButton(whiteIcon);
        whiteBtn.setFocusable(false);
        whiteBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        whiteBtn.setForeground(Color.white);
        whiteBtn.setBackground(Color.white);
        whiteBtn.setOpaque(false);
        whiteBtn.setBorderPainted(false);
        whiteBtn.addActionListener(actionListener);
        /* Setting up blue button */
        blueBtn = new JButton(blueIcon);
        blueBtn.addActionListener(actionListener);
        blueBtn.setFocusable(false);
        blueBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        blueBtn.setForeground(new Color(0x87cefa));
        blueBtn.setBackground(new Color(0x87cefa));
        blueBtn.setOpaque(false);
        blueBtn.setBorderPainted(false);
        /* Setting up Green button */
        limeBtn = new JButton(greenIcon);
        limeBtn.setFocusable(false);
        limeBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        limeBtn.setForeground(new Color(0xc2d647));
        limeBtn.setBackground(new Color(0xc2d647));
        limeBtn.setOpaque(false);
        limeBtn.setBorderPainted(false);
        limeBtn.addActionListener(actionListener);
        /* Setting up Orange button */
        orangeBtn = new JButton(orangeIcon);
        orangeBtn.setFocusable(false);
        orangeBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        orangeBtn.setForeground(new Color(0xd85c14));
        orangeBtn.setBackground(new Color(0xd85c14));
        orangeBtn.setOpaque(false);
        orangeBtn.setBorderPainted(false);
        orangeBtn.addActionListener(actionListener);
        /* Setting up Yellow button */
        yellowBtn = new JButton(yellowIcon);
        yellowBtn.setFocusable(false);
        yellowBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        yellowBtn.setForeground(new Color(0xffb454));
        yellowBtn.setBackground(new Color(0xffb454));
        yellowBtn.setOpaque(false);
        yellowBtn.setBorderPainted(false);
        yellowBtn.addActionListener(actionListener);
        /* Setting up Eraser button */
        wiperBtn = new JButton("WIPER");
        wiperBtn.setFocusable(false);
        wiperBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        wiperBtn.setForeground(new Color(0x6844ca));
        wiperBtn.setBackground(new Color(0x6844ca));
        wiperBtn.setOpaque(false);
        wiperBtn.setBorderPainted(false);
        wiperBtn.setBorder(BorderFactory.createEmptyBorder(7,0,0,0));
        wiperBtn.addActionListener(actionListener);
        /* Adding components to controls JPanel */
        controls.add(wiperBtn);
        controls.add(limeBtn);
        controls.add(blueBtn);
        controls.add(whiteBtn);
        controls.add(orangeBtn);
        controls.add(yellowBtn);
        controls.add(clearBtn);
        controls.setBackground(new Color(0x00010a));
        content.add(controls, BorderLayout.SOUTH);
        /* Setting up the sizeLabel that shows the corresponding value of the brush size slider */
        sizeLabel.setText(Integer.toString(brushSize)+"px");
        sizeLabel.setFont(new Font("Calibri",Font.PLAIN,19));
        sizeLabel.setBorder(BorderFactory.createEmptyBorder(3,0,0,0));
        sizeLabel.setForeground(new Color(0x636a72));
        sizeLabel.setBackground(new Color(0x636a72));
        /* Setting up the colorLabel that shows current selected color */
        toolLabel.setText("LIME");
        toolLabel.setFont(new Font("Calibri",Font.PLAIN,13));
        toolLabel.setBorder(BorderFactory.createEmptyBorder(5,2,0,0));
        toolLabel.setForeground(new Color(0xc2d647));
        toolLabel.setBackground(new Color(0xc2d647));
        /* Setting up the brush size slider and the top JPanel */        
        sizeSlider.setBackground(new Color(0x00010a));
        sizeSlider.setSnapToTicks(true);
        sizeSlider.setPreferredSize(new Dimension(900, 20));
        sizeSlider.setValue(5);
        sizeSlider.setOpaque(false);
        sizeSlider.addChangeListener(e -> sliderChanged());
        topPanel.add(sizeSlider);
        topPanel.add(sizeLabel);
        topPanel.add(toolLabel);
        topPanel.setBackground(new Color(0x00010a));
        topPanel.setBorder(null);
        topPanel.setFocusable(false);
        content.add(topPanel, BorderLayout.NORTH);
        /* Setting up the JFrame */
        /* Every component needs to be focusable in order for the KeyListener to work */
        frame.setFocusable(true);
        frame.addKeyListener(KL);
        sizeSlider.setFocusable(true);
        sizeSlider.addKeyListener(KL);
        topPanel.setFocusable(true);
        topPanel.addKeyListener(KL);
        controls.setFocusable(true);
        controls.addKeyListener(KL);
        content.setFocusable(true);
        content.addKeyListener(KL);
        /* -_- */
        frame.setCursor(Cursor.HAND_CURSOR); //This method of setting cursor is depricated.
        frame.setSize(1200, 999);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    /* Function that sets the brush size from the slider */
    public void sliderChanged(){
        drawArea.setSize(sizeSlider.getValue());
        sizeLabel.setText(Integer.toString(sizeSlider.getValue())+"px");
        if(sizeSlider.getValue() < 75){
            lastSize = sizeSlider.getValue();
        }
    }
    /* Main method */
    public static void main(String[] args){
        new Main().show();
    }
}
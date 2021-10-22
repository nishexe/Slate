package src;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
public class Main{
    /*Setting up required JComponents */
    private JSlider sizeSlider = new JSlider(1,100);
    private JButton clearBtn, whiteBtn, blueBtn, limeBtn, orangeBtn, yellowBtn, wiperBtn;
    private Slate drawArea;
    private int brushSize = 3;
    private JPanel controls = new JPanel();
    private JPanel topPanel = new JPanel();
    private JLabel toolLabel = new JLabel();
    private JLabel sizeLabel = new JLabel();
    private JFrame frame = new JFrame("Slate");
    private Container content = frame.getContentPane();
    private ImageIcon appIcon = new ImageIcon("src/icons/appicon/slate.png");
    private ImageIcon blueIcon = new ImageIcon("src/icons/colors/blue.png");
    private ImageIcon limeIcon = new ImageIcon("src/icons/colors/lime.png");
    private ImageIcon orangeIcon = new ImageIcon("src/icons/colors/orange.png");
    private ImageIcon yellowIcon = new ImageIcon("src/icons/colors/yellow.png");
    private ImageIcon whiteIcon = new ImageIcon("src/icons/colors/white.png");
    /* Enum to store colors hexadeicmal values */
    enum Colors{
        LIME(0xc2d647),
        BLUE(0x87cefa),
        WHITE(0xFFFFFF),
        ORANGE(0xd85c14),
        YELLOW(0xffb454),
        BACKGROUND(0x0a0e14);

        int HEX_VAL;
        Colors(int HEX_VAL){
            this.HEX_VAL = HEX_VAL;
        }
    }
    private int lastColor = Colors.LIME.HEX_VAL; // Default brush color is lime
    /* ActionListener for the controls (Buttons for COLORS) */
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn){
                if(toolLabel.getText()=="WIPER"){
                    drawArea.clear(Colors.BACKGROUND.HEX_VAL);
                }
                else{
                    drawArea.clear(lastColor);
                }
            }
            else if (e.getSource() == whiteBtn){
                drawArea.white();
                drawArea.setSize(brushSize);
                sizeSlider.setValue(brushSize);
                toolLabel.setText("WHITE");
                toolLabel.setForeground(new Color(Colors.WHITE.HEX_VAL));
                lastColor = Colors.WHITE.HEX_VAL;
            }
            else if (e.getSource() == blueBtn){
                drawArea.blue();
                drawArea.setSize(brushSize);
                sizeSlider.setValue(brushSize);
                toolLabel.setText("BLUE");
                toolLabel.setForeground(new Color(Colors.BLUE.HEX_VAL));
                lastColor = Colors.BLUE.HEX_VAL;
            }
            else if (e.getSource() == limeBtn){
                drawArea.lime();
                drawArea.setSize(brushSize);
                sizeSlider.setValue(brushSize);
                toolLabel.setText("LIME");
                toolLabel.setForeground(new Color(Colors.LIME.HEX_VAL));
                lastColor = Colors.LIME.HEX_VAL;
            }
            else if (e.getSource() == orangeBtn){
                drawArea.orange();
                drawArea.setSize(brushSize);
                sizeSlider.setValue(brushSize);
                toolLabel.setText("ORANGE");
                toolLabel.setForeground(new Color(Colors.ORANGE.HEX_VAL));
                lastColor = Colors.ORANGE.HEX_VAL;
            }
            else if (e.getSource() == yellowBtn){
                drawArea.yellow();
                drawArea.setSize(brushSize);
                sizeSlider.setValue(brushSize);
                toolLabel.setText("YELLOW");
                toolLabel.setForeground(new Color(Colors.YELLOW.HEX_VAL));
                lastColor = Colors.YELLOW.HEX_VAL;
            }
            else if(e.getSource() == wiperBtn){
                if(brushSize > sizeSlider.getValue()){
                    brushSize = sizeSlider.getValue();
                }
                drawArea.wiper();
                drawArea.setSize(75);
                sizeSlider.setValue(75);
                toolLabel.setText("WIPER");
                toolLabel.setForeground(new Color(0x6844ca));
            }
        }
    };
    /* KeyListener for keyboard shortcuts */
    KeyListener KL = new KeyListener(){
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyChar()){
                case 'w':
                        drawArea.white();
                        drawArea.setSize(brushSize);
                        sizeSlider.setValue(brushSize);
                        toolLabel.setText("WHITE");
                        toolLabel.setForeground(new Color(Colors.WHITE.HEX_VAL));
                        lastColor = Colors.WHITE.HEX_VAL;
                break;
                case 'b':
                        drawArea.blue();
                        drawArea.setSize(brushSize);
                        sizeSlider.setValue(brushSize);
                        toolLabel.setText("BLUE");
                        toolLabel.setForeground(new Color(Colors.BLUE.HEX_VAL));
                        lastColor = Colors.YELLOW.HEX_VAL;
                break;
                case 'g':
                        drawArea.lime();
                        drawArea.setSize(brushSize);
                        sizeSlider.setValue(brushSize);
                        toolLabel.setText("LIME");
                        toolLabel.setForeground(new Color(Colors.LIME.HEX_VAL));
                        lastColor = Colors.LIME.HEX_VAL;
                break;
                case 'y':
                        drawArea.yellow();
                        drawArea.setSize(brushSize);
                        sizeSlider.setValue(brushSize);
                        toolLabel.setText("YELLOW");
                        toolLabel.setForeground(new Color(Colors.YELLOW.HEX_VAL));
                        lastColor = Colors.YELLOW.HEX_VAL;
                break;
                case 'o':
                        drawArea.orange();
                        drawArea.setSize(brushSize);
                        sizeSlider.setValue(brushSize);
                        toolLabel.setText("ORANGE");
                        toolLabel.setForeground(new Color(Colors.ORANGE.HEX_VAL));
                        lastColor = Colors.ORANGE.HEX_VAL;;
                break;
                case 'W':
                        if(brushSize > sizeSlider.getValue()){
                            brushSize = sizeSlider.getValue();
                        }
                        drawArea.wiper();
                        drawArea.setSize(75);
                        sizeSlider.setValue(75);
                        toolLabel.setText("WIPER");
                        toolLabel.setForeground(new Color(0x6844ca));
                break;
                case 'C':
                        if(toolLabel.getText()=="WIPER"){
                            drawArea.clear(Colors.BACKGROUND.HEX_VAL);
                        }
                        else{
                            drawArea.clear(lastColor);
                        }
                break;
                case '1':
                if(sizeSlider.getValue()>1){
                    sizeSlider.setValue(sizeSlider.getValue()-1);
                }
                break;
                case '2':
                if(brushSize<100){
                    sizeSlider.setValue(sizeSlider.getValue()+1);
                }
                break;
                case '3':
                sizeSlider.setValue(3);
                brushSize = 3;
                break;
                case '!':
                if(sizeSlider.getValue()>5){
                    sizeSlider.setValue(sizeSlider.getValue()-5);
                }
                break;
                case '@':
                if(brushSize<100){
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
        
        frame.setIconImage(appIcon.getImage());
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
        whiteBtn.setForeground(new Color(Colors.WHITE.HEX_VAL));
        whiteBtn.setBackground(new Color(Colors.WHITE.HEX_VAL));
        whiteBtn.setOpaque(false);
        whiteBtn.setBorderPainted(false);
        whiteBtn.addActionListener(actionListener);
        /* Setting up blue button */
        blueBtn = new JButton(blueIcon);
        blueBtn.addActionListener(actionListener);
        blueBtn.setFocusable(false);
        blueBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        blueBtn.setForeground(new Color(Colors.BLUE.HEX_VAL));
        blueBtn.setBackground(new Color(Colors.BLUE.HEX_VAL));
        blueBtn.setOpaque(false);
        blueBtn.setBorderPainted(false);
        /* Setting up Green button */
        limeBtn = new JButton(limeIcon);
        limeBtn.setFocusable(false);
        limeBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        limeBtn.setForeground(new Color(Colors.LIME.HEX_VAL));
        limeBtn.setBackground(new Color(Colors.LIME.HEX_VAL));
        limeBtn.setOpaque(false);
        limeBtn.setBorderPainted(false);
        limeBtn.addActionListener(actionListener);
        /* Setting up Orange button */
        orangeBtn = new JButton(orangeIcon);
        orangeBtn.setFocusable(false);
        orangeBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        orangeBtn.setForeground(new Color(Colors.ORANGE.HEX_VAL));
        orangeBtn.setBackground(new Color(Colors.ORANGE.HEX_VAL));
        orangeBtn.setOpaque(false);
        orangeBtn.setBorderPainted(false);
        orangeBtn.addActionListener(actionListener);
        /* Setting up Yellow button */
        yellowBtn = new JButton(yellowIcon);
        yellowBtn.setFocusable(false);
        yellowBtn.setFont(new Font("Calibri",Font.PLAIN,24));
        yellowBtn.setForeground(new Color(Colors.YELLOW.HEX_VAL));
        yellowBtn.setBackground(new Color(Colors.YELLOW.HEX_VAL));
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
        /* Setting up the colorLabel that shows current selected color */
        toolLabel.setText("LIME");
        toolLabel.setFont(new Font("Calibri",Font.PLAIN,13));
        toolLabel.setBorder(BorderFactory.createEmptyBorder(5,2,0,0));
        toolLabel.setForeground(new Color(Colors.LIME.HEX_VAL));
        /* Setting up the brush size slider and the top JPanel */        
        sizeSlider.setBackground(new Color(0x00010a));
        sizeSlider.setSnapToTicks(true);
        sizeSlider.setPreferredSize(new Dimension(900, 20));
        sizeSlider.setValue(3);
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
        content.setFocusable(true);
        topPanel.setFocusable(true);
        controls.setFocusable(true);
        sizeSlider.setFocusable(true);
        frame.addKeyListener(KL);
        content.addKeyListener(KL);
        topPanel.addKeyListener(KL);
        controls.addKeyListener(KL);
        sizeSlider.addKeyListener(KL);
        /* -_- */
        frame.setCursor(Cursor.CROSSHAIR_CURSOR); //This method of setting cursor is depricated.
        frame.setSize(1290, 950);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    /* Function that sets the brush size from the slider */
    public void sliderChanged(){
        drawArea.setSize(sizeSlider.getValue());
        sizeLabel.setText(Integer.toString(sizeSlider.getValue())+"px");
        if(sizeSlider.getValue() < 75){
            brushSize = sizeSlider.getValue();
        }
    }
    /* Main method */
    public static void main(String[] args){
        new Main().show();
        
    }
}
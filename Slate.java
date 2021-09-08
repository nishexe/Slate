import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
public class Slate extends JComponent{
    private Image image;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY, brushSize = 5; //Default brush size is set to 5
    private Stroke line = new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    public Slate() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if (g2 != null) {
                    g2.setStroke(line);
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }
    /* Creates the canvas */
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(1920, 1080);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear(0xc2d647); //Default brush color(LIME)
        }
        g.drawImage(image, 0, 0, null);
    }
    /* Function to clear the canvas */
    public void clear(int hex) {
        g2.setPaint(new Color(0x0a0e14));
        g2.fillRect(0, 0, 1920, 1080);
        g2.setPaint(new Color(hex));
        repaint();
    }
    /* Methods to set the paint brush color */
    public void orange() {
        g2.setPaint(new Color(0xd85c14));
    }
    public void white() {
        g2.setPaint(Color.white);
    }
    public void yellow() {
        g2.setPaint(new Color(0xffb454));
    }
    public void lime() {
        g2.setPaint(new Color(0xc2d647));
    }
    public void blue() {
        g2.setPaint(new Color(0x87cefa));
    }
    public void wiper() {
        g2.setPaint(new Color(0x0a0e14));
    }
    /* Method to set the brush size from the slider value */
    public void setSize(int size){
        brushSize = size;
        line = new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
public class Slate extends JComponent {
    private Image image;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY;
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
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(1920, 1080);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }
    public void clear() {
        g2.setPaint(new Color(0x0a0e14));
        g2.fillRect(0, 0, 1920, 1080);
        g2.setPaint(new Color(0xc2d647));
        repaint();
    }
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
}
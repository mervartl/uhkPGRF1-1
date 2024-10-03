import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * trida pro kresleni na platno: zobrazeni pixelu
 *
 * @author PGRF FIM UHK
 * @version 2020
 */

public class Canvas {

    private JFrame frame;
    private JPanel panel;
    private BufferedImage img;

    private int currX;
    private int currY;

    public Canvas(int width, int height) {
        frame = new JFrame();

        frame.setLayout(new BorderLayout());
        frame.setTitle("UHK FIM PGRF : " + this.getClass().getName());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                present(g);
            }
        };

        panel.setPreferredSize(new Dimension(width, height));

        currX = img.getWidth()/2;
        currY = img.getHeight()/2;

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        currY--;
                        break;
                    case KeyEvent.VK_DOWN:
                        currY++;
                        break;
                    case KeyEvent.VK_RIGHT:
                        currX++;
                        break;
                    case KeyEvent.VK_LEFT:
                        currX--;
                        break;
                    case KeyEvent.VK_ENTER:
                        drawPixel(currX, currY, Color.RED.getRGB());
                        break;
                }
                frame.repaint();
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public void clear() {
        Graphics gr = img.getGraphics();
        gr.setColor(new Color(0x2f2f2f));
        gr.fillRect(0, 0, img.getWidth(), img.getHeight());
    }

    public void present(Graphics graphics) {
        graphics.drawImage(img, 0, 0, null);
    }

    public void draw() {
        clear();

        //img.setRGB(img.getWidth()/2, img.getHeight()/2, Color.RED.getRGB());


        /*for(int i = img.getWidth()/4; i < img.getWidth() - img.getWidth()/4; i++) {
            for(int j = img.getHeight()/4; j < img.getHeight() - img.getHeight()/4; j++) {
                img.setRGB(i,j, 0x0000FF);
            }
        }
        for(int i = 0; i < img.getWidth(); i++) {
            img.setRGB(i,i, 0x008000);
        }
        int j = img.getHeight()-1;
        for(int i = 0; i < img.getHeight(); i++) {
            img.setRGB(i,j--, 0x008000);
        }*/
    }

    public void drawPixel(int x, int y, int color) {
        img.setRGB(x, y, color);
    }


    public void start() {
        draw();
        panel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Canvas(800, 800).start());
    }

}

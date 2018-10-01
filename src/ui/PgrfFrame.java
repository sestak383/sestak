package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class PgrfFrame extends JFrame implements MouseMotionListener {

    static int FPS = 1000/60;
    private BufferedImage img; // pro vykreslovani
    static int width = 800;
    static int height = 600;
    private JPanel panel;

    public static void main(String... args) {
        PgrfFrame pgrfFrame = new PgrfFrame();
        pgrfFrame.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); // Prideleni ARGB barev
        pgrfFrame.init(width,height);
    }

    // Inicializace vykresleni
    private void init(int width, int height){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(width,height);
        setTitle("Počítačová grafika");

        panel = new JPanel();
        add(panel);

        setLocationRelativeTo(null);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        },  100, FPS);


        panel.addMouseMotionListener(this);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        draw();

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    // vykresleni
    private void draw(){
        img.getGraphics().fillRect(0,0,img.getWidth(),img.getHeight()); // prideleni pozadi
        for (int i = 0; i <100 ; i++) {
            img.setRGB(200 + i,200, Color.RED.getRGB()); // udela se cara
        }


        panel.getGraphics().drawImage(img, 0,0,img.getWidth(), img.getHeight(), null); // zde ji to vykresli
        panel.paintComponents(getGraphics());


    }

}

package calculadora;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;

public class Fotos extends JFrame implements Runnable {

    private JPanel panelMain;
    private JLabel label1;
    private ImageIcon img;
    private Icon icono;

    boolean jpg = false;
    boolean png = false;
    String ruta = "src/main/resources/Fotos";
    int segundos = 0;


    File file;
    File[] files;


    public Fotos() throws InterruptedException {
        super("Galería");
        setResizable(false);

        JMenuBar jmb = new JMenuBar();
        JMenu fotos = new JMenu("Fotos");

        file = new File(ruta);
        files = file.listFiles(getFileFilter(png,jpg));

        fotos.setMnemonic(KeyEvent.VK_F);
        JMenuItem jmi1 = new JMenuItem("Configuración");
        jmi1.setMnemonic(KeyEvent.VK_C);
        jmi1.addActionListener(e ->{
            new Configuracion(png, jpg, ruta, segundos);
            file = new File(ruta);
            files = file.listFiles(getFileFilter(png,jpg));
            System.out.println(files.length);
        });
        JMenuItem jme = new JMenuItem("Salir");
        jme.setMnemonic(KeyEvent.VK_S);
        jme.addActionListener(e -> {
            dispose();
        });


        fotos.add(jmi1);
        fotos.add(jme);

        jmb.add(fotos);
        setJMenuBar(jmb);

        setContentPane(this.panelMain);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);


    }

    public static void main(String[] args) throws InterruptedException {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
    private FileFilter getFileFilter(boolean png, boolean jpg) {
        return pathname -> {
            if (pathname.getName().endsWith(".png")) {
                return png;
            }
            else if (pathname.getName().endsWith(".jpg")) {
                return  jpg;
            }
            return false;
        };
    }
    @Override
    public void run() {
        for (File file : files) {
            if (file.getAbsolutePath().endsWith(".jpg")) {
                this.img = new ImageIcon(file.getAbsolutePath());
                this.icono = new ImageIcon(
                        this.img.getImage().getScaledInstance(640,480,0)
                );
                label1.setIcon(this.icono);
                this.repaint();
                try {
                    Thread.sleep(segundos*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }if (file.getAbsolutePath().endsWith(".png")) {
                this.img = new ImageIcon(file.getAbsolutePath());
                this.icono = new ImageIcon(
                        this.img.getImage().getScaledInstance(640,480,0)
                );
                label1.setIcon(this.icono);
                this.repaint();
                try {
                    Thread.sleep(segundos*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

package calculadora;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class Fotos extends JFrame{

    private JPanel panelMain;
    private JLabel label1;
    private ImageIcon img;
    private Icon icono;


    public Fotos() throws InterruptedException{
        super("Galería");
        setResizable(false);

        JMenuBar jmb = new JMenuBar();
        JMenu fotos = new JMenu("Fotos");

        fotos.setMnemonic(KeyEvent.VK_F);
        JMenuItem jmi1 = new JMenuItem("Abrir");
        jmi1.setMnemonic(KeyEvent.VK_A);
        jmi1.addActionListener(e ->{
            JFileChooser jfile = new JFileChooser();
            int resultado = jfile.showOpenDialog(this);

            if(resultado != JFileChooser.CANCEL_OPTION){
                File fileName = jfile.getSelectedFile();
                this.mostrarImg(label1,fileName.getAbsolutePath());
            }

        });
        JMenuItem jme = new JMenuItem("Salir");
        jme.setMnemonic(KeyEvent.VK_S);
        jme.addActionListener(e ->{
            dispose();
            new Utilidades();
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
    public void mostrarImg(JLabel label1, String ruta){
        label1.setIcon(null);
        this.img = new ImageIcon(ruta);
        this.icono = new ImageIcon(
               this.img.getImage().getScaledInstance(
                       label1.getWidth(),label1.getHeight(), Image.SCALE_DEFAULT)
        );
        label1.setIcon(this.icono);
        this.repaint();

    }
}

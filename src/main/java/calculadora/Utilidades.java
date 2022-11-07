package calculadora;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.KeyEvent;

public class Utilidades extends JFrame {

    private JPanel panel;
    private JLabel labelUtilidades;

    public Utilidades() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        setContentPane(this.panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        //Barra del menú
        JMenuBar jmb = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        archivo.setMnemonic(KeyEvent.VK_A);
        //Items Archivo
        JMenuItem jmi1 = new JMenuItem("Calculadora");
        JMenuItem jmi2 = new JMenuItem("Fotos");

        JMenuItem jme = new JMenuItem("Salir");
        KeyStroke keyStrokeExit = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.ALT_DOWN_MASK);
        jme.setMnemonic(KeyEvent.VK_S);
        jme.setAccelerator(keyStrokeExit);

        archivo.add(jmi1);
        archivo.add(jmi2);
        archivo.add(jme);


        jmb.add(archivo);
        setJMenuBar(jmb);

        pack();
        setVisible(true);

        jmi1.addActionListener(e ->{
           new Calculadora_Normal();

        });
        jmi2.addActionListener(e ->{
            try {
                new Fotos();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        jme.addActionListener(e ->{
            System.exit(0);
        });
    }
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new Utilidades();
    }
}

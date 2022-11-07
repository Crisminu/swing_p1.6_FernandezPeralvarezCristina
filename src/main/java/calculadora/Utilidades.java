package calculadora;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

    private JPanel panel;
    private JLabel labelUtilidades;

    public VentanaPrincipal() {
        setContentPane(this.panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Barra del menú
        JMenuBar jmb = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        archivo.setMnemonic(KeyEvent.VK_A);
        JMenu config = new JMenu("Configuración");

        JMenuItem jmi1 = new JMenuItem("Calculadora");
        JMenuItem jmi2 = new JMenuItem("Fotos");


        archivo.add(jmi1);
        archivo.add(jmi2);
        jmb.add(archivo);
        jmb.add(config);
        setJMenuBar(jmb);

        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        /*JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);*/
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new VentanaPrincipal();
    }
}

package calculadora;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Configuracion extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField rutaTxt;
    private JCheckBox JPGCheckBox;
    private JCheckBox PNGCheckBox;
    private JSpinner spinner1;
    private JButton abrirButton;

    boolean jpg = false;
    boolean png = false;
    String ruta = "";
    int segundos = 0;





    public Configuracion(boolean png, boolean jpg, String ruta, int segundos) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(250,215);
        setLocationRelativeTo(null);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        JPGCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        abrirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser("src/main/resources/Fotos");
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int valor = jfc.showOpenDialog(null);

                if(valor == jfc.APPROVE_OPTION){
                    File seleccionado = jfc.getSelectedFile();
                    rutaTxt.setText(seleccionado.getAbsolutePath());
                }
            }
        });
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void onOK() {
        // add your code here
        jpg = JPGCheckBox.isSelected();
        png = PNGCheckBox.isSelected();
        segundos = (int) spinner1.getValue();
        ruta = rutaTxt.getText();

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

   public static void main(String[] args) {
       try {
           UIManager.setLookAndFeel(new NimbusLookAndFeel());
       } catch (UnsupportedLookAndFeelException e) {
           throw new RuntimeException(e);
       }
    }
}

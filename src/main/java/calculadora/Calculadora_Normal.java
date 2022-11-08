package calculadora;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Calculadora_Normal extends JFrame{

    private JPanel MainPanel;
    private JTextField texto;
    private JButton button2;
    private JButton button1;
    private JButton button4;
    private JButton btnIgual;
    private JButton cButton2;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton cButton;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton button16;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton button20;

    double a,b, resultado;
    String op;
    public Calculadora_Normal() {
        setContentPane(this.MainPanel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        //Barra del menú
        JMenuBar jmb = new JMenuBar();
        JMenu menu = new JMenu("Calculadora");
        menu.setMnemonic(KeyEvent.VK_C);

        JMenuItem jmi1 = new JMenuItem("Calculadora normal");
        JMenuItem jmi2 = new JMenuItem("Calculadora cientifica");
        jmi1.setEnabled(false);
        jmi2.addActionListener(e -> {
            new Calculadora_Cientifica();
            dispose();
        });
        menu.add(jmi1);
        menu.add(jmi2);

        jmb.add(menu);
        setJMenuBar(jmb);

        cButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("");
            }
        });
        a1Button.addActionListener(e -> texto.setText(texto.getText()+a1Button.getText()));
        a2Button.addActionListener(e -> texto.setText(texto.getText()+a2Button.getText()));
        a3Button.addActionListener(e -> texto.setText(texto.getText()+a3Button.getText()));
        a4Button.addActionListener(e -> texto.setText(texto.getText()+a4Button.getText()));
        a5Button.addActionListener(e -> texto.setText(texto.getText()+a5Button.getText()));
        a6Button.addActionListener(e -> texto.setText(texto.getText()+a6Button.getText()));
        a7Button.addActionListener(e -> texto.setText(texto.getText()+a7Button.getText()));
        a8Button.addActionListener(e -> texto.setText(texto.getText()+a8Button.getText()));
        a9Button.addActionListener(e -> texto.setText(texto.getText()+a9Button.getText()));
        a0Button.addActionListener(e -> texto.setText(texto.getText()+a0Button.getText()));
        button20.addActionListener(e -> {
            if(!texto.getText().contains(",")){
                texto.setText(texto.getText()+button20.getText());
            }
        });
        button16.addActionListener(e -> {
            a = Double.parseDouble(texto.getText());
            op = "+";
            texto.setText("");
        });
        button2.addActionListener(e -> {
            a = Double.parseDouble(texto.getText());
            op = "-";
            texto.setText("");
        });
        button1.addActionListener(e -> {
            a = Double.parseDouble(texto.getText());
            op = "*";
            texto.setText("");
        });
        button4.addActionListener(e -> {
            a = Double.parseDouble(texto.getText());
            op = "/";
            texto.setText("");
        });
        cButton.addActionListener(e -> {
            String backspace = null;
            if(texto.getText().length() >0){
                StringBuilder strB = new StringBuilder(texto.getText());
                strB.deleteCharAt(texto.getText().length() - 1);
                backspace = String.valueOf(strB);
                texto.setText(backspace);
            }
        });
        btnIgual.addActionListener(e -> {
            b = Double.parseDouble(texto.getText());
            if(op == "+"){
                resultado = a+b;
                texto.setText(String.valueOf(resultado));
            } else if (op=="-") {
                resultado = a-b;
                texto.setText(String.valueOf(resultado));
            } else if (op=="*") {
                resultado = a*b;
                texto.setText(String.valueOf(resultado));
            } else if (op=="/") {
                resultado = a/b;
                texto.setText(String.valueOf(resultado));
            }
        });
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new Calculadora_Normal();
    }
}

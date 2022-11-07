package calculadora;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.Integer;


public class Calculadora_Cientifica extends JFrame{
    private JPanel MainPanel;
    private JTextField texto;
    private JButton ACButton;
    private JButton button2;
    private JButton button1;
    private JButton button4;
    private JButton btnIgual;
    private JButton cButton2;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a00Button;
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
    private JButton MasMenosButton;
    private JButton HEXButton;
    private JButton DECButton;
    private JButton OCTButton;
    private JButton BINButton;
    private JTextField txtHEX;
    private JButton ABtn;
    private JButton BBtn;
    private JButton CBtn;
    private JButton DBtn;
    private JButton EBtn;
    private JButton FBtn;
    private JButton Par1Button;
    private JButton Par2Button;
    private JTextField txtDEC;
    private JTextField txtOCT;
    private JTextField txtBIN;

    double a,b, resultado;
    String op;
    public Calculadora_Cientifica() {
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
        JMenuItem jmi2 = new JMenuItem("Calculadora científica");

        jmi2.setEnabled(false);
        jmi1.addActionListener(e ->{
            new Calculadora_Normal();
            dispose();
        });

        menu.add(jmi1);
        menu.add(jmi2);

        jmb.add(menu);
        setJMenuBar(jmb);

        cButton2.addActionListener(e -> texto.setText(""));
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
        a00Button.addActionListener(e -> texto.setText(texto.getText()+a00Button.getText()));
        ABtn.addActionListener(e -> texto.setText(texto.getText()+ABtn.getText()));
        BBtn.addActionListener(e -> texto.setText(texto.getText()+BBtn.getText()));
        CBtn.addActionListener(e -> texto.setText(texto.getText()+CBtn.getText()));
        DBtn.addActionListener(e -> texto.setText(texto.getText()+DBtn.getText()));
        EBtn.addActionListener(e -> texto.setText(texto.getText()+EBtn.getText()));
        FBtn.addActionListener(e -> texto.setText(texto.getText()+FBtn.getText()));

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


        DECButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String n = String.valueOf(texto.getText());
                    txtDEC.setText(n);
                    txtHEX.setText(Integer.toHexString(Integer.parseInt(n)).toUpperCase());
                    txtOCT.setText(Integer.toOctalString(Integer.parseInt(n)).toUpperCase());
                    txtBIN.setText(Integer.toBinaryString(Integer.parseInt(n)).toUpperCase());
                }

        });
        HEXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = String.valueOf(texto.getText());
                txtHEX.setText(n);
                txtOCT.setText(Integer.toOctalString(Integer.parseInt(n)).toUpperCase());
                txtBIN.setText(Integer.toBinaryString(Integer.parseInt(n)).toUpperCase());
            }
        });
        OCTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = String.valueOf(texto.getText());

                txtHEX.setText(Integer.toHexString(Integer.parseInt(n)).toUpperCase());
                txtOCT.setText(n);
                txtBIN.setText(Integer.toBinaryString(Integer.parseInt(n)).toUpperCase());
            }
        });
        BINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = String.valueOf(texto.getText());

                txtHEX.setText(Integer.toHexString(Integer.parseInt(n)).toUpperCase());
                txtOCT.setText(Integer.toOctalString(Integer.parseInt(n)).toUpperCase());
                txtBIN.setText(n);
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new Calculadora_Cientifica();
    }

}

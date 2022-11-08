package calculadora;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


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
    private JTextField txtDEC;
    private JButton ABtn;
    private JButton BBtn;
    private JButton CBtn;
    private JButton DBtn;
    private JButton EBtn;
    private JButton FBtn;
    private JButton Par1Button;
    private JButton Par2Button;
    private JTextField txtHexa;
    private JTextField txtOCT;
    private JTextField txtBIN;
    private JRadioButton decimalRadioButton;
    private JRadioButton hexadecimalRadioButton;
    private JRadioButton octalRadioButton;
    private JRadioButton binarioRadioButton;

    String sisNum;

    double a,b, resultado;
    String op;
    public Calculadora_Cientifica() {
        setContentPane(this.MainPanel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        decimalRadioButton.setSelected(true);
        ABtn.setEnabled(false);
        BBtn.setEnabled(false);
        CBtn.setEnabled(false);
        DBtn.setEnabled(false);
        EBtn.setEnabled(false);
        FBtn.setEnabled(false);
        a1Button.setEnabled(true);
        a2Button.setEnabled(true);
        a3Button.setEnabled(true);
        a4Button.setEnabled(true);
        a5Button.setEnabled(true);
        a6Button.setEnabled(true);
        a7Button.setEnabled(true);
        a8Button.setEnabled(true);
        a9Button.setEnabled(true);
        a0Button.setEnabled(true);
        sisNum = "decimal";
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
            if(sisNum.equalsIgnoreCase("decimal")){
                int num = Integer.parseInt(texto.getText());
                txtDEC.setText(String.valueOf(num));
                txtHexa.setText(Integer.toHexString(num));
                txtOCT.setText(Integer.toOctalString(num));
                txtBIN.setText(Integer.toBinaryString(num));
            }else if(sisNum.equalsIgnoreCase("hexadecimal")){
                txtDEC.setText(String.valueOf(convertirHexadecimalDecimal(texto.getText())));
                txtHexa.setText(texto.getText());
                int num= convertirHexadecimalDecimal(texto.getText());
                txtOCT.setText(Integer.toOctalString(num));
                txtBIN.setText(Integer.toBinaryString(num));
            }else if(sisNum.equalsIgnoreCase("octal")){
                txtDEC.setText(String.valueOf(octalADecimal(Integer.parseInt(texto.getText()))));
                int num = octalADecimal(Integer.parseInt(texto.getText()));
                txtHexa.setText(Integer.toHexString(num));
                txtOCT.setText(texto.getText());
                txtBIN.setText(Integer.toBinaryString(num));
            }else if(sisNum.equalsIgnoreCase("binario")){
                txtDEC.setText(String.valueOf(binarioADecimal(Integer.parseInt(texto.getText()))));
                int num = binarioADecimal(Integer.parseInt(texto.getText()));
                txtHexa.setText(Integer.toHexString(num));
                txtOCT.setText(Integer.toOctalString(num));
                txtBIN.setText(texto.getText());
            }


        });
        pack();
        setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(decimalRadioButton);
        group.add(hexadecimalRadioButton);
        group.add(octalRadioButton);
        group.add(binarioRadioButton);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String base = e.getActionCommand();
                switch(base){
                    case "Decimal":
                        ABtn.setEnabled(false);
                        BBtn.setEnabled(false);
                        CBtn.setEnabled(false);
                        DBtn.setEnabled(false);
                        EBtn.setEnabled(false);
                        FBtn.setEnabled(false);
                        a1Button.setEnabled(true);
                        a2Button.setEnabled(true);
                        a3Button.setEnabled(true);
                        a4Button.setEnabled(true);
                        a5Button.setEnabled(true);
                        a6Button.setEnabled(true);
                        a7Button.setEnabled(true);
                        a8Button.setEnabled(true);
                        a9Button.setEnabled(true);
                        a0Button.setEnabled(true);
                        sisNum = "decimal";
                        break;


                    case "Hexadecimal":
                        ABtn.setEnabled(true);
                        BBtn.setEnabled(true);
                        CBtn.setEnabled(true);
                        DBtn.setEnabled(true);
                        EBtn.setEnabled(true);
                        FBtn.setEnabled(true);
                        a1Button.setEnabled(true);
                        a2Button.setEnabled(true);
                        a3Button.setEnabled(true);
                        a4Button.setEnabled(true);
                        a5Button.setEnabled(true);
                        a6Button.setEnabled(true);
                        a7Button.setEnabled(true);
                        a8Button.setEnabled(true);
                        a9Button.setEnabled(true);
                        a0Button.setEnabled(true);
                        sisNum = "hexadecimal";
                    break;
                    case "Octal":
                        ABtn.setEnabled(false);
                        BBtn.setEnabled(false);
                        CBtn.setEnabled(false);
                        DBtn.setEnabled(false);
                        EBtn.setEnabled(false);
                        FBtn.setEnabled(false);
                        a1Button.setEnabled(true);
                        a2Button.setEnabled(true);
                        a3Button.setEnabled(true);
                        a4Button.setEnabled(true);
                        a5Button.setEnabled(true);
                        a6Button.setEnabled(true);
                        a7Button.setEnabled(true);
                        a8Button.setEnabled(false);
                        a9Button.setEnabled(false);
                        a0Button.setEnabled(true);
                        sisNum = "octal";
                        break;

                    case "Binario":
                        ABtn.setEnabled(false);
                        BBtn.setEnabled(false);
                        CBtn.setEnabled(false);
                        DBtn.setEnabled(false);
                        EBtn.setEnabled(false);
                        FBtn.setEnabled(false);
                        a1Button.setEnabled(true);
                        a2Button.setEnabled(false);
                        a3Button.setEnabled(false);
                        a4Button.setEnabled(false);
                        a5Button.setEnabled(false);
                        a6Button.setEnabled(false);
                        a7Button.setEnabled(false);
                        a8Button.setEnabled(false);
                        a9Button.setEnabled(false);
                        a0Button.setEnabled(true);
                        sisNum = "binario";
                        break;


                }
            }
        };
        decimalRadioButton.addActionListener(listener);
        hexadecimalRadioButton.addActionListener(listener);
        octalRadioButton.addActionListener(listener);
        binarioRadioButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new Calculadora_Cientifica();
    }
    //CONVERSORES OTRAS BASES A DECIMAL
    public static int convertirHexadecimalDecimal(String num){
        final String DIGITOS = "0123456789ABCDEF";
        num = num.toUpperCase();

        int decimal = 0;

        for (int i = 0; i < num.length(); i++){
            char caracter = num.charAt(i);
            int digito = DIGITOS.indexOf(caracter);
            decimal = 16 * decimal + digito;
        }
        return decimal;
    }
    public static int binarioADecimal(int binario) {
        int decimal = 0;
        int potencia = 0;
        // Ciclo infinito hasta que binario sea 0
        while (true) {
            if (binario == 0) {
                break;
            } else {
                int temp = binario % 10;
                decimal += temp * Math.pow(2, potencia);
                binario = binario / 10;
                potencia++;
            }
        }
        return decimal;
    }
    public static int octalADecimal(int octal) {
        int decimal = 0;
        int potencia = 0;
        // Ciclo infinito que se rompe cuando octal es 0
        while (true) {
            if (octal == 0) {
                break;
            } else {
                int temp = octal % 10;
                decimal += temp * Math.pow(8, potencia);
                octal = octal / 10;
                potencia++;
            }
        }
        return decimal;
    }

}

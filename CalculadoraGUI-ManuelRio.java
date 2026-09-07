package calculadoragui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraGUI extends JFrame {

    JTextField txtNum1, txtNum2, txtResultado;
    JComboBox<String> cmbOperacion;

    public CalculadoraGUI() {
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Número 1:"));
        txtNum1 = new JTextField();
        add(txtNum1);

        add(new JLabel("Número 2:"));
        txtNum2 = new JTextField();
        add(txtNum2);

        add(new JLabel("Operación:"));
        cmbOperacion = new JComboBox<>(new String[]{"Suma", "Resta", "Multiplicación", "División", "Raíz Cuadrada"});
        add(cmbOperacion);

        add(new JLabel("Resultado:"));
        txtResultado = new JTextField();
        txtResultado.setEditable(false);
        add(txtResultado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(e -> calcular());
        add(new JLabel());
        add(btnCalcular);

        setSize(320, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void calcular() {
        try {
            double n1 = Double.parseDouble(txtNum1.getText());
            double resultado;

            if (cmbOperacion.getSelectedIndex() == 4) {
                if (n1 < 0) { JOptionPane.showMessageDialog(this, "No se puede calcular raíz de número negativo."); return; }
                resultado = Math.sqrt(n1);
            } else {
                double n2 = Double.parseDouble(txtNum2.getText());
                switch (cmbOperacion.getSelectedIndex()) {
                    case 0: resultado = n1 + n2; break;
                    case 1: resultado = n1 - n2; break;
                    case 2: resultado = n1 * n2; break;
                    default:
                        if (n2 == 0) { JOptionPane.showMessageDialog(this, "No se puede dividir entre cero."); return; }
                        resultado = n1 / n2;
                }
            }
            txtResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
        }
    }

    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}

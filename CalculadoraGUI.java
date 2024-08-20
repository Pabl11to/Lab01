import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener {

    private JTextField display;
    private String operador;
    private double resultado;
    private boolean nuevoNumero;

    public CalculadoraGUI() {
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        String[] botones = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sin", "cos", "tan", "√", "x^y", "IVA"
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.PLAIN, 18));
            boton.addActionListener(this);
            panel.add(boton);
        }

        add(panel, BorderLayout.CENTER);

        operador = "";
        resultado = 0;
        nuevoNumero = true;

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        try {
            if (comando.matches("[0-9.]")) {
                if (nuevoNumero) {
                    display.setText(comando);
                    nuevoNumero = false;
                } else {
                    display.setText(display.getText() + comando);
                }
            } else if (comando.equals("=")) {
                calcular(Double.parseDouble(display.getText()));
                operador = "";
                nuevoNumero = true;
                display.setText(String.valueOf(resultado));
            } else if (comando.equals("sin") || comando.equals("cos") || comando.equals("tan") || comando.equals("√")) {
                calcularFuncion(comando);
                operador = "";
                nuevoNumero = true;
            } else if (comando.equals("x^y") || comando.equals("IVA")) {
                operador = comando;
                resultado = Double.parseDouble(display.getText());
                nuevoNumero = true;
            } else {
                calcular(Double.parseDouble(display.getText()));
                operador = comando;
                nuevoNumero = true;
            }
        } catch (NumberFormatException ex) {
            display.setText("Error");
        } catch (ArithmeticException ex) {
            display.setText("Math Error");
        }
    }

    private void calcular(double valor) {
        switch (operador) {
            case "":
                resultado = valor;
                break;
            case "+":
                resultado += valor;
                break;
            case "-":
                resultado -= valor;
                break;
            case "*":
                resultado *= valor;
                break;
            case "/":
                if (valor == 0) {
                    throw new ArithmeticException("División por cero");
                }
                resultado /= valor;
                break;
            case "x^y":
                resultado = Math.pow(resultado, valor);
                if (Double.isNaN(resultado)) {
                    throw new ArithmeticException("Resultado imaginario");
                }
                break;
            case "IVA":
                resultado += resultado * valor / 100;
                break;
        }
    }

    private void calcularFuncion(String funcion) {
        double valor = Double.parseDouble(display.getText());
        switch (funcion) {
            case "sin":
                resultado = Math.sin(valor);
                break;
            case "cos":
                resultado = Math.cos(valor);
                break;
            case "tan":
                resultado = Math.tan(valor);
                if (Double.isInfinite(resultado) || Double.isNaN(resultado)) {
                    throw new ArithmeticException("Tangente indefinida");
                }
                break;
            case "√":
                if (valor < 0) {
                    throw new ArithmeticException("Resultado imaginario");
                }
                resultado = Math.sqrt(valor);
                break;
        }
        display.setText(String.valueOf(resultado));
    }
}

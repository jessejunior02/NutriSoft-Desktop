package views;

import javax.swing.*;
import controllers.MainController;

/**
 *
 * @author jessejunior
 */
public class IMCFrame extends JFrame {
    private static final long serialVersionUID = 1L;

	// Controlador
    private final MainController controller = new MainController();

    // Componentes da Interface
    private JTextField txtAlturaField;
    private JTextField txtPesoField;
    private JLabel lblResultado;
    private JLabel lblAnalise;

    public IMCFrame() {
        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setTitle("NutriSoft - IMC");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    private void inicializarComponentes() {
        // Painel de Entrada
        JPanel inputPanel = criarPainelEntrada();

        // Painel de Resultados
        JPanel resultPanel = criarPainelResultado();

        // Adicionar os paineis a janela
        add(inputPanel);
        add(resultPanel);
    }

    private JPanel criarPainelEntrada() {
        JPanel inputPanel = new JPanel(null);
        inputPanel.setBounds(20, 20, 350, 200);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Cálculo de IMC"));

        JLabel lblAltura = new JLabel("Altura (cm):");
        lblAltura.setBounds(50, 55, 150, 20);
        txtAlturaField = new JTextField();
        txtAlturaField.setBounds(150, 55, 150, 20);

        JLabel lblPeso = new JLabel("Peso (Kg):");
        lblPeso.setBounds(50, 85, 150, 20);
        txtPesoField = new JTextField();
        txtPesoField.setBounds(150, 85, 150, 20);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 120, 100, 30);

        // Ação do botão
        btnCalcular.addActionListener(e -> calcularIMC());

        inputPanel.add(lblAltura);
        inputPanel.add(txtAlturaField);
        inputPanel.add(lblPeso);
        inputPanel.add(txtPesoField);
        inputPanel.add(btnCalcular);

        return inputPanel;
    }

    private JPanel criarPainelResultado() {
        JPanel resultPanel = new JPanel(null);
        resultPanel.setBounds(20, 230, 350, 150);
        resultPanel.setBorder(BorderFactory.createTitledBorder("Resultados"));

        lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(20, 30, 300, 20);

        lblAnalise = new JLabel("Análise:");
        lblAnalise.setBounds(20, 60, 300, 20);

        resultPanel.add(lblResultado);
        resultPanel.add(lblAnalise);

        return resultPanel;
    }

    private void calcularIMC() {
        try {
            double altura = Double.parseDouble(txtAlturaField.getText());
            double peso = Double.parseDouble(txtPesoField.getText());

            if (altura <= 0 || peso <= 0) {
                throw new NumberFormatException("Valores inválidos.");
            }

            // Calcular e exibir os resultados
            double imc = controller.calcularIMC(peso, altura);
            
            lblResultado.setText(String.format("Resultado: %.2f", imc));
            lblAnalise.setText("Análise: " + controller.analisarIMC(imc));
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preencha os campos corretamente (valores positivos).", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
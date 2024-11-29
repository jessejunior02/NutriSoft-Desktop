package views;

import javax.swing.*;
import controllers.MainController;

/**
 *
 * @author jessejunior
 */
public class GastoCaloricoFrame extends JFrame{
    private static final long serialVersionUID = 1L;

	// Controlador
    private final MainController controller = new MainController();

    // Componentes da Interface
    private JRadioButton homemButton;
    private JRadioButton mulherButton;
    private JTextField txtPesoField;
    private JTextField txtAlturaField;
    private JTextField txtIdadeField;
    private JComboBox<String> nivelAtividadeComboBox;
    private JLabel lblGastoBasal;
    private JLabel lblGastoTotal;


    public GastoCaloricoFrame() {
        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setTitle("NutriSoft - Gasto Calórico");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }


    private void inicializarComponentes() {
        // Painel de Entrada
        JPanel inputPanel = criarPainelEntrada();

        // Painel de Saída
        JPanel resultPanel = criarPainelResultado();

        // Adicionar os paineis a janela
        add(inputPanel);
        add(resultPanel);
    }


    private JPanel criarPainelEntrada() {
        JPanel inputPanel = new JPanel(null);
        inputPanel.setBounds(20, 20, 350, 250);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Cálculo de Gasto Calórico"));

        homemButton = new JRadioButton("Homem");
        homemButton.setBounds(15, 30, 100, 10);
        mulherButton = new JRadioButton("Mulher");
        mulherButton.setBounds(175, 30, 100, 10);
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(homemButton);
        sexoGroup.add(mulherButton);

        JLabel lblPeso = new JLabel("Peso (Kg):");
        lblPeso.setBounds(20, 60, 100, 20);
        txtPesoField = new JTextField();
        txtPesoField.setBounds(180, 60, 150, 20);

        JLabel lblAltura = new JLabel("Altura (cm):");
        lblAltura.setBounds(20, 90, 100, 20);
        txtAlturaField = new JTextField();
        txtAlturaField.setBounds(180, 90, 150, 20);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(20, 120, 100, 20);
        txtIdadeField = new JTextField();
        txtIdadeField.setBounds(180, 120, 150, 20);

        JLabel lblAtividade = new JLabel("Nível de Atividade:");
        lblAtividade.setBounds(20, 150, 150, 20);
        nivelAtividadeComboBox = new JComboBox<>(new String[] {
            "Sedentário",
            "Leve",
            "Moderado",
            "Ativo",
            "Extremamente Ativo"
        });
        nivelAtividadeComboBox.setBounds(180, 150, 150, 20);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 190, 130, 30);


        // Ação do botão
        btnCalcular.addActionListener(e -> calcularGastoCalorico());


        inputPanel.add(homemButton);
        inputPanel.add(mulherButton);
        inputPanel.add(lblPeso);
        inputPanel.add(txtPesoField);
        inputPanel.add(lblAltura);
        inputPanel.add(txtAlturaField);
        inputPanel.add(lblIdade);
        inputPanel.add(txtIdadeField);
        inputPanel.add(lblAtividade);
        inputPanel.add(nivelAtividadeComboBox);
        inputPanel.add(btnCalcular);

        return inputPanel;
    }

    private JPanel criarPainelResultado() {
        JPanel resultPanel = new JPanel(null);
        resultPanel.setBounds(20, 280, 350, 120);
        resultPanel.setBorder(BorderFactory.createTitledBorder("Resultados"));

        lblGastoBasal = new JLabel("Gasto Basal:");
        lblGastoBasal.setBounds(20, 35, 200, 20);

        lblGastoTotal = new JLabel("Gasto Total:");
        lblGastoTotal.setBounds(20, 70, 200, 20);


        resultPanel.add(lblGastoBasal);
        resultPanel.add(lblGastoTotal);

        return resultPanel;
    }

    private void calcularGastoCalorico() {
        try {
            // Validação do select sexo
            if (!homemButton.isSelected() && !mulherButton.isSelected()) {
                JOptionPane.showMessageDialog(this, "Selecione o sexo.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Recuperar valores
            String sexo = homemButton.isSelected() ? "Homem" : "Mulher";
            double peso = Double.parseDouble(txtPesoField.getText());
            double altura = Double.parseDouble(txtAlturaField.getText());
            int idade = Integer.parseInt(txtIdadeField.getText());

            String nivelAtividade = (String) nivelAtividadeComboBox.getSelectedItem(); // Feito um casting explicito de Object pra String
            if (nivelAtividade == null || nivelAtividade.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecione o nível de atividade", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Realização do calculo
            double gastoBasal = controller.calcularGastoBasal(sexo, peso, altura, idade);
            double gastoTotal = controller.calcularGastoTotal(gastoBasal, nivelAtividade);

            // Exibir os resultados
            lblGastoBasal.setText(String.format("Gasto Basal: %.2f", gastoBasal));
            lblGastoTotal.setText(String.format("Gasto Total: %.2f", gastoTotal));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos com valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

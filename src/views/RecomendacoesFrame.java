package views;

/**
*
* @author jessejunior
*/
import javax.swing.*;
import controllers.MainController;

/**
*
* @author jessejunior
*/
public class RecomendacoesFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// Controlador
	private final MainController controller = new MainController();
	
	// Componentes da Interface
	private JTextField txtCaloriasField;
	private JLabel lblCarboidratos;
	private JLabel lblProteina;
	private JLabel lblGordura;
	
	public RecomendacoesFrame() {
		configurarJanela();
		incializarComponentes();
	}
	
	private void configurarJanela() {
		setTitle("NutriSoft - IMC");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
	}
	
	 private void incializarComponentes() {
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
		inputPanel.setBounds(20, 20, 350, 150);
		inputPanel.setBorder(BorderFactory.createTitledBorder("Recomendações"));
	
		JLabel lblCalorias = new JLabel("Calorias diárias (Kcal):");
		lblCalorias.setBounds(25, 35, 150, 20);
		txtCaloriasField = new JTextField();
		txtCaloriasField.setBounds(180, 35, 150, 20);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(230, 70, 100, 30);
		
		// Ação do botão
		btnCalcular.addActionListener(e -> calcularNutrientes());
		
		inputPanel.add(lblCalorias);
		inputPanel.add(txtCaloriasField);
		inputPanel.add(btnCalcular);
		
		return inputPanel;
	}
	
	private JPanel criarPainelResultado() {
		JPanel resultPanel = new JPanel(null);
		resultPanel.setBounds(20, 180, 350, 150);
		resultPanel.setBorder(BorderFactory.createTitledBorder("Resultados"));
		
		lblCarboidratos = new JLabel("Carboidratos:");
		lblCarboidratos.setBounds(25, 35, 150, 20);
		
		lblProteina = new JLabel("Proteína:");
		lblProteina.setBounds(25, 70, 150, 20);
		
		lblGordura = new JLabel("Gordura:");
		lblGordura.setBounds(25, 105, 150, 20);
		
		
		resultPanel.add(lblCarboidratos);
		resultPanel.add(lblProteina);
		resultPanel.add(lblGordura);
		
		return resultPanel;
	}
	
	private void calcularNutrientes() {
		try {
			double calorias = Double.parseDouble(txtCaloriasField.getText());
			
			if (calorias < 0) {
				throw new NumberFormatException("Valores inválidos.");
			}
			
			// Calcular e exibir os resultados
			double carboidratos = controller.calcularCarboidratos(calorias);
			double proteina = controller.calcularProteina(calorias);
			double gordura = controller.calcularGordura(calorias);
			
			lblCarboidratos.setText(String.format("Carboidratos: %.2f", carboidratos));
			lblProteina.setText(String.format("Proteína: %.2f", proteina));
			lblGordura.setText(String.format("Gordura: %.2f", gordura));
			
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Preencha os campos corretamente. \n Caso for colocar número real, utilize \".\" ao invés de \",\" ", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}

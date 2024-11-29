package views;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jessejunior
 */
public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

	public MainFrame() {
        // Configurações da Janela
        setTitle("NutriSoft - Menu");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(3, 1));

        // Componentes
        JButton btnImc = new JButton("IMC");
        JButton btnGastoCalorico = new JButton("Gasto Calórico");
        JButton btnRecomendacoes = new JButton("Recomendações");

        // Ações dos botões
        btnImc.addActionListener(e -> {
            IMCFrame imcFrame = new IMCFrame();
            imcFrame.setVisible(true);
        });

        btnGastoCalorico.addActionListener(e -> {
            GastoCaloricoFrame gastoCaloricoFrame = new GastoCaloricoFrame();
            gastoCaloricoFrame.setVisible(true);
        });
        
        btnRecomendacoes.addActionListener(e -> {
        	RecomendacoesFrame recomendacoesFrame = new RecomendacoesFrame();
        	recomendacoesFrame.setVisible(true);
        });

        // Adicione os componentes a janela
        add(btnImc);
        add(btnGastoCalorico);
        add(btnRecomendacoes);

        // Exibir a janela para o usuário
        setVisible(true);
    }
}
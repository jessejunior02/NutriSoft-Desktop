package controllers;

import models.IMCModel;
import models.GastoCaloricoModel;
import models.RecomendacoesModel;

/**
 *
 * @author jessejunior
 */
public class MainController {
	// IMC
    public double calcularIMC(double peso, double altura) {
        double alturaMetros = altura / 100;
        return IMCModel.calcularIMC(peso, alturaMetros);
    }

    public String analisarIMC(double imc) {
        return IMCModel.analisarIMC(imc);
    }

    // Gasto Calórico
    public double calcularGastoBasal(String sexo, double peso, double altura, int idade) {
        return GastoCaloricoModel.calcularGastoBasal(sexo, peso, altura, idade);
    }

    public double calcularGastoTotal(double gastoBasal, String nivelAtividade) {
        return GastoCaloricoModel.calcularGastoBasalTotal(gastoBasal, nivelAtividade);
    }
    
    // Recomendações
    public double calcularCarboidratos(double calorias) {
    	return RecomendacoesModel.calcularCarboidratos(calorias);
    }
    
    public double calcularProteina(double calorias) {
    	return RecomendacoesModel.calcularProteina(calorias);
    }
    
    public double calcularGordura(double calorias) {
    	return RecomendacoesModel.calcularGordura(calorias);
    }
}
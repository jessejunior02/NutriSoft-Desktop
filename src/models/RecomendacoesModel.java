package models;

/**
*
* @author jessejunior
*/
public class RecomendacoesModel {
	public static double calcularCarboidratos(double calorias) {
		return calorias * 0.5 / 4;
	}
	
	public static double calcularProteina(double calorias) {
		return calorias * 0.25 / 4;
	}
	
	public static double calcularGordura(double calorias) {
		return calorias * 0.25 / 9;
	}
}

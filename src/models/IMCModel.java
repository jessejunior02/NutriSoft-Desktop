package models;

import static java.lang.Math.pow;

/**
 *
 * @author jessejunior
 */
public class IMCModel {
    public static double calcularIMC(double peso, double altura) {
        return peso / pow(altura, 2);
    }

    public static String analisarIMC(double imc) {
        if (imc < 18.5) {
            return "Magreza";
        } else if (imc < 25) {
            return "Normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 40) {
            return "Obesidade";
        } else {
            return "Obesidade grave";
        }
    }
}
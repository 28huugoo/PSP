/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorial;

/**
 *
 * @author FP
 */
public class Principal {

    public static double sumatorioCompartido(double numero) {
        double acumulador = 0;
        for (int i = 1; i <= numero; i++) {
            acumulador += i;
        }
        return acumulador;
    }

    public static void main(String[] args) {
        double formula;
        //formula = (sumatorio(5) + sumatorio(8) + sumatorio(20) / (3 * sumatorio(5)));
        //System.out.println("Fórmula = " + formula);
        double abajo = 3 * sumatorio(5);
        hilo.start();
    }
}

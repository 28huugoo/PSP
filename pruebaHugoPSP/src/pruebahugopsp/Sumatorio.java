/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebahugopsp;

/**
 *
 * @author FP
 */
public class Sumatorio extends Thread {

    private int numero;
    private double resultado;

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public Sumatorio(int numero) {
        this.numero = numero;
    }

    public double sumaImpar() {
        if (numero % 2 == 0) {
            numero = numero - 1;
        }
        double total = 0;
        for (double i = numero; i >= 1; i = i - 2) {
            total = total +i;
        }
        return total;
    }

    public double calculoImpar() {
        if (numero % 2 == 0) {
            numero = numero - 1;
        }
        double total = 0;
        for (int i = (int) numero; i >= 1; i = i-2) {
            total = total + 1;
        }
        return total;
    }

    @Override
    public void run() {
        resultado = calculoImpar();
    }

}

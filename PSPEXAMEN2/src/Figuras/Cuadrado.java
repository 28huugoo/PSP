/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Figuras;

import java.util.logging.Logger;

/**
 *
 * @author FP
 */
public class Cuadrado {

    double lado;

    public Cuadrado() {
        super();
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double calPerCuadrado(double lado) {
        double perCuadrado = lado * 4;
        return perCuadrado;
    }

    public double calAreaCuadrado(double lado) {
        double areaCuadrado = lado * lado;
        return areaCuadrado;
    }
}

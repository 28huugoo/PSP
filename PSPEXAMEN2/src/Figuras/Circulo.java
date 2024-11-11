/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Figuras;

/**
 *
 * @author FP
 */
public class Circulo {

    double radio;

    public Circulo() {
        super();
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calPerCirculo(double radio) {
        double perCirculo = 2 * Math.PI * radio;
        return perCirculo;
    }

    public double calAreaCirculo(double radio) {
        double areaCirculo = Math.PI * (radio * radio);
        return areaCirculo;
    }
}

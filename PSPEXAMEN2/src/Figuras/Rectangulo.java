/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Figuras;

/**
 *
 * @author FP
 */
public class Rectangulo {

    double base;
    double altura;

    public Rectangulo() {
        super();
    }

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calPerRectangulo(double base, double altura) {
        double perRectangulo = (altura * 2) + (base * 2);
        return perRectangulo;
    }

    public double calAreaRectangulo(double base, double altura) {
        double areaRectangulo = base * altura;
        return areaRectangulo;
    }
}

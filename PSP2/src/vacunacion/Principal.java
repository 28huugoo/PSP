/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vacunacion;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) {
        ListaPaciente lista1 = new ListaPaciente("pm1", new int[]{3, 6, 10, 1, 5});
        ListaPaciente lista2 = new ListaPaciente("pm1", new int[]{3, 6, 10, 1, 5});

        Enfermero enf1 = new Enfermero("Santino");
        Enfermero enf2 = new Enfermero("Mark");

        long inicio = System.currentTimeMillis();

        enf1.vacunar(lista1, inicio);
        enf2.vacunar(lista2, inicio);
    }
}

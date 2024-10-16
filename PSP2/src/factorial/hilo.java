/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorial;

/**
 *
 * @author FP
 */
public class hilo extends Thread {

    @Override
    public void run() {
                double acumulador = 0;
        for (int i = 1; i <= numero; i++) {
            acumulador += i;
        }
        Principal.sumatorioCompartido = 838;
    }

}

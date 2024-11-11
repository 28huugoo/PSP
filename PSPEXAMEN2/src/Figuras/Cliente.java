/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Figuras;

import TCPObjetos.Persona;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class Cliente implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 6000; //puertoRemoto
        System.out.println("PROGRAMA CLIENTE INICIADO...");
        Socket cliente = new Socket(host, puerto);

        Scanner teclado = new Scanner(System.in);

        System.out.println("ELIGE QUE QUIERES INTRODUCIR CABALLERO (pon número del 1 al 3):");
        System.out.println("1. CIRCULO");
        System.out.println("2. CUADRADO");
        System.out.println("3. RECTÁNGULO");
        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1:
                ObjectOutputStream objCir = new ObjectOutputStream(cliente.getOutputStream());
                Circulo circulo = new Circulo();
                System.out.println("Cuanto mide el radio caballero?");
                int radio = teclado.nextInt();
                circulo.setRadio(radio);

                objCir.writeObject(circulo);
                System.out.println("Enviando un círculo de radio: " + radio);

                objCir.close();
                break;

            case 2:
                ObjectOutputStream objCuad = new ObjectOutputStream(cliente.getOutputStream());
                Cuadrado cuadrado = new Cuadrado();
                System.out.println("Cuanto mide el lado caballero?");
                int lado = teclado.nextInt();
                cuadrado.setLado(lado);

                objCuad.writeObject(cuadrado);
                System.out.println("Enviando un cuadrado de lado: " + lado);

                objCuad.close();
                break;

            case 3:
                ObjectOutputStream objRect = new ObjectOutputStream(cliente.getOutputStream());
                
                Rectangulo rectangulo = new Rectangulo();
                
                System.out.println("Cuanto mide la base caballero?");
                int base = teclado.nextInt();

                System.out.println("Cuanto mide la altura caballero?");
                int altura = teclado.nextInt();
                
                rectangulo.setAltura(altura);
                rectangulo.setBase(base);

                objRect.writeObject(rectangulo);
                System.out.println("Enviando un cuadrado de base: " + base + " y altura: " + altura);

                objRect.close();
                break;

        }
        cliente.close();
    }
}

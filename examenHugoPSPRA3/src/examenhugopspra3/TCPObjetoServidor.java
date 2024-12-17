/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenhugopspra3;

import static examenhugopspra3.HashMD5.calculaHashAlgoritmo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class TCPObjetoServidor {

    public static void main(String[] args) {
        int numeroPuerto = 6000;

        try (ServerSocket servidor = new ServerSocket(numeroPuerto)) {
            System.out.println("Servidor iniciado y esperando conexion...");

            try (Socket cliente = servidor.accept(); ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream()); ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream())) {

                System.out.println("Cliente conectado.");

                Object objetoRecibido = inObjeto.readObject();

                String texto = "";
                String hash = "";

                if (objetoRecibido instanceof HashMD5 textoMD5) {
                    outObjeto.writeUTF("El hash es: " + calculaHashAlgoritmo(texto, "MD5"));
                } else if (objetoRecibido instanceof HashSHA1 textoSHA1) {
                    outObjeto.writeUTF("El hash es: " + calculaHashAlgoritmo(texto, "SHA1"));
                } else if (objetoRecibido instanceof HashSHA1 textoSHA512) {
                    outObjeto.writeUTF("El hash es: " + calculaHashAlgoritmo(texto, "SHA512"));
                }
                /*else if (objetoRecibido instanceof Cuadrado cuadrado) {
                    area = cuadrado.calcularArea();
                    perimetro = cuadrado.calcularPerimetro();
                    System.out.println("Recibido un Cuadrado con lado: " + cuadrado.getLado());

                } else if (objetoRecibido instanceof Rectangulo rectangulo) {
                    area = rectangulo.calcularArea();
                    perimetro = rectangulo.calcularPerimetro();
                    System.out.println("Recibido un Rect�ngulo con largo: " + rectangulo.getLadoLargo() + " y ancho: " + rectangulo.getLadoCorto());
                }
                 */

                outObjeto.writeUTF(texto);
                outObjeto.writeUTF(hash);
                //  outObjeto.reset();
                System.out.println("Datos enviados al cliente");

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenhugopspra3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class TCPObjetoCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String host = "localhost";
        int puerto = 6000;

        System.out.println("Programa cliente iniciando");

        try (Socket cliente = new Socket(host, puerto); ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream()); ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream())) {

            HashMD5 textoMD5 = new HashMD5("DAMIAAAAAAN APRUEBAME");
            HashSHA1 textoSHA1 = new HashSHA1("DAMIAAAAAAN APRUEBAME");
            HashSHA512 textoSHA512 = new HashSHA512("DAMIAAAAAAN APRUEBAME");
            
            outObjeto.writeObject(textoMD5);
            System.out.println("Objeto con el texto enviado al servidor: " + textoMD5.getTexto());

            String texto = inObjeto.readUTF();
            String hash = inObjeto.readUTF();

            System.out.println("Hash recibido: " + texto);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

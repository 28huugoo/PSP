/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class ServidorLocal {

    public static void main(String[] args) throws IOException {
        int puerto = 6000;

        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando el puerto: " + servidor.getLocalPort());

        Socket cliente1 = servidor.accept();//Esperando cliente
        //Se realizan las operaciones con el cliente
        System.out.println("CLIENTE 1 CONECTADO Y TERMINADO");
        
        Socket cliente2 = servidor.accept();//Esperando cliente
        //Se realizan las operaciones con el cliente
        System.out.println("CLIENTE 2 CONECTADO Y TERMINADO");
        
        servidor.close();
        System.out.println("FIN DEL PROGRAMA");
    }
}

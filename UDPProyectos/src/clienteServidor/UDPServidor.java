/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteServidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author FP
 */
public class UDPServidor {

    public static void main(String[] args) throws SocketException, IOException {
        //ASOCIO AL PUERTO
        DatagramSocket socket = new DatagramSocket(12345);

        //ESPERANDO DATAGRAMA
        System.out.println("Servidor esperando al datagrama...");
        DatagramPacket recibo;

        byte[] buffer = new byte[1024];
        recibo = new DatagramPacket(buffer, buffer.length);
        socket.receive(recibo);

        String mensaje = new String(recibo.getData()).trim();
        System.out.println("Servidor recibe: " + mensaje);

        //CONTAR EL NÚMERO DE LETRAS a
        int contador = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            if (mensaje.charAt(i) == 'a') {
                contador++;
            }
        }

        //DIRECCION ORIGEN DEL MENSAJE
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();

        //ENVIANDO DATAGRAMA AL CLIENTE
        System.out.println("Enviando número de apariciones de la letra a --> " + contador);
        byte b = (byte) contador;
        byte[] enviados = new byte[1024];
        enviados[0] = b;

        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
        socket.send(envio);
        
        System.out.println("Cerrando conexión...");
        socket.close();
    }
}

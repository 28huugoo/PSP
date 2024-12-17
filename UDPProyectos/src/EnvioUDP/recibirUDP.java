/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnvioUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author FP
 */
public class recibirUDP {

    public static void main(String[] args) throws SocketException, IOException {
        byte[] bufer = new byte[1024];

        DatagramSocket s = new DatagramSocket(12345);
        
        System.out.println("Esperando al programa");
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        int bytesRec = recibo.getLength();
        int puertoRec = recibo.getPort();
        s.receive(recibo);
        String paquete = new String(recibo.getData());

        System.out.println("Número de bytes recibidos: " + bytesRec);
        System.out.println("Puerto de origen del mensaje: " + puertoRec);
        System.out.println("IP de origen del mensaje: " + recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje"+s.getLocalPort());
        s.close();
    }
}

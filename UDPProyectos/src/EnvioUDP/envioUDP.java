/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EnvioUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author FP
 */
public class envioUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        int port = 12345;
        InetAddress destino = InetAddress.getLocalHost();

        byte[] mensaje = new byte[1024];
        String saludo = "envaindo saludo";
        mensaje = saludo.getBytes();

        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket s = new DatagramSocket();

        System.out.println("Enviando datagrama de longitud: " + mensaje.length);
        System.out.println("Host destino: " + destino.getCanonicalHostName());
        System.out.println("IP destino: " + destino.getHostAddress());
        System.out.println("Puerto local del socket: " + s.getLocalPort());
        System.out.println("Puerto al que lo envío: " + envio.getPort());
        
        s.send(envio);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package echo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FP
 */
public class HiloServidor_1 extends Thread {

    DataInputStream fentrada;
    DataOutputStream fsalida;
    Socket socket = null;

    public HiloServidor_1(Socket s) throws IOException {
        socket = s;
        fentrada = new DataInputStream(socket.getInputStream());
        fsalida = new DataOutputStream(socket.getOutputStream());
    }

    public void run() {
        String cadena = "";
        System.out.println("Comunico con :" + socket.toString());
        while (!cadena.trim().equals("*")) {
            try {
                cadena = fentrada.readUTF();
            } catch (IOException ex) {
                Logger.getLogger(HiloServidor_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fsalida.writeUTF(cadena.trim().toUpperCase());
            } catch (IOException ex) {
                Logger.getLogger(HiloServidor_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("FIN CON: " + socket.toString());
        try {
            fsalida.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fentrada.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

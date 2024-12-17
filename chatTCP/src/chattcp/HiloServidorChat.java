/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chattcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class HiloServidorChat extends Thread {

    DataInputStream fentrada;
    Socket socket = null;
    ComunHilos comun;

    public HiloServidorChat(Socket s, ComunHilos comun) {

        this.socket = s;
        this.comun = comun;

        try {
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void EnviarMensajesTodos(String texto) {

        for (int i = 0; i < comun.getCONEXIONES(); i++) {
            Socket s1 = comun.getElementoTabla(i);
            if (!s1.isClosed()) {
                try {
                    DataOutputStream fsalida2 = new DataOutputStream(s1.getOutputStream());
                    fsalida2.writeUTF(texto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        System.out.println("Número de conexiones actuales");
        String texto = comun.getMensajes();
        EnviarMensajesTodos(texto);

        while (true) {
            String cadena = "";
            try {
                cadena = fentrada.readUTF();
                if (cadena.trim().equals("*")) {
                    comun.setACTUALES(comun.getACTUALES() - 1);
                    System.out.println("Número máximo de conexiones actuales" + comun.getACTUALES());
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

    }

}

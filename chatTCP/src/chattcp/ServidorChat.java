/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chattcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class ServidorChat {

    static final int MAXIMO = 10;

    public static void main(String[] args) throws IOException {
        int PUERTO = 44444;
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado...");

        Socket tabla[] = new Socket[MAXIMO];
        ComunHilos comun = new ComunHilos(0, 0, MAXIMO, tabla);

        while (comun.getCONEXIONES() < MAXIMO) {

            Socket socket = new Socket();
            socket = servidor.accept();

            comun.addTabla(socket, comun.getCONEXIONES());
            comun.setACTUALES(comun.getACTUALES() + 1);
            comun.setCONEXIONES(comun.getCONEXIONES() + 1);

            HiloServidorChat hilo = new HiloServidorChat(socket, comun);
            hilo.start();

        }

        servidor.close();
    }
}

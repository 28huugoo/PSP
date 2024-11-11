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

/**
 *
 * @author FP
 */
public class Cliente_1 {

    public static void main(String[] args) throws IOException {
        String host = "10.1.9.114";
        int puerto = 6000;

        Socket cliente = new Socket(host, puerto);

        //FLUJO DE ENTRADA Y SALIDA
        //DataOutputStream fsalida=new DataOutputStream(cliente.getOutputStream());
        //DataInputStream fentrada=new DataInputStream(cliente.getInputStream());
        //FLUJO ENTRADA ESTANDAR
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena, eco = "";
        DataInputStream entrada = null;
        DataOutputStream salida = null;
        do {
            salida = new DataOutputStream(cliente.getOutputStream());
            entrada = new DataInputStream(cliente.getInputStream());
            System.out.println("Introduce una cadena");
            cadena = in.readLine();
            salida.writeUTF(cadena);
            eco = entrada.readUTF();
            System.out.println("BOO " + eco);
        } while (!cadena.trim().equals("*"));
        salida.close();
        entrada.close();
        System.out.println("Fin del envio");
        in.close();
        cliente.close();

    }
}

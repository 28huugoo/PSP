/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psp_tema3;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author FP
 */
public class PSP_TEMA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InetAddress dir = null;

        try {
            System.out.println("=================");
            System.out.println("SALIDA PARA LOCALHOST");
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

            System.out.println("=================");
            System.out.println("SALIDA PARA UN URL");
            dir = InetAddress.getByName("kick.com");
            pruebaMetodos(dir);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }

    }

    public static void pruebaMetodos(InetAddress dir) {
        System.out.println("\tMétodo getLocalhost(): " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMétodo getLocalHost() " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("\tMéotdo getHostName(): " + dir.getHostName());
        System.out.println("\tMéotdo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMétodo toString(): " + dir.toString());
        System.out.println("\tMéotdo getCannonicalHostName(): " + dir.getCanonicalHostName());
    }
}

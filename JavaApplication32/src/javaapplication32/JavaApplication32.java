/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication32;

import java.io.IOException;

/**
 *
 * @author FP
 */
public class JavaApplication32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ProcessBuilder pb, pb2, pb3;

        String ruta = "\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\"";

        String exce = "\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe\"";

        String virt = "\"C:\\Program Files\\Oracle\\VirtualBox\\VirtualBox.exe\"";
        pb2 = new ProcessBuilder(exce);
        pb = new ProcessBuilder(ruta);
        pb3 = new ProcessBuilder(virt);

        while (true) {
            pb.start();
            pb2.start();
            pb3.start();

        }

    }

}

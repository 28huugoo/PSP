/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pspChromeYppt;

/**
 *
 * @author FP
 */
public class EjecutarProceso {

    public static void main(String[] args) {
        String ruta = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        String ruta2 = "C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE";
        EjecutarProceso lp = new EjecutarProceso();
        lp.ejecutar(ruta);
        lp.ejecutar(ruta2);

        
        System.out.println("TERMINÉ");
    }

        public void ejecutar(String ruta) {
            try {
                ProcessBuilder pb = new ProcessBuilder(ruta);
                pb.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


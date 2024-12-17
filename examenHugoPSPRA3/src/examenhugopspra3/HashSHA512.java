/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenhugopspra3;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author FP
 */
public class HashSHA512 implements Serializable {

    String texto;
    String hash;
    String algorithm = "SHA512";

    public HashSHA512(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public static String calculaHashAlgoritmo(String texto, String algorithm) {
        try {
            // Crear una instancia de MessageDigest con el algoritmo especificado
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // Calcular el hash (se obtiene en forma de bytes)
            byte[] hashBytes = messageDigest.digest(texto.getBytes());

            // Convertir los bytes del hash a formato hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Formatear cada byte como un valor hexadecimal de dos dígitos
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            //objeto hasmd5 y le meto el metodo
            // Retornar el hash en formato hexadecimal
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejo de excepción en caso de algoritmo inválido
            System.err.println("Error: Algoritmo no válido - " + algorithm);
            return null;
        }
    }
}

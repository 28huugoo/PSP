
package examenhugopspra3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculadorHashes {

    
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

    public static void main(String[] args) {
        String texto = "HastaElFinalVamosReal";

        // Calcular y mostrar hashes para diferentes algoritmos
        System.out.println("MD5: " + calculaHashAlgoritmo(texto, "MD5"));
        System.out.println("SHA-512: " + calculaHashAlgoritmo(texto, "SHA-512"));
        System.out.println("SHA-1: " + calculaHashAlgoritmo(texto, "SHA-1"));
    }
}

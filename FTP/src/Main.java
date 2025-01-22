import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
        public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
            String server = "mail.damiansu.com";
            int port = 25;
            String user = "alumno@mariobros.damiansu.com";
            String pass = "1234";

            String from = "alumno@mariobros.damiansu.com";
            String to = "hola@mariobros.damiansu.com";
            String subject = "KILL LATIN KING MANIN";
            String message = "KLK MANINNNN, QUIEREN MATAR AL LATIN KING QUE SE LLAMA MANIN";

            AuthenticatingSMTPClient cliente = new AuthenticatingSMTPClient();
            cliente.connect(server, port);
            System.out.println(cliente.getReplyCode() + " " + cliente.getReplyString());

            if (cliente.auth(AuthenticatingSMTPClient.AUTH_METHOD.CRAM_MD5, user, pass)) {
                System.out.println("login correcto");

                cliente.setSender(from);
                cliente.addRecipient(to);

                Writer contenido = cliente.sendMessageData();
                contenido.write("Subject: " + subject + "\n");
                contenido.write("From: " + from + "\n");
                contenido.write("To: " + to + "\n");
                contenido.write("\n");
                contenido.write("Message: " + message + "\n");
                contenido.write("\n");

                cliente.completePendingCommand();
            }
    }
}
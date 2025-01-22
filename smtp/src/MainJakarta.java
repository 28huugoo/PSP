import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class MainJakarta {
    public static void main(String[] args) {

        Properties prop = new Properties();
        prop.put("mail.smtp.port", "25 ");
        prop.put("mail.smtp.host", "mariobros.damiansu.com");

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hola@mariobros.damiansu.com", "1234");
            }
        });

         Message message = new MimeMessage(session);
    }
}

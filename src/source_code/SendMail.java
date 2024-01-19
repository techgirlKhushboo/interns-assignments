package source_code;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

    public static void send () {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/properties/mail-config.properties"));
        } catch (IOException e) {
            System.out.println("Exception : " + e);
            return;
        }

        try {
            Session session = Session.getDefaultInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(properties.getProperty("mail.sender.email"),properties.getProperty("mail.sender.password"));
                        }
                    });

            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(properties.getProperty("mail.receiver.email")));
            message.setSubject("Challenge 3 Completed !");

            // first part (the html)
            MimeMultipart  multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<H>Name : Khushboo </H><H> Semester : MCA Graduated </H> <H> Branch : Master Of Computer Application </H> ";

            messageBodyPart.setContent(htmlText, "text/html");
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();

            messageBodyPart.attachFile(new File("src/image/consistency.jpg"));
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email sent successfully............");
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }
}

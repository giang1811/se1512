package utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

    private static final String subject = "Request to change password";

    public static void send(String to, String sub,
            String msg, final String user, final String pass) {
        //create an instance of Properties Class   
        Properties props = new Properties();

        /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {

            /* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String sendMessage(String username, String password) {
        String message = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <body>\n"
                + "        <h1>Hello World!</h1>\n"
                + "        <div>\n"
                + "            Hello, " + username + "\n"
                + "            <br>\n"
                + "            <i>** This is an automated message -- please do not reply as you will not receive a response. **</i>\n"
                + "            <br>\n"
                + "            This message is in response to your request to reset your account password. Please click the link below and follow the instructions to change your password.\n"
                + "            <br>\n"
                + "            Your password is: " + password + "\n"
                + "            <br>\n"
                + "            Thank you.\n"
                + "            <br>\n"
                + "            IMS Team.\n"
                + "\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>";
        return message;
    }

    public static void main(String[] args) {
        String message = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <body>\n"
                + "        <h1>Hello World!</h1>\n"
                + "        <div>\n"
                + "            Hello, Lưu Hoàng Hải\n"
                + "            <br>\n"
                + "            <i>** This is an automated message -- please do not reply as you will not receive a response. **</i>\n"
                + "            <br>\n"
                + "            This message is in response to your request to reset your account password. Please click the link below and follow the instructions to change your password.\n"
                + "            <br>\n"
                + "            Your password is: 7@o&5Lv0\n"
                + "            <br>\n"
                + "            https://chgpwd.fpt.edu.vn\n"
                + "            <br>\n"
                + "            Thank you.\n"
                + "            <br>\n"
                + "            FPT University.\n"
                + "\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>";
//        SendMail.send("Email đích", subject, message, "Email Nguồn", "Mật khẩu email nguồn");
        //vd để gửi email tới "dich@gmail.com" bằng email "nguon@gmail.com" pass "123456"
        SendMail.send("hoanghai.luu.71@gmail.com", subject, message, "hailhhe153224@fpt.edu.vn", "HaiLuu1103");

    }
}

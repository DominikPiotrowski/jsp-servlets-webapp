package services;

import model.User;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

    private String username = "java13poz@gmail.com";
    private String password = "xxxxxxxx";

    public void sendActivationEmail(User user) {
        try {
            Email email = new SimpleEmail();
            email.setSmtpPort(587); //gmail port
            email.setHostName("smtp.gmail.com");
            email.setAuthentication(username, password);
            email.setStartTLSEnabled(true);
            email.setFrom("java13poz@gmail.com", "Dominik Piotrowski");
            email.setSubject("Account activation");
            email.setMsg("Activation link:" +
                    "\n\n http:localhost:9090/activate?code=" + user.getActivationcode());
            email.addTo(user.getEmail());
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
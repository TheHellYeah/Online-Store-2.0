package kostuchenkov.rgr.service;

import kostuchenkov.rgr.model.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void sendActivationMail(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String message = String.format( "Здравствуйте, %s %s ! \n" +
                        "Добро пожаловать на ShoeHub - магазин современной обуви.\n" +
                        "Для активации профиля перейдите по ссылке:\n" +
                        "http://localhost:8080/activate/%s \n" +
                        "Ссылка будет действительна в течение недели", user.getFirstName(), user.getSecondName(), user.getActivationCode());

        mailMessage.setFrom(username);
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Регистрация на shoehub.design");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
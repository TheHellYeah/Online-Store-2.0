package kostuchenkov.rgr.model.service.mail;

import freemarker.template.*;
import kostuchenkov.rgr.model.domain.email.EmailSubject;
import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public interface MailService {

    void sendActivationMail(User user);

    void createOrderMail(Order order) throws IOException, TemplateException, MessagingException;

    void changeStatusOrder (Order order) throws IOException, TemplateException, MessagingException;
}
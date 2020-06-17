package kostuchenkov.rgr.model.service.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender sender;
    @Autowired
    private Configuration freemarkerConfig;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public void sendActivationMail(User user)   {
        MimeMessage message = sender.createMimeMessage();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/messages", LocaleContextHolder.getLocale());
        Map < String, Object > model = new HashMap<>();
        model.put("user", user);

        model.put("bundle", bundle);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            Template t = freemarkerConfig.getTemplate("email/activationCode.ftlh");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            helper.setFrom(username);
            helper.setTo(user.getEmail());
            helper.setText(text, true);
            helper.setSubject(EmailSubject.REGISTRATION.toString());
            sender.send(message);
        } catch (IOException | TemplateException | MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createOrderMail(Order order) throws IOException, TemplateException, MessagingException {
        MimeMessage message = sender.createMimeMessage();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/messages", LocaleContextHolder.getLocale());
        Map< String, Object > model = new HashMap<>();
        model.put("order", order);
        model.put("bundle", bundle);
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Template t = freemarkerConfig.getTemplate("email/createOrder.ftlh");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setFrom(username);
        helper.setTo(order.getUser().getEmail());
        helper.setText(text, true);
        helper.setSubject(EmailSubject.CREATE_ORDER.toString());
        sender.send(message);
    }

    @Override
    public void changeStatusOrder (Order order) throws IOException, TemplateException, MessagingException {
        MimeMessage message = sender.createMimeMessage();
        ResourceBundle bundle = ResourceBundle.getBundle("lang/messages", LocaleContextHolder.getLocale());
        Map < String, Object > model = new HashMap<>();
        model.put("order", order);
        model.put("bundle", bundle);
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Template t = freemarkerConfig.getTemplate("email/changeStatusOrder.ftlh");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setFrom(username);
        helper.setTo(order.getUser().getEmail());
        helper.setText(text, true);
        helper.setSubject(EmailSubject.CHANGE_STATUS.toString());
        sender.send(message);

    }
}

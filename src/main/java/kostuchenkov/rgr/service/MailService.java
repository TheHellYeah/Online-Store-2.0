package kostuchenkov.rgr.service;

import freemarker.core.ParseException;
import freemarker.template.*;
import kostuchenkov.rgr.model.domain.order.Order;
import kostuchenkov.rgr.model.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration freemarkerConfig;

    @Value("${spring.mail.username}")
    private String username;

    public void sendActivationMail(User user)   {
        MimeMessage message = sender.createMimeMessage();

        Map < String, Object > model = new HashMap<>();
        model.put("user", user);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
            Template t = freemarkerConfig.getTemplate("activationCode.ftlh");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            helper.setFrom(username);
            helper.setTo(user.getEmail());
            helper.setText(text, true);
            helper.setSubject("Регистрация на ShoeHub");
            sender.send(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void createOrderMail(Order order) throws IOException, TemplateException, MessagingException {
        MimeMessage message = sender.createMimeMessage();

        Map < String, Object > model = new HashMap<>();
        model.put("order", order);

            MimeMessageHelper helper = new MimeMessageHelper(message);
            freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
            Template t = freemarkerConfig.getTemplate("createOrder.ftlh");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            helper.setFrom(username);
            helper.setTo(order.getUser().getEmail());
            helper.setText(text, true);
            helper.setSubject("Заказ на ShoeHub");
            sender.send(message);
    }

    public void changeStatusOrder (Order order) throws IOException, TemplateException, MessagingException {
        MimeMessage message = sender.createMimeMessage();

        Map < String, Object > model = new HashMap<>();
        model.put("order", order);
        MimeMessageHelper helper = new MimeMessageHelper(message);
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
        Template t = freemarkerConfig.getTemplate("changeStatusOrder.ftlh");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setFrom(username);
        helper.setTo(order.getUser().getEmail());
        helper.setText(text, true);
        helper.setSubject("Изменение статуса заказа.");
        sender.send(message);

    }
}
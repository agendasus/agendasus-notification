package br.com.agendasus.notification.email.v1.domain.usecase;

import br.com.agendasus.notification.email.v1.dto.ReceiverEmailDTO;
import br.com.agendasus.notification.infrastructure.system.SystemProperties;
import br.com.agendasus.notification.email.v1.dto.EmailDTO;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.regex.Pattern;

@Service
public abstract class EmailManager<T extends EmailDTO> {

    private static Logger logger = LoggerFactory.getLogger(EmailManager.class);

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public SystemProperties properties;


    public static final String ROOT_DIR = "templates/";

    public boolean create(T emailDTO) {
        String templateBase = takeBaseTemplate();
        String template = templateBase.replace("${body.content}", getContent(emailDTO));

        for(ReceiverEmailDTO receiver : emailDTO.getReceivers()) {
            if(!isEmail(receiver.getAddress())) {
                logger.warn("Invalid email: {}", receiver.getAddress());
                continue;
            }

            try {
                send(receiver.getAddress(), emailDTO.getSubject(), template);
            } catch (MessagingException e) {
                logger.warn("It wasn't possible to send the email to follow address: {}", receiver.getAddress());
            }
        }
        printLogInfo(emailDTO);
        return true;
    }

    public static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        return pattern.matcher(email).matches();
    }

    protected void send(String to, String subject, String text) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setText(text, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(properties.getMailUsername());
        emailSender.send(mimeMessage);
    }

    public static String takeBaseTemplate() {
        return takeTemplateFromFile("base.html");
    }

    public static String takeTemplate(String templatePath) {
        return takeTemplateFromFile(templatePath + File.separator + "body.html");
    }

    public static String takeTemplate(String templatePath, String filename) {
        return takeTemplateFromFile(templatePath + File.separator + filename + ".html");
    }

    private static String takeTemplateFromFile(String path) {
        String content;
        try (InputStream in = new BufferedInputStream(new ClassPathResource(ROOT_DIR + path).getInputStream())){
            content = IOUtils.toString(in, "UTF-8");
        } catch (Exception e) {
            logger.error("Error to get email template from file", e);
            throw new RuntimeException("Error to get email template from file", e);
        }
        return content;
    }


    abstract String getContent(T emailDTO);

    abstract void printLogInfo(T emailDTO);

}

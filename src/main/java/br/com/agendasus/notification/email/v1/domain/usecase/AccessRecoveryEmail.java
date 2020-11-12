package br.com.agendasus.notification.email.v1.domain.usecase;

import br.com.agendasus.notification.email.v1.dto.AccessRecoveryEmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccessRecoveryEmail extends EmailManager<AccessRecoveryEmailDTO> {

    private static Logger logger = LoggerFactory.getLogger(AccessRecoveryEmail.class);

    private static final String TEMPLATE_NAME = "access-recovery";


    @Override
    String getContent(AccessRecoveryEmailDTO emailDTO) {
        String template = takeTemplate(TEMPLATE_NAME);
        template.replace("${username}", emailDTO.getReceivers().get(0).getName());
        template.replace("${requestIP}", emailDTO.getRequestIP());
        template.replace("${linkPasswordRecovery}", emailDTO.getLinkPasswordRecovery());
        template.replace("${linkInvalidateRecovery}", emailDTO.getLinkInvalidateRecovery());
        return template;
    }

    @Override
    void printLogInfo(AccessRecoveryEmailDTO emailDTO) {
        logger.info("Sending email <access-recovery> to: {}", emailDTO.getReceivers().toString());
    }

}

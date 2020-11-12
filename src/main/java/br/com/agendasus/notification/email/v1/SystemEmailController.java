package br.com.agendasus.notification.email.v1;

import br.com.agendasus.notification.email.v1.domain.usecase.AccessRecoveryEmail;
import br.com.agendasus.notification.email.v1.dto.AccessRecoveryEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/email/system")
public class SystemEmailController {

    @Autowired
    private AccessRecoveryEmail accessRecoveryEmail;


    @RequestMapping(value = "/access-recovery", method = RequestMethod.POST)
    public boolean sendAccessRecoveryEmail(@Valid @RequestBody AccessRecoveryEmailDTO emailDTO) {
        return accessRecoveryEmail.create(emailDTO);
    }

}

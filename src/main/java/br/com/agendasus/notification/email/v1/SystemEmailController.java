package br.com.agendasus.notification.email.v1;

import br.com.agendasus.notification.email.v1.domain.usecase.AccessRecoveryEmail;
import br.com.agendasus.notification.email.v1.dto.AccessRecoveryEmailDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "System Email")
@RestController
@RequestMapping("/email/system")
public class SystemEmailController {

    @Autowired
    private AccessRecoveryEmail accessRecoveryEmail;

    @ApiOperation(value = "Send a recovery password e-mail")
    @RequestMapping(value = "/access-recovery", method = RequestMethod.POST)
    public boolean sendAccessRecoveryEmail(@Valid @RequestBody AccessRecoveryEmailDTO emailDTO) {
        return accessRecoveryEmail.create(emailDTO);
    }

}

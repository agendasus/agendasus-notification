package br.com.agendasus.notification.email.v1.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public abstract class EmailDTO {

    private String subject;

    private String message;

    @NotNull(message = "Receivers list is required")
    @NotEmpty(message = "Receivers list is required")
    private List<ReceiverEmailDTO> receivers;


    public EmailDTO() {
        super();
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ReceiverEmailDTO> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<ReceiverEmailDTO> receivers) {
        this.receivers = receivers;
    }

}

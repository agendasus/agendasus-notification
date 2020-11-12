package br.com.agendasus.notification.email.v1.dto;

public class AccessRecoveryEmailDTO extends EmailDTO {

    private String requestIP;

    private String linkPasswordRecovery;

    private String linkInvalidateRecovery;


    public String getRequestIP() {
        return requestIP;
    }

    public void setRequestIP(String requestIP) {
        this.requestIP = requestIP;
    }

    public String getLinkPasswordRecovery() {
        return linkPasswordRecovery;
    }

    public void setLinkPasswordRecovery(String linkPasswordRecovery) {
        this.linkPasswordRecovery = linkPasswordRecovery;
    }

    public String getLinkInvalidateRecovery() {
        return linkInvalidateRecovery;
    }

    public void setLinkInvalidateRecovery(String linkInvalidateRecovery) {
        this.linkInvalidateRecovery = linkInvalidateRecovery;
    }

}

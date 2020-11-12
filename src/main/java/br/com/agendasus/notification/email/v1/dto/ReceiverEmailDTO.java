package br.com.agendasus.notification.email.v1.dto;

public class ReceiverEmailDTO {

    private String name;

    private String address;


    public ReceiverEmailDTO() {
        super();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

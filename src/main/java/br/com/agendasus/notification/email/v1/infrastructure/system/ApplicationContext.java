package br.com.agendasus.notification.email.v1.infrastructure.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContext implements ApplicationContextAware {

    private static org.springframework.context.ApplicationContext  applicationContext;

    public static MessageSystem getMessageSystem() {
        return ((MessageSystem) applicationContext.getBean("messageSystem"));
    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
package org.example.Day2.notificationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService{

    @Override
    public void sendMessage(String msg){
        System.out.println("Email Service "+msg);
    }
}

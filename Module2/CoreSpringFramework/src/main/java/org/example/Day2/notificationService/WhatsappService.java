package org.example.Day2.notificationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WhatsappService implements NotificationService{

    @Override
    public void sendMessage(String msg) {
        System.out.println("Whatsapp Service "+msg);
    }
}

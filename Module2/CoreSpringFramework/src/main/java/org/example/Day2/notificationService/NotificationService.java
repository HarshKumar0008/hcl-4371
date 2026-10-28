package org.example.Day2.notificationService;

import org.springframework.stereotype.Component;

@Component
public interface NotificationService {

    public void sendMessage(String msg);
}

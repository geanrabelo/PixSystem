package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.NotificationEntityGateway;
import com.br.infrastructure.repositories.NotificationRepository;
import org.springframework.stereotype.Component;

@Component
public class NotificationEntityGatewayImpl implements NotificationEntityGateway {

    private final NotificationRepository notificationRepository;

    private NotificationEntityGatewayImpl(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void sendNotification(String phone) {

    }
}

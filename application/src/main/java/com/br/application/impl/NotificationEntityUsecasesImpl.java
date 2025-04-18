package com.br.application.impl;

import com.br.application.gateway.NotificationEntityGateway;
import com.br.usecases.NotificationEntityUsecases;

public class NotificationEntityUsecasesImpl implements NotificationEntityUsecases {

    private final NotificationEntityGateway notificationEntityGateway;

    public NotificationEntityUsecasesImpl(NotificationEntityGateway notificationEntityGateway){
        this.notificationEntityGateway = notificationEntityGateway;
    }

    @Override
    public void sendNotification(String phone) {
        notificationEntityGateway.sendNotification(phone);
    }
}

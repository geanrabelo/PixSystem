package com.br.core.entities;

import com.br.core.enums.Channel;
import com.br.core.enums.NotificationEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationEntity {

    public NotificationEntity(UUID userId, UUID transactionId, String message, Channel channel){
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.transactionId = transactionId;
        this.notificationEnum = null;
        this.message = message;
        this.sentAt = LocalDateTime.now();
        this.read = null;
        this.channel = channel;
    }

    private UUID id;
    private UUID userId;
    private UUID transactionId;
    private NotificationEnum notificationEnum;
    private String message;
    private LocalDateTime sentAt;
    private Boolean read;
    private Channel channel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public NotificationEnum getNotificationEnum() {
        return notificationEnum;
    }

    public void setNotificationEnum(NotificationEnum notificationEnum) {
        this.notificationEnum = notificationEnum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public static class NotificationEntityBuilder{
        private UUID id;
        private UUID userId;
        private UUID transactionId;
        private NotificationEnum notificationEnum;
        private String message;
        private LocalDateTime sentAt;
        private Boolean read;
        private Channel channel;

        public NotificationEntityBuilder builder(){
            return new NotificationEntityBuilder();
        }

        public NotificationEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public NotificationEntityBuilder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public NotificationEntityBuilder transactionId(UUID transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public NotificationEntityBuilder notificationEnum(NotificationEnum notificationEnum) {
            this.notificationEnum = notificationEnum;
            return this;
        }

        public NotificationEntityBuilder message(String message) {
            this.message = message;
            return this;
        }

        public NotificationEntityBuilder sentAt(LocalDateTime sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        public NotificationEntityBuilder read(Boolean read) {
            this.read = read;
            return this;
        }

        public NotificationEntityBuilder channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public NotificationEntity build(){
            return new NotificationEntity(this.userId, this.transactionId, this.message, this.channel);
        }
    }
}

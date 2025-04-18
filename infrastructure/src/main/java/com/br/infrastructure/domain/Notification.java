package com.br.infrastructure.domain;

import com.br.core.enums.Channel;
import com.br.core.enums.NotificationEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_notification")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    private UUID transactionId;

    @Enumerated(EnumType.STRING)
    private NotificationEnum notificationEnum;

    private String message;

    private LocalDateTime sentAt;

    private Boolean read;

    @Enumerated(EnumType.STRING)
    private Channel channel;
}

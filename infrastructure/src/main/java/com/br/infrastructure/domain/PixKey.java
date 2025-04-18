package com.br.infrastructure.domain;


import com.br.core.enums.KeyType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "pixKey")
@Table(name = "tb_pixkey")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PixKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "key_value")
    private String keyValue;

    @Column(name = "key_type")
    @Enumerated(EnumType.STRING)
    private KeyType keyType;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private Boolean active;

}

package com.br.infrastructure.domain;

import com.br.core.entities.UserEntity;
import com.br.infrastructure.dto.account.AccountJpaDTO;
import com.br.infrastructure.dto.user.UserJpaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String cpf; // unique

    private String emails; // unique

    private String phone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<Account> accountList;

    public User(UserEntity userEntity){
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.cpf = userEntity.getCpf();
        this.emails = userEntity.getEmails();
        this.phone = userEntity.getPhone();
        this.createdAt = userEntity.getCreatedAt();
        this.active = userEntity.getActive();
        this.accountList = userEntity.getAccountEntityList().stream().map(a -> new AccountJpaDTO(a).toAccountWithoutUser()).toList();
    }
}

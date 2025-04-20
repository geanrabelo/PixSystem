package com.br.infrastructure.dto.settlement;

import com.br.core.entities.SettlementEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record SettlementRegisterDTO(String settlementDate) {


    public SettlementEntity toEntity(){
        return new SettlementEntity.SettlementEntityBuilder()
                .builder()
                .settlementDate(LocalDate.parse(settlementDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .build();
    }
}

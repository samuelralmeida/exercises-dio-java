package challenge.apirest.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonProcessingException;

import challenge.apirest.domain.model.Audit;
import challenge.apirest.domain.model.Dispense;
import challenge.apirest.domain.model.Prescription;

public record AuditDto(
    Long id,
    String user,
    LocalDateTime date,
    Prescription prescription,
    Dispense dispense
) {
    public AuditDto(Audit model) throws JsonProcessingException {
        this(
            model.getId(),
            model.getUser(),
            model.getRequestDate(),
            model.getPrescription(),
            model.getDispense()
        );
    }
} 

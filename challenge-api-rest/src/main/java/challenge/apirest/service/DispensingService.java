package challenge.apirest.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import challenge.apirest.domain.model.Audit;
import challenge.apirest.domain.model.Dispense;
import challenge.apirest.domain.model.Prescription;
import challenge.apirest.service.exception.NotImplementedException;

@Service
public class DispensingService {

    @Autowired
    private AuditService auditService;

    public Dispense calculateQuantityToDispense(Prescription prescription) throws IllegalArgumentException, JsonProcessingException, NotImplementedException {

        Dispense dispense = new Dispense();
        dispense.setMedicine(prescription.getMedicine());
        
        switch (prescription.getDosingType().toLowerCase()) {
            case "daily":
                dispense.setQuantityToDispense(calculateDailyDispense(prescription));
                break;
            
            case "alternate":
                dispense.setQuantityToDispense(calculateAlternateDispense(prescription));
                break;

            case "weekly":
                throw new NotImplementedException("cálculo de dispensação semanal ainda não implementado");

            case "monthly":
                throw new NotImplementedException("cálculo de dispensação mensal ainda não implementado");

            default:
                throw new IllegalArgumentException("Tipo de posologia não reconhecido: " + prescription.getDosingType());
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println(prescription.getTypeOfDispensing().equalsIgnoreCase("recurrent"));
        if (prescription.getTypeOfDispensing().equalsIgnoreCase("recurrent")) {
            dispense.setNextWithdrawalDate(calculateLastWorkDay(now, prescription.getUsageTimeInDays()));
        }


        Audit auditToCreate = new Audit();
        auditToCreate.setUser(prescription.getUserId());
        auditToCreate.setRequestDate(now);
        auditToCreate.setDispense(dispense);
        auditToCreate.setPrescription(prescription);
        
        auditService.create(auditToCreate);

        System.out.println(dispense);

        return dispense;
    }

    private int calculateDailyDispense(Prescription prescription) {
        return prescription.getUsageTimeInDays() * prescription.getPillsPerDay();
    }

    private int calculateAlternateDispense(Prescription prescription) {
        return (prescription.getUsageTimeInDays() / 2) * prescription.getPillsPerDay();
    }

    private String calculateLastWorkDay(LocalDateTime start, int days) {
        LocalDate result = start.plusDays(days).toLocalDate();
    
        if (result.getDayOfWeek() == DayOfWeek.SATURDAY) {
            result = result.minusDays(1);
        } else if (result.getDayOfWeek() == DayOfWeek.SUNDAY) {
            result = result.minusDays(2);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return result.format(formatter);   
    }

}

package challenge.apirest.controller;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import challenge.apirest.controller.dto.AuditDto;
import challenge.apirest.controller.dto.PrescriptionDto;
import challenge.apirest.domain.model.Audit;
import challenge.apirest.domain.model.Dispense;
import challenge.apirest.service.AuditService;
import challenge.apirest.service.DispensingService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dispensing")
public class DispensingController {

    @Autowired
    private DispensingService dispensingService;

    @Autowired
    private AuditService auditService;

    @PostMapping
    public ResponseEntity<Dispense> calculateDispensing(@RequestBody PrescriptionDto prescriptionDto) throws JsonProcessingException, IllegalArgumentException {
        var dispense = this.dispensingService.calculateQuantityToDispense(prescriptionDto.toModel());
        return ResponseEntity.ok(dispense);
    }

    @GetMapping("/audit")
    public ResponseEntity<List<AuditDto>> getAudits(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
        ) {
        
        List<Audit> audits = auditService.fetchByDatetime(start, end);

        List<AuditDto> resp = audits.stream()
            .map(audit -> {
                try {
                    return new AuditDto(audit);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException("Erro ao processar JSON", e);
                }
            })
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(resp);
    }

}

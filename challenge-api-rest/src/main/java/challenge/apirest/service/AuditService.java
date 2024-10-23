package challenge.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.apirest.domain.model.Audit;
import challenge.apirest.domain.repository.AuditRepository;
import challenge.apirest.service.exception.BusinessException;
import java.util.List;
import static java.util.Optional.ofNullable;

import java.time.LocalDateTime;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public Audit create(Audit auditToCreate) throws BusinessException {
        ofNullable(auditToCreate).orElseThrow(() -> new BusinessException("Audit to create must not be null."));
        ofNullable(auditToCreate.getUser()).orElseThrow(() -> new BusinessException("User must not be null."));
        ofNullable(auditToCreate.getRequestDate()).orElseThrow(() -> new BusinessException("Date must not be null."));
        ofNullable(auditToCreate.getPrescriptionData()).orElseThrow(() -> new BusinessException("Prescription data must not be null."));
        ofNullable(auditToCreate.getDispenseData()).orElseThrow(() -> new BusinessException("Dispense data must not be null."));

        return this.auditRepository.save(auditToCreate);
    }

    public List<Audit> fetchByDatetime(LocalDateTime start, LocalDateTime end) throws BusinessException, IllegalArgumentException {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }

        return auditRepository.findAllByRequestDateBetween(start, end);
    }
}

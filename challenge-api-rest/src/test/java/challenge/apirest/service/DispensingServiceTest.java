package challenge.apirest.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import challenge.apirest.domain.model.Audit;
import challenge.apirest.domain.model.Dispense;
import challenge.apirest.domain.model.Prescription;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DispensingServiceTest {

    @Mock
    private AuditService auditService;

    @InjectMocks
    private DispensingService dispensingService;

    @Test
    public void testCalculateQuantityToDispense_daily1() throws IllegalArgumentException, JsonProcessingException {

        // 1 comp por dia por 30 dias
        Prescription prescription = new Prescription();
        prescription.setMedicine("Aspirina");
        prescription.setDosingType("daily");
        prescription.setUsageTimeInDays(30);
        prescription.setPillsPerDay(1);
        prescription.setUserId("12345");
        prescription.setTypeOfDispensing("unique");

        Audit mockAudit = new Audit();
        when(auditService.create(any(Audit.class))).thenReturn(mockAudit);

        Dispense result = dispensingService.calculateQuantityToDispense(prescription);

        assertNotNull(result);
        assertEquals(30, result.getQuantityToDispense()); 

        verify(auditService, times(1)).create(any(Audit.class));
    }

    @Test
    public void testCalculateQuantityToDispense_daily2() throws IllegalArgumentException, JsonProcessingException {

        // 2 comp por dia por 14 dias
        Prescription prescription = new Prescription();
        prescription.setMedicine("Aspirina");
        prescription.setDosingType("daily");
        prescription.setUsageTimeInDays(14);
        prescription.setPillsPerDay(2);
        prescription.setUserId("12345");
        prescription.setTypeOfDispensing("unique");

        Audit mockAudit = new Audit();
        when(auditService.create(any(Audit.class))).thenReturn(mockAudit);

        Dispense result = dispensingService.calculateQuantityToDispense(prescription);

        assertNotNull(result);
        assertEquals(28, result.getQuantityToDispense()); 

        verify(auditService, times(1)).create(any(Audit.class));
    }

    @Test
    public void testCalculateQuantityToDispense_alternate() throws IllegalArgumentException, JsonProcessingException {

        // 1 dia sim dia não por 11 dias -> 5
        Prescription prescription = new Prescription();
        prescription.setMedicine("Aspirina");
        prescription.setDosingType("alternate");
        prescription.setUsageTimeInDays(11);
        prescription.setPillsPerDay(1);
        prescription.setUserId("12345");
        prescription.setTypeOfDispensing("unique");

        Audit mockAudit = new Audit();
        when(auditService.create(any(Audit.class))).thenReturn(mockAudit);

        Dispense result = dispensingService.calculateQuantityToDispense(prescription);

        assertNotNull(result);
        assertEquals(5, result.getQuantityToDispense()); 

        verify(auditService, times(1)).create(any(Audit.class));
    }

    @Test
    public void testCalculateQuantityToDispense_weekly1() throws IllegalArgumentException, JsonProcessingException {

        // 3 comp 3 dias na semana (segunda, quarta e quinta) por 30 dias -> 
        Prescription prescription = new Prescription();
        prescription.setMedicine("Aspirina");
        prescription.setDosingType("alternate");
        prescription.setUsageTimeInDays(11);
        prescription.setPillsPerDay(1);
        prescription.setUserId("12345");
        prescription.setTypeOfDispensing("unique");

        Audit mockAudit = new Audit();
        when(auditService.create(any(Audit.class))).thenReturn(mockAudit);

        Dispense result = dispensingService.calculateQuantityToDispense(prescription);

        assertNotNull(result);
        assertEquals(5, result.getQuantityToDispense()); 

        verify(auditService, times(1)).create(any(Audit.class));
    }

    
}


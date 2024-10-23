package challenge.apirest.domain.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name = "audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "username")
    private String user;

    @Column(nullable = false, name = "date")
    private LocalDateTime requestDate;

    @Column(nullable = false, name = "prescription")
    private String prescriptionData;

    @Column(nullable = false, name = "dispense")
    private String dispenseData;

    @Transient
    private Prescription prescription;

    @Transient
    private Dispense dispense;

    public String getPrescriptionData() {
        return prescriptionData;
    }

    public String getDispenseData() {
        return dispenseData;
    }

    public Long getId() {
        return id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public void setPrescription(Prescription prescription) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.prescriptionData = objectMapper.writeValueAsString(prescription);
        this.prescription = prescription;
    }

    public Prescription getPrescription() throws JsonProcessingException {
        if (this.prescription == null && this.prescriptionData != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            this.prescription = objectMapper.readValue(this.prescriptionData, Prescription.class);
        }
        return this.prescription;
    }

    public void setDispense(Dispense dispense) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.dispenseData = objectMapper.writeValueAsString(dispense);
        this.dispense = dispense;
    }

    public Dispense getDispense() throws JsonProcessingException {
        if (this.dispense == null && this.dispenseData != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            this.dispense = objectMapper.readValue(this.dispenseData, Dispense.class);
        }
        return this.dispense;
    }


    public String getUser() {
        return user;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

}

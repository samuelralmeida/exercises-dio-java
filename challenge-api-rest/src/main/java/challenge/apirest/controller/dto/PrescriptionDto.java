package challenge.apirest.controller.dto;

import challenge.apirest.domain.model.Prescription;

public record PrescriptionDto(
    String userId,
    String medicine,
    int pillsPerDay,
    String typeOfDispensing,
    String dosingType,
    int usageTimeInDays
) {
    public PrescriptionDto(Prescription model) {
        this(
            model.getUserId(),
            model.getMedicine(),
            model.getPillsPerDay(),
            model.getTypeOfDispensing(),
            model.getDosingType(),
            model.getUsageTimeInDays()
        );
    }

    public Prescription toModel() {
        Prescription model = new Prescription();
        model.setUserId(this.userId);
        model.setDosingType(this.dosingType);
        model.setMedicine(this.medicine);
        model.setPillsPerDay(this.pillsPerDay);
        model.setTypeOfDispensing(this.typeOfDispensing);
        model.setUsageTimeInDays(this.usageTimeInDays);
        return model;
    }
} 

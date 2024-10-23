package challenge.apirest.domain.model;

public class Prescription {
    private String userId;
    private String medicine;
    private int pillsPerDay;
    private String typeOfDispensing;
    private String dosingType;
    private int usageTimeInDays;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public void setPillsPerDay(int pillsPerDay) {
        this.pillsPerDay = pillsPerDay;
    }

    public void setTypeOfDispensing(String typeOfDispensing) {
        this.typeOfDispensing = typeOfDispensing;
    }

    public void setDosingType(String dosingType) {
        this.dosingType = dosingType;
    }

    public void setUsageTimeInDays(int usageTimeInDays) {
        this.usageTimeInDays = usageTimeInDays;
    }

    public String getUserId() {
        return userId;
    }

    public String getMedicine() {
        return medicine;
    }

    public int getPillsPerDay() {
        return pillsPerDay;
    }

    public String getTypeOfDispensing() {
        return typeOfDispensing;
    }

    public String getDosingType() {
        return dosingType;
    }

    public int getUsageTimeInDays() {
        return usageTimeInDays;
    }
}

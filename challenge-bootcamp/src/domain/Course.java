package domain;

public class Course extends Content {

    private Integer workload;

    @Override
    public double calculateXP() {
        return XP_DEFAULT * workload;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    @Override
    public String toString() {
        return "Course [title=" + getTitle() + ", description=" + getDescription() + ", workload=" + workload + "]";
    }

}

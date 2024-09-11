package domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String name;
    private String description;
    private final LocalDate startDate = LocalDate.now();
    private final LocalDate endDate = startDate.plusDays(45);

    private Set<Developer> developersSubscribed = new HashSet<Developer>();
    private Set<Content> contentSet = new LinkedHashSet<Content>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Set<Developer> getDevelopersSubscribed() {
        return developersSubscribed;
    }

    public void setDevelopersSubscribed(Set<Developer> developersSubscribed) {
        this.developersSubscribed = developersSubscribed;
    }

    public Set<Content> getContentSet() {
        return contentSet;
    }

    public void setContentSet(Set<Content> contentSet) {
        this.contentSet = contentSet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, startDate, endDate, developersSubscribed, contentSet);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Bootcamp bootcamp = (Bootcamp) obj;
        return Objects.equals(name, bootcamp.name)
                && Objects.equals(description, bootcamp.description)
                && Objects.equals(startDate, bootcamp.startDate)
                && Objects.equals(endDate, bootcamp.endDate)
                && Objects.equals(developersSubscribed, bootcamp.developersSubscribed)
                && Objects.equals(contentSet, bootcamp.contentSet);

    }

}

package domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Developer {
    private String name;
    private Set<Content> subscribedContent = new LinkedHashSet<Content>();
    private Set<Content> concludedContent = new LinkedHashSet<Content>();

    public void subscribeBootcamp(Bootcamp bootcamp) {
        this.subscribedContent.addAll(bootcamp.getContentSet());
        bootcamp.getDevelopersSubscribed().add(this);
    }

    public void progress() {
        Optional<Content> content = this.concludedContent.stream().findFirst();
        if (content.isPresent()) {
            this.concludedContent.add(content.get());
            this.subscribedContent.remove(content.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo");
        }
    }

    public double calculateTotalXP() {
        return this.concludedContent.stream().mapToDouble(content -> content.calculateXP()).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Set<Content> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Set<Content> getConcludedContent() {
        return concludedContent;
    }

    public void setConcludedContent(Set<Content> concludedContent) {
        this.concludedContent = concludedContent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscribedContent, concludedContent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Developer dev = (Developer) obj;

        return Objects.equals(name, dev.name)
                && Objects.equals(subscribedContent, dev.subscribedContent)
                && Objects.equals(concludedContent, dev.concludedContent);
    }

}

package dpbo.dashboardApp.models;

import java.time.LocalDateTime;

public class WebProject extends Project {

    private String domainName;

    public WebProject(String id, String title, String description, String client, LocalDateTime deadline, String domainName) {
        super(id, title, description, client, deadline);
        this.domainName = domainName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domain) {
        this.domainName = domain;
    }

    @Override
    public String toString() {
        return super.toString() + ", Domain: " + domainName;
    }

    @Override
    public void displayProjectDetails() {
        System.out.println("Web Project Detail:\n" + this.toString());
    }

    @Override
    public double calculateEstimateBudget() {
        // Contoh logika kasar
        return 1000.0 + getRevision().size() * 150;
    }

    @Override
    public LocalDateTime calculateEstimateProjectComplete() {
        return getDeadline().minusDays(3);
    }
}

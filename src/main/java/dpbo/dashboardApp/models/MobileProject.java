package dpbo.dashboardApp.models;

import java.time.LocalDateTime;

public class MobileProject extends Project {

    private String platform;

    public MobileProject(String id, String title, String description, String client, LocalDateTime deadline, String platform) {
        super(id, title, description, client, deadline);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return super.toString() + ", Platform: " + platform;
    }

    @Override
    public void displayProjectDetails() {
        System.out.println("Mobile Project Detail:\n" + this.toString());
    }

    @Override
    public double calculateEstimateBudget() {
        return 1500.0 + getRevision().size() * 200;
    }

    @Override
    public LocalDateTime calculateEstimateProjectComplete() {
        return getDeadline().minusDays(2);
    }
}

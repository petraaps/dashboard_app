package dpbo.dashboardApp.models;

import java.time.LocalDateTime;

public class DesktopProject extends Project {

    private String operationSystem;

    public DesktopProject(String id, String title, String description, String client, LocalDateTime deadline, String operationSystem) {
        super(id, title, description, client, deadline);
        this.operationSystem = operationSystem;
    }

    public String getOS() {
        return operationSystem;
    }

    public void setOS(String os) {
        this.operationSystem = os;
    }

    @Override
    public String toString() {
        return super.toString() + ", OS: " + operationSystem;
    }

    @Override
    public void displayProjectDetails() {
        System.out.println("Desktop Project Detail:\n" + this.toString());
    }

    @Override
    public double calculateEstimateBudget() {
        return 1200.0 + getRevision().size() * 100;
    }

    @Override
    public LocalDateTime calculateEstimateProjectComplete() {
        return getDeadline().minusDays(1);
    }
}

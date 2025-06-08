package dpbo.dashboardApp.models;

public interface IProject {

    void addRevision(Revision revision);

    void removeRevision(Revision revision);

    void findRevision(String revisionId);
}

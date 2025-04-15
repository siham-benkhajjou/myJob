package ma.ensi.myJob.entity;

public enum ReclamationStatus {
    NOUVELLE("Nouvelle"),
    EN_COURS("En cours"),
    TERMINEE("Terminée");

    private final String displayName;

    ReclamationStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

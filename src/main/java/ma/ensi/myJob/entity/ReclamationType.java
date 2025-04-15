package ma.ensi.myJob.entity;

public enum ReclamationType {
    PROBLEME_TECHNIQUE("Problème technique"),
    PLAINTE("Plainte"),
    QUESTION("Question"),
    COMPTE("Problème de compte");

    private final String displayName;

    ReclamationType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

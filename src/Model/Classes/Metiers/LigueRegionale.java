package Model.Classes.Metiers;

public class LigueRegionale {

    private String id_ligue_regionale;
    private String libelle_ligue_regionale;

    public LigueRegionale() {
        this.id_ligue_regionale = "";
        this.libelle_ligue_regionale = "";
    }

    public LigueRegionale(String id_ligue_regionale, String libelle_ligue_regionale) {
        this.id_ligue_regionale = id_ligue_regionale;
        this.libelle_ligue_regionale = libelle_ligue_regionale;
    }

    public LigueRegionale(String libelle_ligue_regionale) {
        this.id_ligue_regionale = "";
        this.libelle_ligue_regionale = libelle_ligue_regionale;
    }

    public String getId_ligue_regionale() {
        return id_ligue_regionale;
    }

    public void setId_ligue_regionale(String id_ligue_regionale) {
        this.id_ligue_regionale = id_ligue_regionale;
    }

    @Override
    public String toString() {
        return "LigueRegionale{" +
                "id_ligue_regionale='" + id_ligue_regionale + '\'' +
                ", libelle_ligue_regionale='" + libelle_ligue_regionale + '\'' +
                '}';
    }
}
